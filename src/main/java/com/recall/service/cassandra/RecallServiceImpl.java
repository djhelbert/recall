package com.recall.service.cassandra;

import com.recall.api.EmailResponse;
import com.recall.api.NameResponse;
import com.recall.api.RecallRequest;
import com.recall.api.RecallResponse;
import com.recall.model.Email;
import com.recall.model.Name;
import com.recall.model.Statistics;
import com.recall.service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RecallServiceImpl implements RecallService {
    private NameTableRepo nameTableRepo;
    private EmailTableRepo emailTableRepo;

    @Autowired
    public RecallServiceImpl(NameTableRepo nameTableRepo, EmailTableRepo emailTableRepo) {
        this.nameTableRepo = nameTableRepo;
        this.emailTableRepo = emailTableRepo;
    }

    @Override
    public RecallResponse processRequest(RecallRequest recallRequest) {
        final RecallResponse response = new RecallResponse();

        response.setNameResponse(getNameResponse(recallRequest.getName()));

        for(Email email : recallRequest.getEmails()) {
            response.getEmailResponses().add(getEmailResponse(email, recallRequest.getName().normalize()));
        }

        return response;
    }

    private NameResponse getNameResponse(Name name) {
        final Optional<NameTable> optional = nameTableRepo.findById(name.normalize());
        final NameResponse response = new NameResponse(name);

        if(optional.isPresent()) {
            final NameTable nameTable = optional.get();
            final Statistics statistics = getStatistics(nameTable.getTotal(), nameTable.getCreated(), nameTable.getUpdated());
            nameTable.increment();
            nameTableRepo.save(nameTable);
            response.setStatistics(statistics);
        } else {
            nameTableRepo.save(new NameTable(name));
            response.setStatistics(getStatistics(0, null, null));
        }

        return response;
    }

    private EmailResponse getEmailResponse(Email email, String nameKey) {
        final Optional<EmailTable> optional = emailTableRepo.findById(getNameKey(nameKey, email.normalize()));
        final EmailResponse response = new EmailResponse(email);

        if(optional.isPresent()) {
            final EmailTable emailTable = optional.get();
            final Statistics statistics = getStatistics(emailTable.getTotal(), emailTable.getCreated(), emailTable.getUpdated());
            response.setStatistics(statistics);

            emailTable.increment();
            emailTableRepo.save(emailTable);
        } else {
            emailTableRepo.save(new EmailTable(email, nameKey));
            response.setStatistics(getStatistics(0, null, null));
        }

        return response;
    }

    private NameKey getNameKey(String nameKey, String key) {
        return new NameKey(nameKey, key);
    }

    private Statistics getStatistics(long total, LocalDateTime created, LocalDateTime updated) {
        final Statistics statistics = new Statistics();
        statistics.setTotal(total);
        statistics.setCreated(created);
        statistics.setUpdated(updated);

        return statistics;
    }
}

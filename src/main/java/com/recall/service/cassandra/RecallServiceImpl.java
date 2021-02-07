package com.recall.service.cassandra;

import com.recall.api.NameResponse;
import com.recall.api.RecallRequest;
import com.recall.api.RecallResponse;
import com.recall.model.Name;
import com.recall.model.Statistics;
import com.recall.service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecallServiceImpl implements RecallService {
    private NameTableRepo nameTableRepo;

    @Autowired
    public RecallServiceImpl(NameTableRepo nameTableRepo) {
        this.nameTableRepo = nameTableRepo;
    }

    @Override
    public RecallResponse processRequest(RecallRequest recallRequest) {
        final RecallResponse response = new RecallResponse();

        NameResponse nameResponse = new NameResponse(recallRequest.getName());
        response.setNameResponse(getNameResponse(recallRequest.getName()));

        return response;
    }

    private NameResponse getNameResponse(Name name) {
        final Optional<NameTable> optional = nameTableRepo.findById(name.normalize());
        final NameResponse response = new NameResponse(name);

        if(optional.isPresent()) {
            NameTable nameTable = optional.get();
            nameTable.increment();
            nameTableRepo.save(nameTable);
            response.setStatistics(getStatistics(nameTable.getTotal()));
        } else {
            nameTableRepo.save(new NameTable(name));
            response.setStatistics(getStatistics(1));
        }

        return response;
    }

    private Statistics getStatistics(long total) {
        final Statistics statistics = new Statistics();
        statistics.setTotal(total);

        return statistics;
    }
}

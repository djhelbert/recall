package com.recall.service.cassandra;

import com.recall.api.*;
import com.recall.model.*;
import com.recall.service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RecallServiceImpl implements RecallService {
    private NameTableRepo nameTableRepo;
    private EmailTableRepo emailTableRepo;
    private PhoneTableRepo phoneTableRepo;
    private DateOfBirthRepo dateOfBirthRepo;
    private AddressTableRepo addressTableRepo;

    @Autowired
    public RecallServiceImpl(NameTableRepo nameTableRepo, EmailTableRepo emailTableRepo, PhoneTableRepo phoneTableRepo, DateOfBirthRepo dateOfBirthRepo, AddressTableRepo addressTableRepo) {
        this.nameTableRepo = nameTableRepo;
        this.emailTableRepo = emailTableRepo;
        this.phoneTableRepo = phoneTableRepo;
        this.dateOfBirthRepo = dateOfBirthRepo;
        this.addressTableRepo = addressTableRepo;
    }

    @Override
    public RecallResponse processRequest(RecallRequest request) {
        final RecallResponse response = new RecallResponse();
        final String nameKey = request.getName().normalize();

        response.setName(getNameResponse(request.getName()));

        if(request.getAddress() != null) {
            response.setAddress(getAddressResponse(request.getAddress(), nameKey));
        }

        if(request.getDateOfBirth() != null) {
            response.setDateOfBirth(getDateOfBirthResponse(request.getDateOfBirth(), nameKey));
        }

        for(Email email : request.getEmails()) {
            response.getEmails().add(getEmailResponse(email, nameKey));
        }
        for(Phone phone : request.getPhones()) {
            response.getPhones().add(getPhoneResponse(phone, nameKey));
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

    private AddressResponse getAddressResponse(Address address, String nameKey) {
        final Optional<AddressTable> optional = addressTableRepo.findById(getNameKey(nameKey, address.normalize()));
        final AddressResponse response = new AddressResponse(address);

        if(optional.isPresent()) {
            final AddressTable addressTable = optional.get();
            final Statistics statistics = getStatistics(addressTable.getTotal(), addressTable.getCreated(), addressTable.getUpdated());
            addressTable.increment();
            addressTableRepo.save(addressTable);
            response.setStatistics(statistics);
        } else {
            addressTableRepo.save(new AddressTable(address, nameKey));
            response.setStatistics(getStatistics(0, null, null));
        }

        return response;
    }

    private EmailResponse getEmailResponse(Email email, String nameKey) {
        final Optional<EmailTable> optional = emailTableRepo.findById(getNameKey(nameKey, email.normalize()));
        final EmailResponse response = new EmailResponse(email);

        if(optional.isPresent()) {
            final EmailTable emailTable = optional.get();
            final Statistics stat = getStatistics(emailTable.getTotal(), emailTable.getCreated(), emailTable.getUpdated());
            response.setStatistics(stat);

            emailTable.increment();
            emailTableRepo.save(emailTable);
        } else {
            emailTableRepo.save(new EmailTable(email, nameKey));
            response.setStatistics(getStatistics(0, null, null));
        }

        return response;
    }

    private PhoneResponse getPhoneResponse(Phone phone, String nameKey) {
        final Optional<PhoneTable> optional = phoneTableRepo.findById(getNameKey(nameKey, phone.normalize()));
        final PhoneResponse response = new PhoneResponse(phone);

        if(optional.isPresent()) {
            final PhoneTable phoneTable = optional.get();
            final Statistics stat = getStatistics(phoneTable.getTotal(), phoneTable.getCreated(), phoneTable.getUpdated());
            response.setStatistics(stat);

            phoneTable.increment();
            phoneTableRepo.save(phoneTable);
        } else {
            phoneTableRepo.save(new PhoneTable(phone, nameKey));
            response.setStatistics(getStatistics(0, null, null));
        }

        return response;
    }

    private DateOfBirthResponse getDateOfBirthResponse(DateOfBirth dateOfBirth, String nameKey) {
        final Optional<DateOfBirthTable> optional = dateOfBirthRepo.findById(getNameKey(nameKey, dateOfBirth.normalize()));
        final DateOfBirthResponse response = new DateOfBirthResponse(dateOfBirth);

        if(optional.isPresent()) {
            final DateOfBirthTable dob = optional.get();
            final Statistics stat = getStatistics(dob.getTotal(), dob.getCreated(), dob.getUpdated());
            response.setStatistics(stat);

            dob.increment();
            dateOfBirthRepo.save(dob);
        } else {
            dateOfBirthRepo.save(new DateOfBirthTable(dateOfBirth, nameKey));
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

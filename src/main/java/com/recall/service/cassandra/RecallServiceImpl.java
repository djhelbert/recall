package com.recall.service.cassandra;

import com.recall.api.NameResponse;
import com.recall.api.RecallRequest;
import com.recall.api.RecallResponse;
import com.recall.service.RecallService;
import org.springframework.stereotype.Service;

@Service
public class RecallServiceImpl implements RecallService {
    @Override
    public RecallResponse processRequest(RecallRequest recallRequest) {
        final RecallResponse response = new RecallResponse();

        NameResponse nameResponse = new NameResponse(recallRequest.getName());
        response.setNameResponse(nameResponse);

        return response;
    }
}

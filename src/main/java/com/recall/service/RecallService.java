package com.recall.service;

import com.recall.api.RecallRequest;
import com.recall.api.RecallResponse;

public interface RecallService {
    RecallResponse processRequest(RecallRequest recallRequest);
}

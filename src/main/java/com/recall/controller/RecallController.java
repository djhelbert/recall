package com.recall.controller;

import com.recall.api.EmailResponse;
import com.recall.api.RecallRequest;
import com.recall.api.RecallResponse;
import com.recall.model.Email;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recall")
public class RecallController {
    @PostMapping("/request")
    public RecallResponse request(@RequestBody RecallRequest recallRequest) {
        RecallResponse response = new RecallResponse();
        response.getEmails().add(new EmailResponse(new Email("test@email.net")));

        return response;
    }
}

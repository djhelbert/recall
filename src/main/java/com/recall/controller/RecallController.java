package com.recall.controller;

import com.recall.api.RecallRequest;
import com.recall.api.RecallResponse;
import com.recall.service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/recall")
public class RecallController {
    @Autowired
    private RecallService recallService;

    @PostMapping("/request")
    public RecallResponse request(@Valid @RequestBody RecallRequest recallRequest) {
        return recallService.processRequest(recallRequest);
    }
}

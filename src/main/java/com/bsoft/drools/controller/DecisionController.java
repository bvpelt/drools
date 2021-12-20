package com.bsoft.drools.controller;

import com.bsoft.drools.domain.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DecisionController {

    private final KieContainer kieContainer;

    @Autowired
    public DecisionController(final KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @PostMapping("/discount")
    private OrderRequest getDiscountPercent(@RequestBody OrderRequest orderRequest) {
        log.info("Received request: {}", orderRequest.toString());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        log.info("After fired rules request: {}", orderRequest.toString());
        kieSession.dispose();
        log.info("Processed request: {} - calculated price: {}", orderRequest.toString(), orderRequest.getPrice());
        return orderRequest;
    }
}

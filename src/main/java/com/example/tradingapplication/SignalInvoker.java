package com.example.tradingapplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class SignalInvoker implements SignalHandler{
    String signalInvokerURL
            = "http://localhost:8080/signal/";
    @Override
    public void handleSignal(int signal) {
        String signal_no=String.valueOf(signal);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(signalInvokerURL+signal_no, String.class);

    }
}

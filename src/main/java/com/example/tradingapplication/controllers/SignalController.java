package com.example.tradingapplication.controllers;


import com.example.tradingapplication.Algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
public class SignalController {
    @Autowired
    private Algo algoClass;
    Class<?> signalClass;
    @GetMapping("/signal/{signalNo}")
    public ResponseEntity<String> executeSignal(@PathVariable ("signalNo") String SignalNo) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        String pathName = "com.example.tradingapplication.models";
        String signalName = "Signal"+SignalNo;
        //Using Java Reflection to Get Class and call the execute method
        try {
            signalClass = Class.forName(pathName+"."+signalName);
        } catch (ClassNotFoundException e) {
            algoClass.cancelTrades();
            algoClass.doAlgo();
            return new ResponseEntity<String>("Cannot Find Signal number "+SignalNo+ " executed default behaviour", HttpStatus.OK);
        }
        signalClass.getMethod("execute").invoke(signalClass.newInstance());
        algoClass.doAlgo();
        return new ResponseEntity<String>("Executed "+signalName, HttpStatus.OK);


    }
}

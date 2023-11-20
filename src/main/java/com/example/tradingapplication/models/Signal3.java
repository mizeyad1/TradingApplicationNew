package com.example.tradingapplication.models;

public class Signal3 extends Signal {
    @Override
    public void execute() {
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
    }
}

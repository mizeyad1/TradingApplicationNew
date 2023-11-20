package com.example.tradingapplication.models;

public class Signal2 extends Signal{
    @Override
    public void execute() {
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
    }
}

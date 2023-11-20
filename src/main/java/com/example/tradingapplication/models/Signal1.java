package com.example.tradingapplication.models;



public class Signal1 extends Signal{

    @Override
    public void execute() {
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();

    }
}

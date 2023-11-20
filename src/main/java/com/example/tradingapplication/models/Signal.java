package com.example.tradingapplication.models;

import com.example.tradingapplication.Algo;

public abstract class Signal {
    Algo algo = new Algo();
    public abstract void  execute();
}

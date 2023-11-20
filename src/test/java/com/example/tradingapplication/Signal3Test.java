package com.example.tradingapplication;

import com.example.tradingapplication.models.Signal;
import com.example.tradingapplication.models.Signal2;
import com.example.tradingapplication.models.Signal3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Signal3Test extends BaseSignalsTest{
    @Test
    void shouldExecuteCorrectSignal3Algorithm()
    {
        Signal signal3 = new Signal3();
        signal3.execute();
        assertEquals("setAlgoParam1,90\n" +
                "setAlgoParam2,15\n" +
                "performCalc\n" +
                "submitToMarket\n", outContent.toString());

    }
}

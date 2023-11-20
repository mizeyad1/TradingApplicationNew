package com.example.tradingapplication;

import com.example.tradingapplication.models.Signal;
import com.example.tradingapplication.models.Signal1;
import com.example.tradingapplication.models.Signal2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Signal2Test extends BaseSignalsTest{
    @Test
    void shouldExecuteCorrectSignal2Algorithm()
    {
        Signal signal2 = new Signal2();
        signal2.execute();
        assertEquals("reverse\n" +
                "setAlgoParam1,80\n" +
                "submitToMarket\n", outContent.toString());

    }

}

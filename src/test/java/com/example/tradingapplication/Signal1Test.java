package com.example.tradingapplication;

import com.example.tradingapplication.models.Signal;
import com.example.tradingapplication.models.Signal1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Signal1Test extends BaseSignalsTest{


    @Test
    void shouldExecuteCorrectSignal1Algorithm()
    {
        Signal signal1 = new Signal1();
        signal1.execute();
        assertEquals("setUp\n" +
                "setAlgoParam1,60\n" +
                "performCalc\n" +
                "submitToMarket\n", outContent.toString());

    }
}

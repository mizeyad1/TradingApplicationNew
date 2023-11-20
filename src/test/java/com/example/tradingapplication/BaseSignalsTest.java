package com.example.tradingapplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BaseSignalsTest {
    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void clearStream() {
        outContent.reset();
    }
}

package com.example.tradingapplication;

import com.example.tradingapplication.controllers.SignalController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SignalControllerTest {
    @Autowired
    private SignalController signalController;
    @Autowired
    private MockMvc mockMvc;



    @Test
    void contextLoadsController() {
        assertThat(signalController).isNotNull();
    }
    @ParameterizedTest
    @MethodSource("supportedSignals")
    void shouldReturnSuccessfulExecutionMessageIfSignalExists(String signalNo) throws Exception {
        this.mockMvc.perform(get("/signal/"+signalNo)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Executed Signal"+signalNo)));

    }
    @Test
    void shouldReturnDefaultBehaviorExecutionMessageIfSignalDoesNotExist() throws Exception {
        Random rand = new Random();
        String notSupportedSignalNo = String.valueOf(rand.nextInt(Integer.MAX_VALUE));
        while(supportedSignals().collect(Collectors.toSet()).contains(notSupportedSignalNo))
        {
            String unsupportedSignalNo = String.valueOf(rand.nextInt(Integer.MAX_VALUE));
        }


        this.mockMvc.perform(get("/signal/"+notSupportedSignalNo)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Cannot Find Signal number "+notSupportedSignalNo+ " executed default behaviour")));

    }
     static Stream<String> supportedSignals() {
        return Stream.of("1",
                "2","3");
    }


}

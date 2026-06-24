package com.internintelligence.myapplication.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class CardApplicationServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateApplicationAPI_Success() throws Exception {
        String requestJson = "{\n" +
                "  \"cardType\": \"VISA_GOLD\",\n" +
                "  \"currency\": \"AZN\",\n" +
                "  \"finCode\": \"7ABC123\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/card-applications")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("PENDING"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cardType").value("VISA_GOLD"));
    }
}

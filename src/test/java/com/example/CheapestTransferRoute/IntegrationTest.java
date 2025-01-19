package com.example.CheapestTransferRoute;

import com.example.CheapestTransferRoute.dto.TransferRequest;
import com.example.CheapestTransferRoute.model.Transfer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testFullApplicationFlow() throws Exception {
        Transfer transfer1 = new Transfer();
        transfer1.setWeight(10);
        transfer1.setCost(60);

        Transfer transfer2 = new Transfer();
        transfer2.setWeight(20);
        transfer2.setCost(100);

        Transfer transfer3 = new Transfer();
        transfer3.setWeight(30);
        transfer3.setCost(120);

        TransferRequest request = new TransferRequest();
        request.setMaxWeight(50);
        request.setAvailableTransfers(Arrays.asList(transfer1, transfer2, transfer3));


        mockMvc.perform(post("/api/cheapest-route")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalCost").value(220))
                .andExpect(jsonPath("$.totalWeight").value(50))
                .andExpect(jsonPath("$.selectedTransfers").isArray());
    }
}

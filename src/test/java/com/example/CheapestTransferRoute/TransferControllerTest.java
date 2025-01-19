package com.example.CheapestTransferRoute;

import com.example.CheapestTransferRoute.controller.TransferController;
import com.example.CheapestTransferRoute.dto.TransferRequest;
import com.example.CheapestTransferRoute.dto.TransferResponse;
import com.example.CheapestTransferRoute.model.Transfer;
import com.example.CheapestTransferRoute.service.TransferService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransferController.class)
class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransferService transferService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetCheapestRoute() throws Exception {
        // Arrange
        Transfer transfer1 = new Transfer();
        transfer1.setWeight(10);
        transfer1.setCost(60);

        Transfer transfer2 = new Transfer();
        transfer2.setWeight(20);
        transfer2.setCost(100);

        TransferResponse mockResponse = new TransferResponse();
        mockResponse.setSelectedTransfers(Arrays.asList(transfer1, transfer2));
        mockResponse.setTotalCost(160);
        mockResponse.setTotalWeight(30);

        Mockito.when(transferService.findOptimalTransfers(Mockito.any())).thenReturn(mockResponse);

        TransferRequest request = new TransferRequest();
        request.setMaxWeight(50);
        request.setAvailableTransfers(Arrays.asList(transfer1, transfer2));

        // Act & Assert
        mockMvc.perform(post("/api/cheapest-route")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalCost").value(160))
                .andExpect(jsonPath("$.totalWeight").value(30))
                .andExpect(jsonPath("$.selectedTransfers").isArray());
    }
}

package com.example.CheapestTransferRoute;

import com.example.CheapestTransferRoute.dto.TransferRequest;
import com.example.CheapestTransferRoute.dto.TransferResponse;
import com.example.CheapestTransferRoute.model.Transfer;
import com.example.CheapestTransferRoute.service.TransferService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferServiceTest {

    private final TransferService transferService = new TransferService();

    @Test
    void testFindOptimalTransfers() {
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


        TransferResponse response = transferService.findOptimalTransfers(request);


        assertEquals(2, response.getSelectedTransfers().size());
        assertEquals(220, response.getTotalCost());
        assertEquals(50, response.getTotalWeight());
    }
}

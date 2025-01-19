package com.example.CheapestTransferRoute.service;

import com.example.CheapestTransferRoute.dto.TransferRequest;
import com.example.CheapestTransferRoute.dto.TransferResponse;
import com.example.CheapestTransferRoute.model.Transfer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService {
    public TransferResponse findOptimalTransfers(TransferRequest request) {
        int maxWeight = request.getMaxWeight();
        List<Transfer> transfers = request.getAvailableTransfers();


        int n = transfers.size();
        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int i = 1; i <= n; i++) {
            Transfer transfer = transfers.get(i - 1);
            for (int w = 1; w <= maxWeight; w++) {
                if (transfer.getWeight() <= w) {
                    dp[i][w] = Math.max(transfer.getCost() + dp[i - 1][w - transfer.getWeight()], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }


        List<Transfer> selectedTransfers = new ArrayList<>();
        int totalCost = dp[n][maxWeight];
        int totalWeight = 0;
        for (int i = n, w = maxWeight; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Transfer transfer = transfers.get(i - 1);
                selectedTransfers.add(transfer);
                totalWeight += transfer.getWeight();
                w -= transfer.getWeight();
            }
        }


        TransferResponse response = new TransferResponse();
        response.setSelectedTransfers(selectedTransfers);
        response.setTotalCost(totalCost);
        response.setTotalWeight(totalWeight);
        return response;
    }
}

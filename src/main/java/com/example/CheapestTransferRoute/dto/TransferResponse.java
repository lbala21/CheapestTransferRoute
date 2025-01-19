package com.example.CheapestTransferRoute.dto;

import com.example.CheapestTransferRoute.model.Transfer;
import java.util.List;

public class TransferResponse {
    private List<Transfer> selectedTransfers;
    private int totalCost;
    private int totalWeight;

    // Getters and Setters
    public List<Transfer> getSelectedTransfers() {
        return selectedTransfers;
    }

    public void setSelectedTransfers(List<Transfer> selectedTransfers) {
        this.selectedTransfers = selectedTransfers;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }
}

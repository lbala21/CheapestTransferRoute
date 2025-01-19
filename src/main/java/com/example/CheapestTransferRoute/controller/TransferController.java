package com.example.CheapestTransferRoute.controller;

import com.example.CheapestTransferRoute.dto.TransferRequest;
import com.example.CheapestTransferRoute.dto.TransferResponse;
import com.example.CheapestTransferRoute.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping("/cheapest-route")
    public ResponseEntity<TransferResponse> getCheapestRoute(@RequestBody TransferRequest request) {
        return ResponseEntity.ok(transferService.findOptimalTransfers(request));
    }

}


package com.example.CheapestTransferRoute;


import com.example.CheapestTransferRoute.model.Transfer;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferTest {


    @Test
    void testFindOptimalTransfers() {
        Transfer transfer1 = new Transfer();
        transfer1.setWeight(10);
        transfer1.setCost(60);

        assertEquals(10,transfer1.getWeight());
        assertEquals(60,transfer1.getCost());

        Transfer transfer2 = new Transfer();
        transfer2.setWeight(20);
        transfer2.setCost(100);

        assertEquals(20,transfer2.getWeight());
        assertEquals(100,transfer2.getCost());

        Transfer transfer3 = new Transfer();
        transfer3.setWeight(30);
        transfer3.setCost(120);

        assertEquals(30,transfer3.getWeight());
        assertEquals(120,transfer3.getCost());

    }
}

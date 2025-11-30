package com.courier_sync.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Invoice {

    private String invoiceNumber;
    private String status;
    private String customerName;
    private String amount;
    private Date emissionDate;
    private Date expirationDate;

        public static Invoice random() {
            return new Invoice(
                    "INV-" + System.currentTimeMillis(),
                    "Pending",
                    "John Doe",
                    "100.00",
                    new Date(),
                    new Date(System.currentTimeMillis() + 86400000L * 30) // 30 days later
            );
        }
    }


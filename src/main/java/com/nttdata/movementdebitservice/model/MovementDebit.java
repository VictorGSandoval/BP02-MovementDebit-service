package com.nttdata.movementdebitservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class MovementDebit {
    @Id
    private String id;
    private Double amount;
    private MovementDebitType typeMovement;
    private String idAccount;
    private LocalDate date;
}

package com.ilibit.helloworld.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private String date;
    private String hour;
    private Double amount;
    private String description;
    private String type;
}

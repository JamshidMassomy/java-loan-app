package com.loan_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String personalCode;
    private Integer creditModifier;
    private Boolean hasDebt;
}

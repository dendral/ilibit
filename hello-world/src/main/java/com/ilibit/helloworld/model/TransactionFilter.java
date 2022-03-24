package com.ilibit.helloworld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionFilter {

    @NotNull
    @Pattern(regexp = "^[0-9]{10}$")
    String account;

    @NotNull
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$")
    String startDate;

    @NotNull
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$")
    String endDate;
}

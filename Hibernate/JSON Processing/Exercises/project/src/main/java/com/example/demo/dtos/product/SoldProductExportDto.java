package com.example.demo.dtos.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SoldProductExportDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    @SerializedName("buyerFirstName")
    private String firstName;

    @Expose
    @SerializedName("buyerLastName")
    private String lastName;
}

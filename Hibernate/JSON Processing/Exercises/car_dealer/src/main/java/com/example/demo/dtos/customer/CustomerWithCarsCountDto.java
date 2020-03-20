package com.example.demo.dtos.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerWithCarsCountDto {
    @Expose
    @SerializedName("fullName")
    private String name;

    @Expose
    private long boughtCars;

    @Expose
    private double spentMoney;
}

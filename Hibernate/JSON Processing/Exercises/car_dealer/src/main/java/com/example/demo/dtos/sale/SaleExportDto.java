package com.example.demo.dtos.sale;

import com.example.demo.dtos.car.CarExportDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleExportDto {
    @Expose
    @SerializedName("car")
    private CarExportDto carExportDto;

    @Expose
    private String customerName;

    @Expose
    @SerializedName("Discount")
    private double discount;

    @Expose
    private double price;

    @Expose
    private double priceWithDiscount;
}

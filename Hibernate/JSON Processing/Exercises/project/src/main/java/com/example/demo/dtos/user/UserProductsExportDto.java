package com.example.demo.dtos.user;

import com.example.demo.data.entiites.Product;
import com.example.demo.dtos.product.ProductCountExportDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProductsExportDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    @Expose
    @SerializedName("soldProducts")
    private ProductCountExportDto dto;
}

package com.example.demo.dtos.user;

import com.example.demo.dtos.product.SoldProductExportDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserWithSoldProductsExportDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    @SerializedName("soldProducts")
    private List<SoldProductExportDto> products;
}

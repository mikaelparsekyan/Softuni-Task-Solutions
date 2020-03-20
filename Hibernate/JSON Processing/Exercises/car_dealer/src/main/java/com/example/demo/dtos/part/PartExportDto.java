package com.example.demo.dtos.part;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartExportDto {
    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("Price")
    private double price;
}

package com.example.demo.dtos.supplier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierExportDto {
    @Expose
    @SerializedName("Id")
    private long id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    private long partsCount;
}

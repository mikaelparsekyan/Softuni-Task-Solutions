package com.example.demo.dtos.customer;

import com.example.demo.data.entities.Sale;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerOrderExportDto {
    @Expose
    @SerializedName("Id")
    private long id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("BirthDate")
    private String birthDate;

    @Expose
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;

    @Expose
    @SerializedName("Sales")
    private Set<Sale> sales = new HashSet<>();
}

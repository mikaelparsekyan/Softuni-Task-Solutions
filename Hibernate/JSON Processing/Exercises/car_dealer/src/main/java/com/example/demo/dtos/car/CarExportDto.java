package com.example.demo.dtos.car;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarExportDto {
    @Expose
    @SerializedName("Id")
    private long id;

    @Expose
    @SerializedName("Make")
    private String make;

    @Expose
    @SerializedName("Model")
    private String model;

    @Expose
    @SerializedName("TravelledDistance")
    private long travelledDistance;

}

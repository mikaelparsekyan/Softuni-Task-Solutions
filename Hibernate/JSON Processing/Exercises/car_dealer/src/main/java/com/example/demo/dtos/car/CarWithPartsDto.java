package com.example.demo.dtos.car;

import com.example.demo.dtos.part.PartExportDto;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarWithPartsDto {
    @Expose
    private CarExportDto car;

    @Expose
    private List<PartExportDto> parts;
}

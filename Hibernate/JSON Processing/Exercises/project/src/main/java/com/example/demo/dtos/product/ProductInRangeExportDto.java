package com.example.demo.dtos.product;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductInRangeExportDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private String seller;

}

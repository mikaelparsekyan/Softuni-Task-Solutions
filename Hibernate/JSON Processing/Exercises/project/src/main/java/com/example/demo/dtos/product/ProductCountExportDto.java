package com.example.demo.dtos.product;

import com.example.demo.data.entiites.Product;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCountExportDto {
    @Expose
    private long count;

    @Expose
    private List<Product> products = new LinkedList<>();
}

package com.example.demo.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SoldProductsWithCountDto {
    @XmlAttribute
    private int count;

    @XmlElement(name = "product")
    private List<ProductsInfoWithAttributesDto> products;
}

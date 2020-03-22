package com.example.demo.dtos.product;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ProductsInRangeExportDto {
    @XmlElement(name = "product")
    private List<ProductElementInfoDto> products;
}

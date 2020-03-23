package com.example.demo.dtos.user;

import com.example.demo.dtos.product.SoldProductsExportDto;
import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class UserWithProductsExportDto {
    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "sold-products")
    private SoldProductsExportDto soldProductsExportDto;
}

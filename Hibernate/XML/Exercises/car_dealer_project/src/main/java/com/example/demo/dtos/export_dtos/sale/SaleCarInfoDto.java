package com.example.demo.dtos.export_dtos.sale;

import com.example.demo.dtos.export_dtos.car.CarInfoAttributesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleCarInfoDto {
    @XmlElement(name = "car")
    private CarInfoAttributesDto car;

    @XmlElement(name = "customer-name")
    private String customerName;

    @XmlElement
    private double discount;

    @XmlElement
    private double price;

    @XmlElement(name = "price-with-discount")
    private double priceWithDiscount;
}

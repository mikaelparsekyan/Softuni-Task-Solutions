package com.example.demo.dtos.export_dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerInfoAttributeDto {
    @XmlAttribute(name = "full-name")
    private String fullName;

    @XmlAttribute(name = "bought-cars")
    private int boughtCars;

    @XmlAttribute(name = "spent-money")
    private double spentMoney;
}

package com.example.demo.dtos.export_dtos.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuppliersAttributeInfoDto {
    @XmlAttribute
    private long id;

    @XmlAttribute
    private String name;

    @XmlAttribute(name = "parts-count")
    private long partsCount;
}

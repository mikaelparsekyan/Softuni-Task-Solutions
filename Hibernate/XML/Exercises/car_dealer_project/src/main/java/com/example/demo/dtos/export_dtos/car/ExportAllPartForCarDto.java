package com.example.demo.dtos.export_dtos.car;

import com.example.demo.dtos.export_dtos.part.PartInfoAttributeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExportAllPartForCarDto {

    @XmlElement(name = "part")
    private List<PartInfoAttributeDto> parts;
}

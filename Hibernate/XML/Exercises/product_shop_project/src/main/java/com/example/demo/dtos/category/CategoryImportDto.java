package com.example.demo.dtos.category;

import com.example.demo.data.entiites.Category;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CategoryImportDto {

    @XmlElement(name = "category")
    private List<Category> categories;
}

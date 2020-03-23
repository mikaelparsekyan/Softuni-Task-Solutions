package com.example.demo.data.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "suppliers")
@NoArgsConstructor
@Data
public class Supplier extends BaseEntity {

    @XmlAttribute
    @Column
    private String name;

    @XmlAttribute(name = "is-importer")
    @Column(name = "is_importer")
    private boolean isImporter;
}

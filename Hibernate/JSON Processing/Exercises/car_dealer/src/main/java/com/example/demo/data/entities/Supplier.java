package com.example.demo.data.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "suppliers")
@NoArgsConstructor
@Data
public class Supplier extends BaseEntity {

    @Column
    private String name;

    @Column(name = "is_importer")
    private boolean isImporter;
}

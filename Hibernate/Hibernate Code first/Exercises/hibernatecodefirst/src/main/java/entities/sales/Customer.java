package entities.sales;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    private String name;
    private int quantity;
    private double price;
}

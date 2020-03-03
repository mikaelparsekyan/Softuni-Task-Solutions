package entities.payment_system;

import entities.BaseEntity;

import javax.persistence.*;

@MappedSuperclass
public abstract class BillingDetail extends BaseEntity {
    private String number;
    private String owner;

    private User user;

    @Column
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

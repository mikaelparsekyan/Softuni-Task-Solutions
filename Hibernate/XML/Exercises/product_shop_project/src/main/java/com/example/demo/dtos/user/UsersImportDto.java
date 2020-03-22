package com.example.demo.dtos.user;

import com.example.demo.data.entiites.User;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class UsersImportDto {

    @XmlElement(name = "user")
    private List<User> users;
}

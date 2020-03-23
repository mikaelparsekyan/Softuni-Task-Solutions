package com.example.demo.dtos.user;

import com.example.demo.dtos.user.UserWithProductsCountExportDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAndProductsCountExportDto {
    @XmlAttribute
    private int count;

    @XmlElement(name = "user")
    private List<UserWithProductsCountExportDto> users;
}

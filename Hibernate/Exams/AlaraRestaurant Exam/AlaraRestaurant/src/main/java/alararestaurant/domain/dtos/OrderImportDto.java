package alararestaurant.domain.dtos;

import alararestaurant.domain.entities.Item;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class OrderImportDto {
    @XmlElement
    @NonNull
    @NotNull
    private String customer;

    @XmlElement
    @NonNull
    @NotNull
    private String employee;

    @XmlElement(name = "date-time")
    @NonNull
    @NotNull
    private String dateTime;

    @XmlElement
    @NonNull
    @NotNull
    private String type;

    @XmlElement(name = "items")
    @NonNull
    @NotNull
    private List<ItemImportDto> items;
}

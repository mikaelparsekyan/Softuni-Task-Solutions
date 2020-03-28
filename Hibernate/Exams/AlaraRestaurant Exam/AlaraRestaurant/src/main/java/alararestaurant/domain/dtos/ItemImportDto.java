package alararestaurant.domain.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class ItemImportDto {
    @NonNull
    @NotNull
    @XmlElement
    private String name;

    @NonNull
    @NotNull
    @XmlElement
    private int quantity;
}

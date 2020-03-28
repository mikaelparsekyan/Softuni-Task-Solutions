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
import java.util.List;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class OrdersImportDto {
    @XmlElement(name = "order")
    @NonNull
    @NotNull
    private List<OrderImportDto> orders;
}

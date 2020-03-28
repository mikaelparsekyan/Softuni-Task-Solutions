package hiberspring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImportInfoByElements {
    @XmlAttribute
    @NotNull
    private String name;

    @XmlAttribute
    @NotNull
    private int clients;

    @XmlElement
    @NotNull
    private String branch;
}

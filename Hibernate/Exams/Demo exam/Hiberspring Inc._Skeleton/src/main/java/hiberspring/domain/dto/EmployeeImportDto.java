package hiberspring.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@RequiredArgsConstructor
public class EmployeeImportDto {
    @XmlAttribute(name = "first-name")
    @NotNull
    private String firstName;

    @XmlAttribute(name = "last-name")
    @NotNull
    private String lastName;

    @XmlAttribute
    @NotNull
    private String position;

    @XmlElement
    @NotNull
    private String card;

    @XmlElement
    @NotNull
    private String branch;
}

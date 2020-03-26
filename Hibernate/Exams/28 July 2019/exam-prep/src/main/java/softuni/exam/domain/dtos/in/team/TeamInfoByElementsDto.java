package softuni.exam.domain.dtos.in.team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.exam.domain.dtos.in.picture.PictureInfoByElementsDto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamInfoByElementsDto {

    @NotNull
    @XmlElement
    private String name;

    @NotNull
    @XmlElement(name = "picture")
    private PictureInfoByElementsDto picture;
}

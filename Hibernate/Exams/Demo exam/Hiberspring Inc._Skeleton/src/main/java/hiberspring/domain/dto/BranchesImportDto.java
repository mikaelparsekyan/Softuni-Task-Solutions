package hiberspring.domain.dto;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class BranchesImportDto {
    @Expose
    @NotNull
    private String name;

    @Expose
    @NotNull
    private String town;
}

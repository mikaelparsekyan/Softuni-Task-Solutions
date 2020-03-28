package alararestaurant.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class EmployeesImportDto {
    @Expose
    @NotNull
    @NonNull
    @Size(min = 3, max = 30)
    private String name;

    @Expose
    @NotNull
    @NonNull
    @Min(value = 15, message = "The age must not be lower than 15!")
    @Max(value = 80, message = "The age must not be higher than 80!")
    private int age;

    @Expose
    @NotNull
    @NonNull
    private String position;
}

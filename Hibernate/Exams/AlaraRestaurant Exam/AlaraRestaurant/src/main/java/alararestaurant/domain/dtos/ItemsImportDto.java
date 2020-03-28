package alararestaurant.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class ItemsImportDto {
    @Expose
    @NonNull
    @NotNull
    private String name;

    @Expose
    @NonNull
    @NotNull
    @DecimalMin(value = "0.01", message = "Price must be greater or equal 0.01!")
    private BigDecimal price;

    @Expose
    @NonNull
    @NotNull
    private String category;
}

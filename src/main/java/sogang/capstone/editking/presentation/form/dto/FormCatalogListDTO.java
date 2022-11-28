package sogang.capstone.editking.presentation.form.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FormCatalogListDTO {

    @NotNull(message = "formList may not be null")
    private List<FormCatalogDTO> formList;

}

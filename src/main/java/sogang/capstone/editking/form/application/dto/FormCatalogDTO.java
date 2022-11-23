package sogang.capstone.editking.form.application.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sogang.capstone.editking.form.domain.Form;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FormCatalogDTO {

    @NotNull(message = "id may not be null")
    private Long id;

    @NotNull(message = "company may not be null")
    private String company;

    @NotNull(message = "title may not be null")
    private String title;

    @NotNull(message = "dueDate may not be null")
    private String dueDate;

    public FormCatalogDTO(Form form) {
        this.id = form.getId();
        this.company = form.getCompany();
        this.title = form.getTitle();
        this.dueDate = form.getDueDate().toString();
    }
}
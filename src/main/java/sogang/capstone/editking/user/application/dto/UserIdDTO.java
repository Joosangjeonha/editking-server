package sogang.capstone.editking.user.application.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sogang.capstone.editking.user.domain.User;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserIdDTO {

    @NotNull(message = "id may not be null")
    private Long id;

    public UserIdDTO(User user) {
        this.id = user.getId();
    }
}

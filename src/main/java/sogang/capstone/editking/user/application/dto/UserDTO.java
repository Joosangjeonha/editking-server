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
public class UserDTO {

    @NotNull(message = "name may not be null")
    private String name;

    @NotNull(message = "plan may not be null")
    private String plan;

    public UserDTO(User user) {
        this.name = user.getName();
        this.plan = user.getPlan().toString();
    }
}

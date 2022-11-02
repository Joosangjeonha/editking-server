package sogang.capstone.editking.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import sogang.capstone.editking.domain.User;

@Getter
@ToString
@EqualsAndHashCode
public class TokenDTO {

    private Long id;
    private String name;

    public TokenDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}

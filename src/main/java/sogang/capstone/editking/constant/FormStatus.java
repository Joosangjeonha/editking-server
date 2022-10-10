package sogang.capstone.editking.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormStatus implements EnumMapper{

    WRITING("WRITING"),
    SUBMITTED("SUBMITTED");

    private final String formStatus;

    @Override
    public String getCode() {
        return name();
    }
}

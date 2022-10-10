package sogang.capstone.editking.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlanStatus implements EnumMapper{

    STANDARD("STANDARD"),
    PREMIUM("PREMIUM");

    private final String planName;

    @Override
    public String getCode() {
        return name();
    }
}

package sogang.capstone.editking.domain.interview;

public enum InterviewCategory {

    CHARACTER("인성"),
    COOPERATION("협업"),
    JOB("직무");

    private final String value;

    InterviewCategory(String s) {
        this.value = s;
    }

    public String getValue() {
        return this.value;
    }
}

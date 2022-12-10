package sogang.capstone.editking.domain.interview;

public enum InterviewCategory {

    COOPERATION("협업"),
    JOB("직무"),
    CLUB("동아리");

    private final String value;

    InterviewCategory(String s) {
        this.value = s;
    }

    public String getValue() {
        return this.value;
    }
}

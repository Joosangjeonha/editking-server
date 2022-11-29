package sogang.capstone.editking.domain.form.interview;

public enum InterviewCategory {

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

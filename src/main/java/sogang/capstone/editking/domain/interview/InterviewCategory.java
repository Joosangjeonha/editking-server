package sogang.capstone.editking.domain.interview;

public enum InterviewCategory {
    
    COOPERATION("협업"),
    JOB("직무");

    private final String message;

    InterviewCategory(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }
}

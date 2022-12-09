package sogang.capstone.editking.domain.form;

public interface FormRecommendService {

    public FormInfo.SynonymMain recommendSynonym(String word);

    public FormInfo.InterviewMain recommendInterview(Form form);
}

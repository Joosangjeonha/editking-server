package sogang.capstone.editking.domain.form;

public interface FormRecommendService {

    public FormInfo.SynonymMain recommendSynonym(String word);

    public FormInfo.InterviewMain analyzeInterview(Form form);

    public FormInfo.InterviewMain recommendInterview(Long id);
}

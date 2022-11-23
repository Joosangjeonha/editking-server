package sogang.capstone.editking.form.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import sogang.capstone.editking.form.application.request.EditFormRequest;
import sogang.capstone.editking.global.common.AbstractTimestamp;
import sogang.capstone.editking.global.exception.BadRequestException;
import sogang.capstone.editking.global.util.TimestampParser;
import sogang.capstone.editking.interview.domain.Interview;
import sogang.capstone.editking.user.domain.User;

@Getter
@Entity
@Table(name = "Form")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Form extends AbstractTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
    private Timestamp dueDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false, length = 20)
    private String company;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "Question", joinColumns = @JoinColumn(name = "formId"))
    @OrderColumn(name = "questionId")
    private List<Question> questionList;

    @OneToMany(mappedBy = "form")
    private List<Interview> interviewList;

    @Builder()
    public Form(
            Long id,
            String title,
            Timestamp dueDate,
            User user,
            String company,
            List<Question> questionList
    ) {
        if (title == null) {
            throw new BadRequestException("제목은 필수값입니다.");
        }
        if (dueDate == null) {
            throw new BadRequestException("유저는 필수값입니다.");
        }
        if (company == null) {
            throw new BadRequestException("기업은 필수값입니다.");
        }

        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.status = FormStatus.WRITING;
        this.user = user;
        this.company = company;
        this.questionList = questionList;
    }

    public void updatePropertyWith(EditFormRequest editFormRequest) {
        updateCompany(editFormRequest.getCompany());
        updateTitle(editFormRequest.getTitle());
        updateDueDate(editFormRequest.getDueDate());
    }

    private void updateCompany(String company) {
        if (!this.company.equals(company)) {
            this.company = company;
        }
    }

    private void updateTitle(String title) {
        if (!this.title.equals(title)) {
            this.title = title;
        }
    }

    private void updateDueDate(String dueDateString) {
        TimestampParser timestampParser = new TimestampParser();
        Timestamp dueDate = timestampParser.stringToTimestamp(dueDateString);

        if (!this.dueDate.equals(dueDate)) {
            this.dueDate = dueDate;
        }
    }

    public void updateQuestionList(List<Question> questionList) {
        this.questionList.sort(Comparator.naturalOrder());
        questionList.sort(Comparator.naturalOrder());

        if (!this.questionList.equals(questionList)) {
            this.questionList = questionList;
        }
    }
}

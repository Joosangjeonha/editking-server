package sogang.capstone.editking.form.domain;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import sogang.capstone.editking.form.application.request.QuestionRequest;
import sogang.capstone.editking.global.common.AbstractTimestamp;
import sogang.capstone.editking.global.exception.BadRequestException;

@Getter
@Embeddable
public class Question extends AbstractTimestamp {

    @Column(nullable = false)
    private Long idx;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private Long maximum;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formId", nullable = false)
    private Form form;

    @Builder()
    public Question(QuestionRequest questionRequest) {
        this.idx = questionRequest.getIdx();
        this.title = questionRequest.getTitle();
        this.maximum = questionRequest.getMaximum();
    }

    @Builder()
    public Question(
            Long id,
            Long idx,
            String title,
            Long maximum,
            String content,
            Form form
    ) {
        if (idx == null) {
            throw new BadRequestException("항목 번호는 필수값입니다.");
        }
        if (title == null) {
            throw new BadRequestException("제목은 필수값입니다.");
        }
        if (maximum == null) {
            throw new BadRequestException("제한 글자 수는 필수값입니다.");
        }
        this.idx = idx;
        this.title = title;
        this.maximum = maximum;
        this.content = content;
        this.form = form;
    }
}

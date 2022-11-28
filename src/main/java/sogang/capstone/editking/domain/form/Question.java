package sogang.capstone.editking.domain.form;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import sogang.capstone.editking.common.exception.BadRequestException;

@Getter
@Embeddable
public class Question implements Comparable<Question> {

    @Column(nullable = false)
    private Long idx;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private Long maximum;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Question() {
    }

    public Question(FormCommand.EditQuestion editQuestionRequest) {
        this.idx = editQuestionRequest.getIdx();
        this.title = editQuestionRequest.getTitle();
        this.maximum = editQuestionRequest.getMaximum();
        this.content = editQuestionRequest.getContent();
    }

    @Builder()
    public Question(
            Long id,
            Long idx,
            String title,
            Long maximum,
            String content
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
    }

    public void updateContent(String content) {
        if (!this.content.equals(content)) {
            this.content = content;
        }
    }

    @Override
    public int compareTo(Question question) {
        return this.idx.compareTo(question.getIdx());
    }
}

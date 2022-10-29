package sogang.capstone.editking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sogang.capstone.editking.exception.BadRequestException;

@Getter
@Setter
@Entity
@Table(name = "Question")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Question extends AbstractTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
        if (content == null) {
            throw new BadRequestException("내용은 필수값입니다.");
        }
        if (form == null) {
            throw new BadRequestException("자기소개서는 필수값입니다.");
        }

        this.id = id;
        this.idx = idx;
        this.title = title;
        this.maximum = maximum;
        this.content = content;
        this.form = form;
    }
}

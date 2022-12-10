package sogang.capstone.editking.domain.interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.hibernate.annotations.DynamicUpdate;
import sogang.capstone.editking.common.exception.BadRequestException;
import sogang.capstone.editking.domain.AbstractTimestamp;
import sogang.capstone.editking.domain.form.Form;

@Getter
@Entity
@Table(name = "Interview")
@DynamicUpdate
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Interview extends AbstractTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formId", nullable = false)
    private Form form;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InterviewCategory category;

    @Builder()
    public Interview(
            Long id,
            String content,
            Form form,
            String category
    ) {
        if (content == null) {
            throw new BadRequestException("내용은 필수값입니다.");
        }
        if (form == null) {
            throw new BadRequestException("자기소개서는 필수값입니다.");
        }
        if (category == null) {
            throw new BadRequestException("카테고리는 필수값입니다.");
        }

        this.id = id;
        this.content = content;
        this.form = form;
        this.category = InterviewCategory.valueOf(category);
    }
}

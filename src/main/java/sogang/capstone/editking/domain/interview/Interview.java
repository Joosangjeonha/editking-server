package sogang.capstone.editking.domain.interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import sogang.capstone.editking.common.exception.BadRequestException;
import sogang.capstone.editking.domain.AbstractTimestamp;

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

    private Long formId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InterviewCategory category;

    @Builder()
    public Interview(
            Long id,
            String content,
            Long formId,
            String category
    ) {
        if (content == null) {
            throw new BadRequestException("내용은 필수값입니다.");
        }
        if (formId == null) {
            throw new BadRequestException("자기소개서는 필수값입니다.");
        }
        if (category == null) {
            throw new BadRequestException("카테고리는 필수값입니다.");
        }

        this.id = id;
        this.content = content;
        this.formId = formId;
        this.category = InterviewCategory.valueOf(category);
    }
}

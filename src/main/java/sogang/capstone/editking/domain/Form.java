package sogang.capstone.editking.domain;

import java.sql.Timestamp;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sogang.capstone.editking.constant.FormStatus;
import sogang.capstone.editking.exception.BadRequestException;

@Getter
@Setter
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
    private Timestamp dueDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "form")
    private List<Question> questionList;

    @OneToMany(mappedBy = "form")
    private List<Interview> interviewList;

    @Builder()
    public Form(
        Long id,
        String title,
        Timestamp dueDate,
        User user,
        Company company
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
    }
}

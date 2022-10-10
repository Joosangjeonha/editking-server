package sogang.capstone.editking.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Category")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Interview> interviewList;

    @Builder()
    public Category(
        Long id,
        String name
    ) {
        if (name == null) {
            throw new BadRequestException("카테고리명은 필수값입니다.");
        }

        this.id = id;
        this.name = name;
    }
}

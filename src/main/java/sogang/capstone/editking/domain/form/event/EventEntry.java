package sogang.capstone.editking.domain.form.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sogang.capstone.editking.domain.AbstractTimestamp;

@Getter
@Entity
@Table(name = "EventEntry")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EventEntry extends AbstractTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private String payload;

    @Builder()
    public EventEntry(String type, String contentType, String payload) {
        this.type = type;
        this.contentType = contentType;
        this.payload = payload;
    }
}

package sogang.capstone.editking.infrastructure.event;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sogang.capstone.editking.domain.form.event.EventEntry;

public interface EventEntryRepository extends JpaRepository<EventEntry, Long> {

    @Query(value = "SELECT * FROM event_entry ORDER BY id ASC LIMIT :limit OFFSET :offset", nativeQuery = true)
    public List<EventEntry> findEventEntryList(@Param("offset") long offset, @Param("limit") long limit);

}

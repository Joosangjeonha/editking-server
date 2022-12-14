package sogang.capstone.editking.infrastructure.event;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sogang.capstone.editking.domain.event.EventEntry;

public interface EventEntryRepository extends JpaRepository<EventEntry, Long> {

    @Query(value = "SELECT e FROM EventEntry e ORDER BY e.id ASC")
    public List<EventEntry> findEventEntryList(Pageable limit);

}

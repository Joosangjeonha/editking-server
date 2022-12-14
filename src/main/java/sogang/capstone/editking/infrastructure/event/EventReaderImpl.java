package sogang.capstone.editking.infrastructure.event;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.event.EventEntry;
import sogang.capstone.editking.domain.event.EventReader;

@Component
@RequiredArgsConstructor
public class EventReaderImpl implements EventReader {

    private final EventEntryRepository eventEntryRepository;

    @Override
    public List<EventEntry> getEventList(Integer offset, Integer limit) {
        Pageable limitPageable = PageRequest.of(offset, limit);
        return eventEntryRepository.findEventEntryList(limitPageable);
    }
}

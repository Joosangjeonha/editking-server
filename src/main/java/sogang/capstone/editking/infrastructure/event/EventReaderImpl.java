package sogang.capstone.editking.infrastructure.event;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.event.EventEntry;
import sogang.capstone.editking.domain.form.event.EventReader;

@Component
@RequiredArgsConstructor
public class EventReaderImpl implements EventReader {

    private final EventEntryRepository eventEntryRepository;

    @Override
    public List<EventEntry> getEventList(Long offset, Integer limit) {
        return eventEntryRepository.findEventEntryList(offset, limit);
    }
}

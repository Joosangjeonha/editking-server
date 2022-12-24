package sogang.capstone.editking.infrastructure.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.event.EventEntry;
import sogang.capstone.editking.domain.form.event.EventStore;

@Component
@RequiredArgsConstructor
public class EventStoreImpl implements EventStore {

    private final EventEntryRepository eventEntryRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void store(Object event) {
        EventEntry eventEntry = EventEntry.builder()
                .type(event.getClass().getName())
                .contentType("application/json")
                .payload(toJson(event))
                .build();
        eventEntryRepository.save(eventEntry);
    }

    private String toJson(Object event) {
        try {
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

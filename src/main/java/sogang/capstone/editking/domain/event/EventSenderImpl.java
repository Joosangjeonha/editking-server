package sogang.capstone.editking.domain.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.common.event.Event;
import sogang.capstone.editking.common.event.Events;

@Component
@RequiredArgsConstructor
public class EventSenderImpl implements EventSender {

    private final ObjectMapper objectMapper;

    @Override
    public void send(EventEntry eventEntry) {
        try {
            Event event = (Event) objectMapper.readValue(eventEntry.getPayload(), Class.forName(eventEntry.getType()));
            Events.raise(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

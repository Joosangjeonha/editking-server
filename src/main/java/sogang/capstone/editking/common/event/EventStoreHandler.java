package sogang.capstone.editking.common.event;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.event.EventStore;

@Component
@AllArgsConstructor
public class EventStoreHandler {

    private EventStore eventStore;

    @EventListener(Event.class)
    public void handle(Event event) {
        eventStore.store(event);
    }
}

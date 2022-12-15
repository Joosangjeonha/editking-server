package sogang.capstone.editking.common.event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import sogang.capstone.editking.domain.event.EventStore;

@Component
@AllArgsConstructor
public class EventStoreHandler {

    private EventStore eventStore;

    @TransactionalEventListener(
            classes = Event.class,
            phase = TransactionPhase.BEFORE_COMMIT
    )
    public void handle(Event event) {
        eventStore.store(event);
    }
}

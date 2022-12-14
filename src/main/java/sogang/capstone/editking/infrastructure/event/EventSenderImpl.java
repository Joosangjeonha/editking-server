package sogang.capstone.editking.infrastructure.event;

import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.event.EventEntry;
import sogang.capstone.editking.domain.event.EventSender;

@Component
public class EventSenderImpl implements EventSender {

    private long check = 0;

    @Override
    public void send(EventEntry event) {
        System.out.println("이벤트 id " + check++);
    }

}

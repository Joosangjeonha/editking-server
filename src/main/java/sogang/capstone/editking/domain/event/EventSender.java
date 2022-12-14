package sogang.capstone.editking.domain.event;

public interface EventSender {

    void send(EventEntry event);

}

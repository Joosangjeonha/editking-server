package sogang.capstone.editking.domain.event;

public interface EventStore {

    void store(Object event);

}

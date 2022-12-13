package sogang.capstone.editking.common.event;

public interface EventHandler<T> {

    void handle(T event);
}

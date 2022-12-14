package sogang.capstone.editking.domain.event;

public interface OffsetReaderStore {

    long get();

    void update(long nextOffset);
}

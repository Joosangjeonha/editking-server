package sogang.capstone.editking.domain.form.event;

public interface OffsetReaderStore {

    long get();

    void update(long nextOffset);
}

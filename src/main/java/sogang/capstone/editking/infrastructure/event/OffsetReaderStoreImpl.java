package sogang.capstone.editking.infrastructure.event;

import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.form.event.OffsetReaderStore;

@Component
public class OffsetReaderStoreImpl implements OffsetReaderStore {

    private long nextOffset = 0;

    @Override
    public long get() {
        return nextOffset;
    }

    @Override
    public void update(long nextOffset) {
        this.nextOffset = nextOffset;
    }

}

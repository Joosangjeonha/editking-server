package sogang.capstone.editking.infrastructure.event;

import org.springframework.stereotype.Component;
import sogang.capstone.editking.domain.event.OffsetReaderStore;

@Component
public class OffsetReaderStoreImpl implements OffsetReaderStore {

    private long nextOffset = 0;

    @Override
    public long get() {
        System.out.println("nextOffset : " + nextOffset);
        return nextOffset;
    }

    @Override
    public void update(long nextOffset) {
        this.nextOffset = nextOffset;
    }

}

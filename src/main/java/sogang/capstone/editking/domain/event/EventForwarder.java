package sogang.capstone.editking.domain.event;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventForwarder {

    private static final int DEFAULT_LIMIT_SIZE = 100;

    private EventReader eventReader;
    private OffsetReaderStore offsetReaderStore;
    private EventSender eventSender;

    public EventForwarder(EventReader eventReader, OffsetReaderStore offsetReaderStore, EventSender eventSender) {
        this.eventReader = eventReader;
        this.offsetReaderStore = offsetReaderStore;
        this.eventSender = eventSender;
    }

    @Scheduled(initialDelay = 1 * 1000, fixedDelay = 5 * 1000)
    public void getAndSend() {
        Long nextOffset = getNextOffset();
        List<EventEntry> events = eventReader.getEventList(nextOffset, DEFAULT_LIMIT_SIZE);
        if (!events.isEmpty()) {
            int processedCount = sendEvent(events);
            if (processedCount > 0) {
                saveNextOffset(nextOffset + processedCount);
            }
        }
    }

    private long getNextOffset() {
        return offsetReaderStore.get();
    }

    private int sendEvent(List<EventEntry> events) {
        int processedCount = 0;
        try {
            for (EventEntry entry : events) {
                eventSender.send(entry);
                processedCount++;
            }
        } catch (RuntimeException ex) {
            log.info(events.get(processedCount).getId() + "번 이벤트 처리 실패");
        }
        return processedCount;
    }

    private void saveNextOffset(long nextOffset) {
        offsetReaderStore.update(nextOffset);
    }

}

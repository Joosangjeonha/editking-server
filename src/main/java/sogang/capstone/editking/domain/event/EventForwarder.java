package sogang.capstone.editking.domain.event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventForwarder {

    private static final int DEFAULT_LIMIT_SIZE = 100;

    private EventReader eventReader;
    private OffsetReaderStore offsetReaderStore;
    private EventSender eventSender;
    private List<Long> failureOffsetList;
    private List<Long> currentFailureOffset;

    public EventForwarder(EventReader eventReader, OffsetReaderStore offsetReaderStore, EventSender eventSender) {
        this.eventReader = eventReader;
        this.offsetReaderStore = offsetReaderStore;
        this.eventSender = eventSender;
        this.failureOffsetList = new ArrayList<>();
        this.currentFailureOffset = new ArrayList<>();
    }

    @Async
    @Scheduled(initialDelay = 1 * 1000, fixedDelay = 60 * 1000)
    public void getAndSend() {
        Long nextOffset = getNextOffset();
        List<EventEntry> events = eventReader.getEventList(nextOffset, DEFAULT_LIMIT_SIZE);
        if (!events.isEmpty()) {
            int processedCount = sendEvent(events);
            if (processedCount > 0) {
                saveNextOffset(nextOffset + processedCount);
            }
        }
        jumpDuplicateFailureOffset(nextOffset);
    }

    private long getNextOffset() {
        return offsetReaderStore.get();
    }

    private void jumpDuplicateFailureOffset(long nextOffset) {
        List<Long> tempFailureOffset = currentFailureOffset.stream().distinct().collect(Collectors.toList());
        if (tempFailureOffset.size() == 1 && currentFailureOffset.size() >= 3) {
            failureOffsetList.add(currentFailureOffset.get(0));
            currentFailureOffset.clear();
            offsetReaderStore.update(nextOffset + 1);
        }
    }

    private int sendEvent(List<EventEntry> events) {
        int processedCount = 0;
        try {
            for (EventEntry entry : events) {
                eventSender.send(entry);
                processedCount++;
            }
        } catch (RuntimeException ex) {
            currentFailureOffset.add(events.get(processedCount).getId());
            log.info(events.get(processedCount).getId() + "번 이벤트 처리 실패");
        }
        return processedCount;
    }

    private void saveNextOffset(long nextOffset) {
        offsetReaderStore.update(nextOffset);
    }

}

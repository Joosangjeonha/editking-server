package sogang.capstone.editking.domain.event;

import java.util.List;

public interface EventReader {

    List<EventEntry> getEventList(Long offset, Integer limit);
}

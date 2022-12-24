package sogang.capstone.editking.domain.form.event;

import java.util.List;

public interface EventReader {

    List<EventEntry> getEventList(Long offset, Integer limit);
}

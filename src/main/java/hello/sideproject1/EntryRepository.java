package hello.sideproject1;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EntryRepository {

    Long entryId = 1L;
    Map<Long, Entry> entries = new HashMap<>();

    // 일기 저장하기
    public Entry save(Entry entry) {
        entry.setId(entryId++);

        LocalDateTime now = LocalDateTime.now();
        entry.setLocalDateTime(now);

        entries.put(entry.getId(), entry);

        return entry;
    }

    // 상세보기
    public Entry findEntry(Long id) {
        return entries.get(id);
    }

    public List<Entry> findAll() {
       return new ArrayList<>(entries.values());
    }

    // 수정하기
    public void edit(Long id, Entry updateEntry) {
        Entry currentEntry = entries.get(id);

        currentEntry.setTitle(updateEntry.getTitle());
        currentEntry.setContent(updateEntry.getContent());
        currentEntry.setLocalDateTime(updateEntry.getLocalDateTime());
    }

    // 삭제하기
    public void delete(Long id) {
        entries.remove(id);
    }

    public void deleteAll() {
        entries.clear();
    }
}

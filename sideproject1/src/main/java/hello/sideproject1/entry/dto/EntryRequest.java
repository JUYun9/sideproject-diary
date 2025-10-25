package hello.sideproject1.entry.dto;

import hello.sideproject1.entry.Entry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntryRequest {

    private String title;

    private String content;

    public Entry toEntry() {
        return new Entry(title, content);
    }
}

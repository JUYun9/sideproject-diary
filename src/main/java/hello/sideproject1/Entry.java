package hello.sideproject1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Entry {

    Long id;
    String title;
    String content;
    LocalDateTime localDateTime;

    public Entry() {

    }

    public Entry(String title, String content, LocalDateTime localDateTime) {
        this.title = title;
        this.content = content;
        this.localDateTime = localDateTime;
    }
}

package demo.ToeicWord.note.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Note {
    private Long noteId;
    private Long userId;
    private String noteName;
    private int size;

    public Note(Long noteId, Long userId, String noteName) {
        this.noteId = noteId;
        this.userId = userId;
        this.noteName = noteName;
        this.size = 0;
    }
}

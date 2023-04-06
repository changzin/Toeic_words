package demo.ToeicWord.word.repository;

import demo.ToeicWord.word.domain.Word;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryWordRepository implements WordRepository{
    private static Map<Long, Word> words = new HashMap<>();
    private Long sequence = 0L;
    @Override
    public Word save(Word word) {
        word.setId(++sequence);
        words.put(word.getId(), word);
        return word;
    }

    @Override
    public Optional<Word> findById(Long id) {
        return Optional.ofNullable(words.get(id));
    }
}

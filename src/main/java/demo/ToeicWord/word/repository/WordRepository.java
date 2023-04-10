package demo.ToeicWord.word.repository;

import demo.ToeicWord.word.domain.Word;

import java.util.List;
import java.util.Optional;

public interface WordRepository {
    Word save(Word word);
    Optional<Word> findById(Long id);

    List<Word> selectAllWords();
}

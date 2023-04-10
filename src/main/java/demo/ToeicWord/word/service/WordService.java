package demo.ToeicWord.word.service;

import demo.ToeicWord.word.domain.Word;
import demo.ToeicWord.word.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordService {

    private final WordRepository wordRepository;
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word addOne(Word word){
        return wordRepository.save(word);
    }
    public Optional<Word> findOne(Long id){
        return wordRepository.findById(id);
    }
}

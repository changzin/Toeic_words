package demo.ToeicWord.word.service;

import demo.ToeicWord.word.domain.Word;
import demo.ToeicWord.word.repository.MemoryWordRepository;
import demo.ToeicWord.word.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class WordService {

    private final WordRepository wordRepository;
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word addOne(Word word){
        return wordRepository.save(word);
    }
    public Word findOne(Long id){
        return wordRepository.findById(id).get();
    }
}

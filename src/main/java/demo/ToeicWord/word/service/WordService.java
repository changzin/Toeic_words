package demo.ToeicWord.word.service;

import demo.ToeicWord.MyLogger.MyLogger;
import demo.ToeicWord.word.TestWord;
import demo.ToeicWord.word.domain.Word;
import demo.ToeicWord.word.repository.WordRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WordService {
    private final int FIRST_TEST_NUMBER = 1;
    private final WordRepository wordRepository;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public Word addOne(Word word){
        return wordRepository.save(word);
    }

    public Word findOne(Long id){
        if (wordRepository.findById(id).isEmpty())
            throw new IllegalStateException("존재하지 않는 회원입니다");
        return wordRepository.findById(id).get();
    }

    public List<Word> findAll(){
        return wordRepository.selectAllWords();
    }

    public List<TestWord> firstTest(){
        List<Word> words = findAll();
        List<Word> testWords = new ArrayList<>();
        List<TestWord> tests = new ArrayList<>();
        Collections.shuffle(words);
        for(int i = 0; i < FIRST_TEST_NUMBER; i++){
            testWords.add(words.get(i));
        }
        for(Word word : testWords){

            tests.add(new TestWord(word, findAll()));
        }
        return tests;
    }

    public void logging(String id) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}

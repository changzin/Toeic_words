package demo.ToeicWord.word;

import demo.ToeicWord.word.domain.Word;
import demo.ToeicWord.word.service.WordService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

    @PostMapping("/words/new")
    public ResponseEntity create(Dto dto){
        Word word = new Word();
        System.out.println(word.getId());

        word.setSpell(dto.getSpell());
        word.setMean(dto.getMean());
        try{
            word = wordService.addOne(word);
        }
        catch(IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        System.out.println(word.getId());
        return ResponseEntity.ok().body(word);
    }

    @GetMapping("/words")
    public ResponseEntity readOne(@RequestParam("id") Long id){
        try{
            wordService.findOne(id);
        }
        catch(IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(wordService.findOne(id));
    }

    @GetMapping("/words/findAll")
    public ResponseEntity readAll(){
        List<Word> wordList = wordService.findAll();
        return ResponseEntity.ok().body(wordList);
    }

    @GetMapping("/firstTest")
    public String firstTest(){
        List<TestWord> TestWordList = wordService.firstTest();
        for(TestWord testWord : TestWordList){
            System.out.println(testWord.getWord().getSpell() + " " + testWord.getWord().getMean());
            for (String choice : testWord.getChoice()){
                System.out.println("    " + choice);
            }
        }
        return "OK";
    }

    @PostMapping("words/update")
    public ResponseEntity updateOne(Word word) {
        try {
            wordService.updateOne(word);
        }
        catch (IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return  ResponseEntity.ok().body(wordService.updateOne(word));
    }

    @PostMapping("words/delete")
    public String removeOne(Long id){
        return wordService.deleteOne(id);
    }
}

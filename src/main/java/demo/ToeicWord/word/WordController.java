package demo.ToeicWord.word;

import demo.ToeicWord.word.domain.Word;
import demo.ToeicWord.word.service.WordService;
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

    @PostMapping("/new")
    public ResponseEntity create(Dto dto){
        Word word = new Word();
        word.setSpell(dto.getSpell());
        word.setMean(dto.getMean());
        try{
            wordService.addOne(word);
        }
        catch(IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(wordService.findOne(word.getId()));
    }

    @GetMapping("/find")
    public ResponseEntity readOne(@RequestParam("id") Long id){
        return ResponseEntity.ok().body(wordService.findOne(id));
    }

    @GetMapping("/findAll")
    public String readAll(){
        List<Word> wordList = wordService.findAll();
        for(Word word : wordList){
            System.out.println(word.getId() + " " + word.getSpell() + " " + word.getMean());
        }
        return "OK";
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
}

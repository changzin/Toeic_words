package demo.ToeicWord.word;

import demo.ToeicWord.word.domain.Word;
import demo.ToeicWord.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordController {
    private final WordService wordService;
    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }
    @PostMapping("/new")
    public ResponseEntity create(Dto dto){
        Word user = new Word();
        user.setSpell(dto.getSpell());
        user.setMean(dto.getMean());
        try{
            wordService.addOne(user);
        }
        catch(IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(wordService.findOne(user.getId()));
    }
    @GetMapping("/find")
    public String readOne(@RequestParam("id") Long id){
        return "asd";
    }
}

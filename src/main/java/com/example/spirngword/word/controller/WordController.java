package com.example.spirngword.word.controller;

import com.example.spirngword.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/find")
    public ResponseEntity read(@RequestParam("id") Long id){
        return ResponseEntity.ok().body(wordService.findOne(id));
    }
}

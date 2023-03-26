package com.example.spirngword.service;

import com.example.spirngword.domain.Word;
import com.example.spirngword.repositoy.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class WordService {
    private final WordRepository wordRepository;
    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }
    public Optional<Word> findOne(Long id){
        return wordRepository.findById(id);
    }
}

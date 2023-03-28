package com.example.spirngword.word.repository;

import com.example.spirngword.word.domain.Word;

import java.util.Optional;

public interface WordRepository {
    Optional<Word> findById(Long id);
}

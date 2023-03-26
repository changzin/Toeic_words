package com.example.spirngword.repositoy;

import com.example.spirngword.domain.Word;

import java.util.Optional;

public interface WordRepository {
    Optional<Word> findById(Long id);
}

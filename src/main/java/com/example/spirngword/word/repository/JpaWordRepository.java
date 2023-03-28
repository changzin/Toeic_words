package com.example.spirngword.word.repository;

import com.example.spirngword.word.domain.Word;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class JpaWordRepository implements WordRepository{
    private final EntityManager em;
    public JpaWordRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Word> findById(Long id) {
        Word word = em.find(Word.class, id);
        return Optional.ofNullable(word);
    }
}

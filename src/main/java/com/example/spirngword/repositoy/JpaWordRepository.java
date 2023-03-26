package com.example.spirngword.repositoy;

import com.example.spirngword.domain.Word;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

package com.example.spirngword;

import com.example.spirngword.word.repository.JpaWordRepository;
import com.example.spirngword.word.repository.WordRepository;
import com.example.spirngword.word.service.WordService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public WordService wordService(){
        return new WordService(wordRepository());
    }
    @Bean
    public WordRepository wordRepository(){
        return new JpaWordRepository(em);
    }
}

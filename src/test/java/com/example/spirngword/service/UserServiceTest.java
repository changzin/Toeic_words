package com.example.spirngword.service;

import com.example.spirngword.domain.Word;
import com.example.spirngword.repositoy.WordRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    WordService wordService;
    @Autowired
    WordRepository wordRepository;
    @Test
    public void findOne(){
        //given
        Long findId = 1L;
        //when
        Word findWord = wordService.findOne(findId).get();
        //then
        Assertions.assertThat(findId).isEqualTo(findWord.getId());
    }
}

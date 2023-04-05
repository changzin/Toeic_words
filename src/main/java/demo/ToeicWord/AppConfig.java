package demo.ToeicWord;
import demo.ToeicWord.word.repository.MemoryWordRepository;
import demo.ToeicWord.word.repository.WordRepository;
import demo.ToeicWord.word.service.WordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.ls.LSOutput;

import javax.sql.DataSource;
@Configuration
public class AppConfig {

    private final DataSource dataSource;

    public AppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
        System.out.println(dataSource.toString());
    }
    @Bean
    public WordService wordService (WordRepository wordRepository){
        return new WordService(wordRepository);
    }
    @Bean
    public MemoryWordRepository wordRepository(){
        return new MemoryWordRepository();
    }
}
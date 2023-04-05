package demo.ToeicWord;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    void config(){
        ;
    }
}

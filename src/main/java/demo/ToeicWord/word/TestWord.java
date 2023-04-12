package demo.ToeicWord.word;

import demo.ToeicWord.word.domain.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestWord {
    private final int CHOICE_NUMBER = 4;
    private Word word;
    private List<String> choice = new ArrayList<>();

    public TestWord(Word word, List<Word> words) {
        this.word = word;
        makeChoice(words);
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public List<String> getChoice() {
        return choice;
    }

    public void makeChoice(List<Word> words) {
        Collections.shuffle(words);
        this.choice.add(this.word.getMean());
        int i = 0;
        while(this.choice.size() != CHOICE_NUMBER){
            String str = words.get(i).getMean();
            i++;
            if (!str.equals(this.word.getMean()))
                this.choice.add(str);
        }
        Collections.shuffle(this.choice);
    }
}

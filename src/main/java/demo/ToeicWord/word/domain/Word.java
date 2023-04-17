package demo.ToeicWord.word.domain;

public class Word {
    private long wordId;
    private String spell;
    private String mean;

    public Word() {
    }

    public Word(String spell, String mean) {
        this.spell = spell;
        this.mean = mean;
    }

    public long getId() {
        return wordId;
    }

    public void setId(long wordId) {
        this.wordId = wordId;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}

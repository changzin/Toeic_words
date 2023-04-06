package demo.ToeicWord.word.domain;

public class Word {
    private long id;
    private String spell;
    private String mean;

    public Word() {
    }

    public Word(String spell, String mean) {
        this.spell = spell;
        this.mean = mean;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

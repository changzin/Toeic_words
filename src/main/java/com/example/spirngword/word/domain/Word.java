package com.example.spirngword.word.domain;

import jakarta.persistence.*;


@Entity
@Table(name="WORD")
public class Word {
    @Id
    @GeneratedValue
    @Column(name="WORD_ID")
    private Long id;
    @Column(name="WORD_SPELL")
    private String spell;
    @Column(name="WORD_MEAN")
    private String mean;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

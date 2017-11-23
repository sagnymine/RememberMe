package com.cihan.rememberme.com.cihan.rememberme.model.dto;

import lombok.Getter;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

@Getter
public class WordExampleDAO {

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample_sentence() {
        return example_sentence;
    }

    public void setExample_sentence(String example_sentence) {
        this.example_sentence = example_sentence;
    }

    private String word;
    private String definition;
    private String example_sentence;

    public WordExampleDAO(WordExampleInterface wordExampleInterface) {
        this.word = wordExampleInterface.;
        this.definition = wordExampleInterface.getDefinition();
        this.example_sentence = wordExampleInterface.getExample_sentence();
    }

}

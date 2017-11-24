package com.cihan.rememberme.com.cihan.rememberme.model.dto;

import com.cihan.rememberme.com.cihan.rememberme.model.realm.WordExampleRealm;



/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public class WordExampleDTO {

    public WordExampleDTO(){

    }
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

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    private String word;
    private String definition;
    private String exampleSentence;
    private int askCount;
    private int correctAnswerCount;

    public int getAskCount() {
        return askCount;
    }

    public void setAskCount(int askCount) {
        this.askCount = askCount;
    }

    public int getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    public void setCorrectAnswerCount(int correctAnswerCount) {
        this.correctAnswerCount = correctAnswerCount;
    }


    public WordExampleDTO(WordExampleRealm wordExampleRealm) {
        this.word = wordExampleRealm.getWord();
        this.definition = wordExampleRealm.getDefinition();
        this.exampleSentence = wordExampleRealm.getExample_sentence();
    }

    public WordExampleDTO(String word, String definition, String example_sentence){
        this.word = word;
        this.definition = definition;
        this.exampleSentence = example_sentence;
    }
}

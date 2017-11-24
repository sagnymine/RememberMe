package com.cihan.rememberme.com.cihan.rememberme.model.realm;

import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */


public class WordExampleRealm extends RealmObject {

    @PrimaryKey
    private int wordId;
    private String word;
    private String definition;
    private String example_sentence;
    private int askCount;
    private int correctAnswerCount;

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
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

    public String getExample_sentence() {
        return example_sentence;
    }

    public void setExample_sentence(String example_sentence) {
        this.example_sentence = example_sentence;
    }


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

    public WordExampleRealm(WordExampleDTO wordExampleDTO) {

        this.word = wordExampleDTO.getWord();
        this.definition = wordExampleDTO.getDefinition();
        this.example_sentence = wordExampleDTO.getExampleSentence();
        this.askCount = wordExampleDTO.getAskCount();
        this.correctAnswerCount = wordExampleDTO.getCorrectAnswerCount();
        this.wordId = wordExampleDTO.getWordId();
    }
    public WordExampleRealm(){

    }

}

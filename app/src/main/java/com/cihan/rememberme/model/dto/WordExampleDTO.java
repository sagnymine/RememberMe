package com.cihan.rememberme.model.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.cihan.rememberme.model.realm.WordExampleRealm;



/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public class WordExampleDTO implements Parcelable {

    public WordExampleDTO(){

    }


    private int wordId;
    private String word;
    private String definition;
    private String exampleSentence;
    private int askCount;
    private int correctAnswerCount;

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

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
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


    public WordExampleDTO(WordExampleRealm wordExampleRealm) {
        this.word = wordExampleRealm.getWord();
        this.definition = wordExampleRealm.getDefinition();
        this.exampleSentence = wordExampleRealm.getExample_sentence();
        this.askCount = wordExampleRealm.getAskCount();
        this.correctAnswerCount = wordExampleRealm.getCorrectAnswerCount();
        this.wordId = wordExampleRealm.getWordId();
    }

    public WordExampleDTO(String word, String definition, String example_sentence){
        this.word = word;
        this.definition = definition;
        this.exampleSentence = example_sentence;
    }

    protected WordExampleDTO(Parcel in) {
        wordId = in.readInt();
        word = in.readString();
        definition = in.readString();
        exampleSentence = in.readString();
        askCount = in.readInt();
        correctAnswerCount = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(wordId);
        dest.writeString(word);
        dest.writeString(definition);
        dest.writeString(exampleSentence);
        dest.writeInt(askCount);
        dest.writeInt(correctAnswerCount);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<WordExampleDTO> CREATOR = new Parcelable.Creator<WordExampleDTO>() {
        @Override
        public WordExampleDTO createFromParcel(Parcel in) {
            return new WordExampleDTO(in);
        }

        @Override
        public WordExampleDTO[] newArray(int size) {
            return new WordExampleDTO[size];
        }
    };
}
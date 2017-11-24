package com.cihan.rememberme.com.cihan.rememberme.data;

import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

import java.util.List;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public interface DataAccessInterface {


    public List<WordExampleDTO> getWords();
    public boolean addBook(WordExampleDTO word);
    public boolean hasWords();
    public WordExampleDTO getWord(String id);
    public void clearAll();
}
package com.cihan.rememberme.data;

import com.cihan.rememberme.model.dto.WordExampleDTO;

import java.util.List;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public interface DataAccessInterface {


    public List<WordExampleDTO> getWords();
    public void addWord(WordExampleDTO word);
    public WordExampleDTO getWord(int id);
    public void clearAll();
}

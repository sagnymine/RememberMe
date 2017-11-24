package com.cihan.rememberme.com.cihan.rememberme.modules.addnewword;

import android.util.Log;

import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessCreator;
import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessInterface;
import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

import java.util.List;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public class AddOrUpdateWordPresenter {

    DataAccessInterface dataAccess;

    public AddOrUpdateWordPresenter(){
        DataAccessCreator dataControllerCreator = new DataAccessCreator();
        dataAccess = dataControllerCreator.GetDataAccess();
    }
    public void saveWord(WordExampleDTO word){

        dataAccess.addWord(word);
        List<WordExampleDTO> words =  dataAccess.getWords();
        Log.i("Word Log","count: "+ words.size());
    }
}

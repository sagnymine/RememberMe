package com.cihan.rememberme.module.wordlist;

import com.cihan.rememberme.data.DataAccessCreator;
import com.cihan.rememberme.data.DataAccessInterface;
import com.cihan.rememberme.model.dto.WordExampleDTO;

import java.util.List;

/**
 * Created by cihan.ozdiker on 24.11.2017.
 */


public class ListWordsPresenter {

    DataAccessInterface dataAccess;
    ListWordsView view;
    public ListWordsPresenter(ListWordsView view){
        this.view = view;
        DataAccessCreator dataControllerCreator = new DataAccessCreator();
        dataAccess = dataControllerCreator.GetDataAccess();


    }
    public List<WordExampleDTO> getWords(){

        return   dataAccess.getWords();

    }
    public void removeWord(int id){

        dataAccess.removeWord(id);
        view.showRemoveAlert();

    }

}

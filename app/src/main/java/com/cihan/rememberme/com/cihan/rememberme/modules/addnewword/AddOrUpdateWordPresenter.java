package com.cihan.rememberme.com.cihan.rememberme.modules.addnewword;

import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessCreator;
import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessInterface;
import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

import java.util.List;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public class AddOrUpdateWordPresenter {

    DataAccessInterface dataAccess;
    AddOrUpdateWordActivity mActivity;
    public AddOrUpdateWordPresenter(AddOrUpdateWordActivity activity){
        DataAccessCreator dataControllerCreator = new DataAccessCreator();
        dataAccess = dataControllerCreator.GetDataAccess();
        mActivity = activity;
    }
    public void saveWord(WordExampleDTO word){

        dataAccess.addWord(word);
        List<WordExampleDTO> words =  dataAccess.getWords();
        mActivity.showWordAlert();

    }


}

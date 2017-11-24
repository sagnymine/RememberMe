package com.cihan.rememberme.com.cihan.rememberme.data;

import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;
import com.cihan.rememberme.com.cihan.rememberme.model.realm.WordExampleRealm;
import com.cihan.rememberme.com.cihan.rememberme.realm.RealmController;

import java.util.List;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public class DataController {


    DataAccessInterface dataAccess;

    public DataController(){
        DataAccessCreator dataControllerCreator = new DataAccessCreator();
         dataAccess = dataControllerCreator.GetDataAccess();
    }

    public List<WordExampleDTO> getWords(){


        return dataAccess.getWords();

     }

     public boolean addBook(WordExampleDTO word){

        return dataAccess.addBook(word);
     }

    public void cleanDB(){

        dataAccess.clearAll();
    }


    public boolean hasWords(){
       return dataAccess.hasWords();
    }
    public WordExampleDTO getWord(String id){
        return dataAccess.getWord(id);
    }


}

package com.cihan.rememberme.com.cihan.rememberme.data;

import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

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

     public void addWord(WordExampleDTO word){

         dataAccess.addWord(word);
     }

    public void cleanDB(){

        dataAccess.clearAll();
    }



    public WordExampleDTO getWord(int id){
        return dataAccess.getWord(id);
    }


}

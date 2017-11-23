package com.cihan.rememberme.com.cihan.rememberme.model;

import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;
import com.cihan.rememberme.com.cihan.rememberme.realm.RealmController;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public class DataController {

     RealmController myDataAccess;
    public DataController(DataAccessInterface dAI){
        myDataAccess = dAI;
    }
    public WordExampleDTO getWords(DataAccessInterface dataAccessInterface){
        dataAccessInterface{

        }
    }
}

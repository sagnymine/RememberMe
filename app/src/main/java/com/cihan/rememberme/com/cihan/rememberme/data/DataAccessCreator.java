package com.cihan.rememberme.com.cihan.rememberme.data;

import com.cihan.rememberme.com.cihan.rememberme.realm.RealmController;

/**
 * Created by cihan.ozdiker on 24.11.2017.
 */

public class DataAccessCreator {

    public DataAccessInterface GetDataAccess(){

        return  new RealmController();
    }
}

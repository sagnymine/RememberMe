package com.cihan.rememberme.data;

/**
 * Created by cihan.ozdiker on 24.11.2017.
 */

public class DataAccessCreator {

    public DataAccessInterface GetDataAccess(){

        return  new RealmController();
    }
}

package com.cihan.rememberme.com.cihan.rememberme.realm;

import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessInterface;
import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;
import com.cihan.rememberme.com.cihan.rememberme.model.realm.WordExampleRealm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public class RealmController implements DataAccessInterface  {

    private static RealmController instance;
    private final Realm realm;

    public RealmController() {
        realm = Realm.getDefaultInstance();
    }







    //Refresh the realm istance
    public void refresh() {

        realm.refresh();
    }

    //clear all objects from Book.class
    public void clearAll() {

        realm.beginTransaction();
        realm.clear(WordExampleRealm.class);
        realm.commitTransaction();
    }

    //find all objects in the Book.class
    public List<WordExampleDTO> getWords() {

        List<WordExampleDTO> words = new ArrayList<>();
        RealmResults<WordExampleRealm> results =  realm.where(WordExampleRealm.class).findAll();

        Iterator<WordExampleRealm> iterator = results.iterator();
        while(iterator.hasNext()) {

            WordExampleRealm wordExampleRealm = iterator.next();
            words.add(new WordExampleDTO(wordExampleRealm));
        }
        return words;
    }

    //query a single item with the given id
    public WordExampleDTO getWord(String id) {

        WordExampleRealm wordRealm =  realm.where(WordExampleRealm.class).equalTo("id", id).findFirst();
        return  new WordExampleDTO(wordRealm);
    }

    //check if Book.class is empty
    public boolean hasWords() {

        return !realm.allObjects(WordExampleRealm.class).isEmpty();
    }
    public boolean addBook(WordExampleDTO word) {


        realm.beginTransaction();
        realm.copyToRealm(new WordExampleRealm(word));
        realm.commitTransaction();
        return true;
    }
}

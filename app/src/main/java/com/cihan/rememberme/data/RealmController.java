package com.cihan.rememberme.data;

import com.cihan.rememberme.model.dto.WordExampleDTO;
import com.cihan.rememberme.model.realm.WordExampleRealm;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by cihan.ozdiker on 23.11.2017.
 */

public class RealmController implements DataAccessInterface  {

    private static RealmController instance;
    private Realm realm;





    public void refresh() {

        realm.refresh();
    }

    private void close(){
        realm.close();
    }

    public void clearAll() {


    }

    public List<WordExampleDTO> getWords() {

        realm = Realm.getDefaultInstance();
        List<WordExampleDTO> words = new ArrayList<>();
        RealmResults<WordExampleRealm> results =  realm.where(WordExampleRealm.class).findAll();



        for(int i=0; i<results.size();i++) {


            words.add(new WordExampleDTO(results.get(i)));
        }
        realm.close();
        return words;
    }

    public WordExampleDTO getWord(int id) {

        realm = Realm.getDefaultInstance();
        WordExampleRealm wordRealm =  realm.where(WordExampleRealm.class).equalTo("wordId", id).findFirst();
        if(wordRealm!=null){

            return  new WordExampleDTO(wordRealm);
        }
        return null;

    }


    public void addWord(WordExampleDTO word) {
        realm = Realm.getDefaultInstance();
        final WordExampleRealm wordExampleRealm = new WordExampleRealm(word);
        if(wordExampleRealm.getWordId()==0) {
            Number currentIdNum = realm.where(WordExampleRealm.class).max("wordId");
            int nextId;
            if (currentIdNum == null) {
                nextId = 1;
            } else {
                nextId = currentIdNum.intValue() + 1;
            }
            wordExampleRealm.setWordId(nextId);
        }
        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insertOrUpdate(wordExampleRealm);
                }
            });
        } finally {
            if(realm != null) {
                realm.close();
            }
        }



    }
}

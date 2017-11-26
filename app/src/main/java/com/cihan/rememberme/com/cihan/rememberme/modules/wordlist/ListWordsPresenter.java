package com.cihan.rememberme.com.cihan.rememberme.modules.wordlist;

import android.speech.tts.TextToSpeech;

import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessCreator;
import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessInterface;
import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

import java.util.List;
import java.util.Locale;

/**
 * Created by cihan.ozdiker on 24.11.2017.
 */


public class ListWordsPresenter {

    DataAccessInterface dataAccess;
    private TextToSpeech speech;
    private ListWordsActivity mActivity;
    public ListWordsPresenter(ListWordsActivity activity){
        DataAccessCreator dataControllerCreator = new DataAccessCreator();
        dataAccess = dataControllerCreator.GetDataAccess();
        mActivity = activity;

        speech=new TextToSpeech(mActivity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.US);

                }
            }
        });
    }
    public List<WordExampleDTO> getWords(){

        return   dataAccess.getWords();

    }
    public void speakText(String text){
        speech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}

package com.cihan.rememberme.com.cihan.rememberme.modules.wordlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cihan.rememberme.R;

public class ListWordsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_words);
        if(getIntent().hasExtra("Words")){
            /*
            wordExampleDTO = getIntent().getExtras().getParcelable("Word");
            wordText.setText(wordExampleDTO.getWord());
            definitionText.setText(wordExampleDTO.getDefinition());
            sentenceText.setText(wordExampleDTO.getExampleSentence());
            */
        }

    }
}

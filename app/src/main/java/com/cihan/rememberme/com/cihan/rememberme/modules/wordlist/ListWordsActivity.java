package com.cihan.rememberme.com.cihan.rememberme.modules.wordlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cihan.rememberme.R;
import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;
import com.cihan.rememberme.com.cihan.rememberme.modules.addnewword.AddOrUpdateWordActivity;

import java.util.List;

public class ListWordsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WordAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ListWordsPresenter presenter;
    private final int UPDATE = 101;

    static View.OnClickListener wordOnClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_words);
        presenter = new ListWordsPresenter(this);
        List<WordExampleDTO> words =  presenter.getWords();


        recyclerView = (RecyclerView) findViewById(R.id.wordsContainerRV);


        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        setAdapter(words);

    }

    private void setAdapter(List<WordExampleDTO> words){
        adapter = new WordAdapter(this,words);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }




    public void startUpdateWord(WordExampleDTO word){
        Intent intent = new Intent(ListWordsActivity.this, AddOrUpdateWordActivity.class);
        intent.putExtra("Word",word);
        startActivityForResult(intent,UPDATE);
    }

    public void speakText(String text){
        presenter.speakText(text);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (UPDATE) : {
                if (resultCode == Activity.RESULT_OK) {
                    boolean returnValue = data.getBooleanExtra("Updated",false);
                    if(returnValue){
                        List<WordExampleDTO> words =  presenter.getWords();
                        setAdapter(words);
                    }
                }
                break;
            }
        }
    }


}

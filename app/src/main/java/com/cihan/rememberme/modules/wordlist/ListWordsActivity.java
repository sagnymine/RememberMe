package com.cihan.rememberme.modules.wordlist;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.cihan.rememberme.R;
import com.cihan.rememberme.model.dto.WordExampleDTO;
import com.cihan.rememberme.modules.addnewword.AddOrUpdateWordActivity;

import java.util.List;
import java.util.Locale;

public class ListWordsActivity extends AppCompatActivity implements ListWordsView{

    private RecyclerView recyclerView;
    private WordAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ListWordsPresenter presenter;
    private TextToSpeech speech;
    private final int UPDATE = 101;

    static View.OnClickListener wordOnClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_words);
        presenter = new ListWordsPresenter(this);
        speech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.US);

                }
            }
        });

        List<WordExampleDTO> words =  presenter.getWords();


        recyclerView = (RecyclerView) findViewById(R.id.wordsContainerRV);


        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

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
        speech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
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

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

            List<WordExampleDTO> words =  presenter.getWords();

            presenter.removeWord(words.get(viewHolder.getAdapterPosition()).getWordId());

        }

        @Override
        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
            super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
        }
    };


    @Override
    protected void onDestroy() {


        //Close the Text to Speech Library
        if(speech != null) {

            speech.stop();
            speech.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void showRemoveAlert() {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }

                builder.setTitle("Remove")
                        .setMessage("Word removed successfully")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                List<WordExampleDTO> words =  presenter.getWords();
                                setAdapter(words);

                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();



    }
}

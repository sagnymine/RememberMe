package com.cihan.rememberme.modules.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cihan.rememberme.R;
import com.cihan.rememberme.modules.addnewword.AddOrUpdateWordActivity;
import com.cihan.rememberme.modules.wordlist.ListWordsActivity;

public class MainActivity extends AppCompatActivity {


    Button addNewWordBtn,myDictionaryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addNewWordBtn = (Button)findViewById(R.id.add_new_word_btn);
        addNewWordBtn.setOnClickListener(addNewListener);


        myDictionaryAdapter = (Button)findViewById(R.id.myDictionaryAdapter);
        myDictionaryAdapter.setOnClickListener(myDictionaryListener);


       
    }

    private View.OnClickListener  addNewListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, AddOrUpdateWordActivity.class);
            /*
            DataAccessCreator creator = new DataAccessCreator();


            intent.putExtra("Word",creator.GetDataAccess().getWord(1));

            */
            startActivity(intent);

        }
    };

    private View.OnClickListener  myDictionaryListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, ListWordsActivity.class);

            /*
            DataAccessCreator creator = new DataAccessCreator();


            intent.putExtra("Word",creator.GetDataAccess().getWord(1));

            */
            startActivity(intent);

        }
    };
}

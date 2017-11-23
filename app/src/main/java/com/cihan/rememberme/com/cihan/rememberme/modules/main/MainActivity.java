package com.cihan.rememberme.com.cihan.rememberme.modules.addnewword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cihan.rememberme.R;
import com.cihan.rememberme.com.cihan.rememberme.model.DataController;
import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DataController dataController = new DataController();
        dataController.cleanDB();
        dataController.addBook(new WordExampleDTO("Yes","Evet","Yes it is!"));
        List<WordExampleDTO> words =  dataController.getWords();
        Log.i("hello","hello");
    }
}

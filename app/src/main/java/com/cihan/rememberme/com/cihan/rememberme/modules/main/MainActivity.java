package com.cihan.rememberme.com.cihan.rememberme.modules.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cihan.rememberme.R;
import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessCreator;
import com.cihan.rememberme.com.cihan.rememberme.data.DataAccessInterface;
import com.cihan.rememberme.com.cihan.rememberme.data.DataController;
import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataAccessInterface dataAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataAccessCreator dataControllerCreator = new DataAccessCreator();
        dataAccess = dataControllerCreator.GetDataAccess();


        dataAccess.addBook(new WordExampleDTO("Yes","Evet","Yes it is!"));
        List<WordExampleDTO> words =  dataAccess.getWords();
        Log.i("hello","hello");
       
    }
}

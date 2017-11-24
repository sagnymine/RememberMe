package com.cihan.rememberme.com.cihan.rememberme.modules.addnewword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cihan.rememberme.R;
import com.cihan.rememberme.com.cihan.rememberme.model.dto.WordExampleDTO;

public class AddOrUpdateWordActivity extends AppCompatActivity {

    private EditText wordText,sentenceText, definitionText;
    private Button saveButton;
    WordExampleDTO wordExampleDTO;
    AddOrUpdateWordPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        presenter = new AddOrUpdateWordPresenter();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_word);
        wordText = (EditText)findViewById(R.id.wordText);
        definitionText = (EditText)findViewById(R.id.definitionText);
        sentenceText = (EditText)findViewById(R.id.sentenceText);
        saveButton = (Button)findViewById(R.id.saveButton);

        saveButton.setOnClickListener(saveClickListener);

        if(getIntent().hasExtra("Word")){
            wordExampleDTO = getIntent().getExtras().getParcelable("Word");
            wordText.setText(wordExampleDTO.getWord());
            definitionText.setText(wordExampleDTO.getDefinition());
            sentenceText.setText(wordExampleDTO.getExampleSentence());
        }



    }

    View.OnClickListener saveClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            String word = wordText.getText().toString();
            String definition = definitionText.getText().toString();
            String sentence = sentenceText.getText().toString();

            if(word==null||word.length()==0){

            }else{
                //Update
                if(wordExampleDTO!=null){

                    wordExampleDTO.setWord(word);
                    wordExampleDTO.setDefinition(definition);
                    wordExampleDTO.setExampleSentence(sentence);
                }else{

                    wordExampleDTO = new WordExampleDTO(word,definition,sentence);
                }
                presenter.saveWord(wordExampleDTO);
            }
        }
    };
}

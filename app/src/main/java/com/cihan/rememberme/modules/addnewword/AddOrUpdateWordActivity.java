package com.cihan.rememberme.modules.addnewword;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cihan.rememberme.R;
import com.cihan.rememberme.model.dto.WordExampleDTO;

public class AddOrUpdateWordActivity extends AppCompatActivity implements AddOrUpdateView {

    private EditText wordText,sentenceText, definitionText;
    private Button saveButton;
    WordExampleDTO wordExampleDTO;
    AddOrUpdateWordPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        presenter = new AddOrUpdateWordPresenter(this);
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

    public void showWordAlert(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }

        if(getIntent().hasExtra("Word")){
            builder.setTitle("Update")
                    .setMessage("Word updated successfully")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent resultIntent = new Intent();
                            resultIntent.putExtra("Updated", true);
                            setResult(Activity.RESULT_OK, resultIntent);
                            finish();

                        }
                    })

                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else{
            builder.setTitle("Add")
                    .setMessage("Word added successfully")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })

                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

    }
}

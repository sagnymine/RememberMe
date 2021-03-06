package com.cihan.rememberme.module.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cihan.rememberme.R;
import com.cihan.rememberme.model.dto.WordExampleDTO;
import com.cihan.rememberme.module.wordlist.ListWordsActivity;

import java.util.List;

/**
 * Created by cihan on 11/25/17.
 */

public class WordAdapter extends RecyclerView.Adapter {
    private WordView wordView;
    private List<WordExampleDTO> words;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView wordText;
        public Button soundButton;
        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ((ListWordsActivity)view.getContext()).startUpdateWord(words.get(getAdapterPosition()));
                }
            });
            wordText = (TextView) view.findViewById(R.id.wordText);
            soundButton = (Button) view.findViewById(R.id.soundButton);

            soundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wordView.speakText(words.get(getAdapterPosition()).getWord());
                }
            });

        }
    }

    public WordAdapter(WordView wordView, List<WordExampleDTO> words) {
        this.wordView = wordView;
        this.words = words;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_item, parent, false);




        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        WordExampleDTO word = words.get(position);
        ((MyViewHolder)holder).wordText.setText(word.getWord());
    }



    @Override
    public int getItemCount() {
        return words.size();
    }
}

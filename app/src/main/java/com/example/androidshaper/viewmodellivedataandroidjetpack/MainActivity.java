package com.example.androidshaper.viewmodellivedataandroidjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewCount;
    Button buttonAdd,buttonReset;
    Integer score=0;
    ScoreViewModel scoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount=findViewById(R.id.textViewCount);
        buttonAdd=findViewById(R.id.buttonAdd);
        buttonReset=findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        score=0;

        scoreViewModel= ViewModelProviders.of(this).get(ScoreViewModel.class);
//        textViewCount.setText(String.valueOf(scoreViewModel.getScore()));
        scoreViewModel.getScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Toast.makeText(MainActivity.this,String.valueOf(integer),Toast.LENGTH_SHORT).show();
                textViewCount.setText(String.valueOf(integer));

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.buttonAdd)
        {
            addNumber();
        }
        else if (view.getId()==R.id.buttonReset)
        {
            resetNumber();

        }
        
    }

    private void resetNumber() {
//        score=0;
//        textViewCount.setText(String.valueOf(score));
        scoreViewModel.resetScore();
        //textViewCount.setText(String.valueOf(scoreViewModel.getScore()));
    }

    private void addNumber() {
//        score+=1;
//        textViewCount.setText(String.valueOf(score));

        scoreViewModel.addScore();
        //textViewCount.setText(String.valueOf(scoreViewModel.getScore()));

    }
}
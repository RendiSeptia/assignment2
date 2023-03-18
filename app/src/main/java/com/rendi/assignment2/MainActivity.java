package com.rendi.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final String STATE_SCORE = "stateScore";
    int counterScore;
    TextView mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScore = (TextView)  findViewById(R.id.scoreText);
        Button addButton = (Button) findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonAdd){
            counterScore = counterScore+1;
            mScore.setText(String.valueOf(counterScore));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("count", String.valueOf(mScore.getText()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){
            String text = savedInstanceState.getString("count");
            if (mScore != null)
                mScore.setText(text);
        }
    }
}
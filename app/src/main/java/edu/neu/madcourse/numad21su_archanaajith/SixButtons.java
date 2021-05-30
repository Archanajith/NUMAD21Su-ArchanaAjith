package edu.neu.madcourse.numad21su_archanaajith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SixButtons extends AppCompatActivity implements View.OnClickListener {
    Button aButton;
    Button bButton;
    Button cButton;
    Button dButton;
    Button eButton;
    Button fButton;
    TextView textToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_buttons);
        aButton = findViewById(R.id.button3);
        bButton = findViewById(R.id.button4);
        cButton = findViewById(R.id.button5);
        dButton = findViewById(R.id.button6);
        eButton = findViewById(R.id.button7);
        fButton = findViewById(R.id.button8);
        textToDisplay = findViewById(R.id.textView);
        textToDisplay.setText("Click on any of the buttons.");

        aButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        cButton.setOnClickListener(this);
        dButton.setOnClickListener(this);
        eButton.setOnClickListener(this);
        fButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button3:
                textToDisplay.setText("Pressed:Button A");
                break;
            case R.id.button4:
                textToDisplay.setText("Pressed:Button B");
                break;
            case R.id.button5:
                textToDisplay.setText("Pressed:Button C");
                break;
            case R.id.button6:
                textToDisplay.setText("Pressed:Button D");
                break;
            case R.id.button7:
                textToDisplay.setText("Pressed:Button E");
                break;
            case R.id.button8:
                textToDisplay.setText("Pressed:Button F");
                break;

        }
    }
}
package edu.neu.madcourse.numad21su_archanaajith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebService extends AppCompatActivity implements View.OnClickListener {
    private EditText movieName;
    Button searchMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);
        movieName = (EditText)findViewById(R.id.plain_text_input);
        searchMovies = findViewById(R.id.button12);
        searchMovies.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
                String movieSearchText=movieName.getText().toString();
                Intent intentWebService = new Intent(WebService.this, onclickWebService.class);
                intentWebService.putExtra("Search Text Value",movieSearchText);
                startActivity(intentWebService);



    }
}
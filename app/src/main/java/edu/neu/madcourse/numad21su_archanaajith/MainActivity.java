package edu.neu.madcourse.numad21su_archanaajith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button aboutButton;
    Button clickButton;
    Button linkCollector;
    Button clickLocation;
    Button webServiceLocation;
    //Button searchMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aboutButton = findViewById(R.id.button);
        aboutButton.setOnClickListener(this);
        clickButton = findViewById(R.id.button2);
        clickButton.setOnClickListener(this);
        linkCollector=findViewById(R.id.button9);
        linkCollector.setOnClickListener(this);
        clickLocation=findViewById(R.id.button11);
        clickLocation.setOnClickListener(this);
        webServiceLocation=findViewById(R.id.button10);
        webServiceLocation.setOnClickListener(this);
       // searchMovies=findViewById(R.id.button12);
        //searchMovies.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
            switch(v.getId()) {
                case R.id.button:
                    Context context = getApplicationContext();
                    CharSequence name = "Hi, This is Archana";
                    CharSequence email = "Reach me at:ajith.a@northeastern.edu";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, name, duration);
                    Toast toastEmail = Toast.makeText(context, email, duration);
                    toast.show();
                    toastEmail.show();
                    break;
                case R.id.button2:
                    Intent intent = new Intent(MainActivity.this, SixButtons.class);
                    startActivity(intent);
                    break;
                case  R.id.button9:
                    Intent intentURL = new Intent(MainActivity.this, URLLink.class);
                    startActivity(intentURL);
                    break;
                case  R.id.button11:
                    Intent intentLocation = new Intent(MainActivity.this, LocationActivity.class);
                    startActivity(intentLocation);
                    break;
                case  R.id.button10:
                    Intent intentWebService = new Intent(MainActivity.this, WebService.class);
                    startActivity(intentWebService);
                    break;

    }
}
}
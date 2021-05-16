package edu.neu.madcourse.numad21su_archanaajith;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView text=findViewById(R.id.textView3);
        text.setText(" Name : Archana Ajith");
        TextView textEmail=findViewById(R.id.textView5);
        textEmail.setText(" Email : ajith.a@northeastern.edu ");
    }
}
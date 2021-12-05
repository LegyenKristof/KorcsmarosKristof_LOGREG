package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private TextView textViewL1;
    private Button buttonL1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        init();

        textViewL1.setText(getIntent().getStringExtra("nev"));

        buttonL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init(){
        textViewL1 = findViewById(R.id.textViewL1);
        buttonL1 = findViewById(R.id.buttonL1);
    }
}
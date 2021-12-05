package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextR1, editTextR2, editTextR3, editTextR4;
    private Button buttonR1, buttonR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        buttonR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init(){
        editTextR1 = findViewById(R.id.editTextR1);
        editTextR2 = findViewById(R.id.editTextR2);
        editTextR3 = findViewById(R.id.editTextR3);
        editTextR4 = findViewById(R.id.editTextR4);
        buttonR1 = findViewById(R.id.buttonR1);
        buttonR2 = findViewById(R.id.buttonR2);
    }
}
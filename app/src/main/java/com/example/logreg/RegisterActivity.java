package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextR1, editTextR2, editTextR3, editTextR4;
    private Button buttonR1, buttonR2;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        buttonR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] adatok = new String[] {
                        editTextR1.getText().toString().trim(),
                        editTextR2.getText().toString().trim(),
                        editTextR3.getText().toString().trim(),
                        editTextR4.getText().toString().trim()
                };
                if(
                    adatok[0].isEmpty() || adatok[1].isEmpty() ||
                    adatok[2].isEmpty() || adatok[3].isEmpty()
                ){
                    Toast.makeText(RegisterActivity.this, "Mindegyik mezőt töltse ki", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(adatok[0].contains("@") && adatok[0].split("@")[1].contains(".")){
                        boolean siker = db.regisztracio(adatok);
                        if(siker){
                            Toast.makeText(RegisterActivity.this, "Sikeres regisztráció", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Sikertelen regisztráció", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Hibás Email formátum", Toast.LENGTH_SHORT).show();
                    }
                }
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
        db = new DBHelper(RegisterActivity.this);
    }
}
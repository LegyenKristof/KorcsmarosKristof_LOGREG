package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button button1, button2;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] adatok = new String[] {
                    editText1.getText().toString().trim(),
                    editText2.getText().toString().trim()
                };
                if(adatok[0].isEmpty() || adatok[1].isEmpty()){
                    Toast.makeText(MainActivity.this, "Mindegyik mezőt töltse ki", Toast.LENGTH_SHORT).show();
                }
                else{
                    Cursor cursor = db.belepes(adatok);
                    if(cursor.getCount() == 0){
                        Toast.makeText(MainActivity.this, "Hibás adatok", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        cursor.moveToFirst();
                        Intent intent = new Intent(MainActivity.this, LoggedInActivity.class);
                        intent.putExtra("nev", cursor.getString(4).toString());
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init(){
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        db = new DBHelper(MainActivity.this);
    }
}
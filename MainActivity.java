package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        EditText userName = findViewById(R.id.userName);
        EditText contact = findViewById(R.id.contact);
        DBHandler dbHandler = new DBHandler(MainActivity.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                String number = contact.getText().toString();

                if (name.isEmpty() && number.isEmpty()){
                    Toast.makeText(MainActivity.this, "Incomplete information", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewContact(name, number);
                Toast.makeText(MainActivity.this, "Contact added successfully", Toast.LENGTH_SHORT).show();
                userName.setText("");
                contact.setText("");
            }
        });
    }
}

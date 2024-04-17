package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DictionaryActivity extends AppCompatActivity {

    private EditText wordEditText;
    private Button searchButton;
    private TextView meaningTextView, synonymsTextView, examplesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        wordEditText = findViewById(R.id.wordEditText);
        searchButton = findViewById(R.id.searchButton);
        meaningTextView = findViewById(R.id.meaningTextView);
        synonymsTextView = findViewById(R.id.synonymsTextView);
        examplesTextView = findViewById(R.id.examplesTextView);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement word lookup functionality here
            }
        });
    }
}

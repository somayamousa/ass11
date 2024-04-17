package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GrammarActivity extends AppCompatActivity {

    private TextView grammarTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        grammarTextView = findViewById(R.id.grammarTextView);

        // Display grammar rules
        displayGrammarRules();
    }

    private void displayGrammarRules() {
        // You can populate this method with grammar rules text
        String grammarRules = "Grammar Rule 1: Subject-Verb Agreement\n\n" +
                "In English, the subject and verb in a sentence must agree in number.\n" +
                "For example:\n" +
                "Correct: The dog barks.\n" +
                "Incorrect: The dog bark.\n\n" +
                "Grammar Rule 2: Proper Use of Tenses\n\n" +
                "Ensure consistency in verb tenses within a sentence or paragraph.\n" +
                "For example:\n" +
                "Correct: She is eating dinner when the phone rings.\n" +
                "Incorrect: She eats dinner when the phone rang.";

        // Set the grammar rules text to the TextView
        grammarTextView.setText(grammarRules);
    }
}

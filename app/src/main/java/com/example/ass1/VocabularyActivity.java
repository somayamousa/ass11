
package com.example.ass1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class VocabularyActivity extends AppCompatActivity {

    private TextView wordTextView, meaningTextView;
    private Spinner wordSpinner;
    private ImageView wordImageView;

    private String[] words = {"apple", "banana", "car", "house", "computer"};
    private String[] meanings = {"A fruit", "A fruit", "A vehicle", "A building", "An electronic device"};

    // Map to store word-image associations
    private Map<String, Integer> wordImageMap;

    // Vocabulary data for quiz
    public static final String[][] VOCABULARY_DATA = {
            {"apple", "A fruit"},
            {"banana", "A fruit"},
            {"car", "A vehicle"},
            {"house", "A building"},
            {"computer", "An electronic device"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        wordTextView = findViewById(R.id.wordTextView);
        meaningTextView = findViewById(R.id.meaningTextView);
        wordSpinner = findViewById(R.id.wordSpinner);
        wordImageView = findViewById(R.id.wordImageView);

        // Populate the Spinner with word options
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, words);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wordSpinner.setAdapter(adapter);

        // Initialize word-image map
        initializeWordImageMap();

        // Display initial word and image
        displayWord();

        wordSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                displayWord();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case where no item is selected
            }
        });
    }

    private void initializeWordImageMap() {
        wordImageMap = new HashMap<>();
        wordImageMap.put("apple", R.drawable.apple);
        wordImageMap.put("banana", R.drawable.banana);
        wordImageMap.put("car", R.drawable.car);
        wordImageMap.put("house", R.drawable.house);
        wordImageMap.put("computer", R.drawable.computer);
    }

    private void displayWord() {
        String selectedWord = wordSpinner.getSelectedItem().toString();
        int imageResource = wordImageMap.get(selectedWord);

        // Set the word and its meaning
        wordTextView.setText(selectedWord);
        meaningTextView.setText(getMeaning(selectedWord));

        // Set the image corresponding to the word
        wordImageView.setImageResource(imageResource);
    }

    private String getMeaning(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return meanings[i];
            }
        }
        return "";
    }
}
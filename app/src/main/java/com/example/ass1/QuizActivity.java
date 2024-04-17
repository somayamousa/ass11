package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private ListView optionsListView;
    private Button submitButton;

    private int currentQuestionIndex = 0;
    private int score = 0;

    // Constants for array indices
    private static final int QUESTION_INDEX = 0;
    private static final int OPTIONS_INDEX = 0;  // Vocabulary word index
    private static final int CORRECT_ANSWER_INDEX = 1;  // Vocabulary meaning index

    // Vocabulary data for quiz
    private String[][] vocabularyData = VocabularyActivity.VOCABULARY_DATA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.questionTextView);
        optionsListView = findViewById(R.id.optionsListView);
        submitButton = findViewById(R.id.submitButton);

        optionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                checkAnswer(position);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(-1);  // Assuming no selection means incorrect answer
            }
        });

        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < vocabularyData.length) {
            String[] currentQuestionData = vocabularyData[currentQuestionIndex];
            questionTextView.setText("What is the meaning of " + currentQuestionData[OPTIONS_INDEX] + "?");

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, meaningsExceptCurrent(currentQuestionData[OPTIONS_INDEX]));
            optionsListView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Quiz finished. Your score is: " + score, Toast.LENGTH_SHORT).show();
        }
    }

    private String[] meaningsExceptCurrent(String currentWord) {
        String[] meanings = new String[4];  // Assuming we have 4 options for each question
        int counter = 0;
        for (String[] wordData : vocabularyData) {
            if (!wordData[OPTIONS_INDEX].equals(currentWord) && counter < 4) {
                meanings[counter] = wordData[CORRECT_ANSWER_INDEX];
                counter++;
            }
        }
        return meanings;
    }

    private void checkAnswer(int selectedPosition) {
        if (selectedPosition == -1) {
            // No option selected
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] currentQuestionData = vocabularyData[currentQuestionIndex];
        if (selectedPosition == findMeaningIndex(currentQuestionData[CORRECT_ANSWER_INDEX])) {
            // Correct answer selected
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        // Move to the next question
        currentQuestionIndex++;
        if (currentQuestionIndex < vocabularyData.length) {
            displayQuestion();
        } else {
            Toast.makeText(this, "Quiz finished. Your score is: " + score, Toast.LENGTH_SHORT).show();
        }
    }

    private int findMeaningIndex(String meaning) {
        for (int i = 0; i < vocabularyData.length; i++) {
            if (vocabularyData[i][CORRECT_ANSWER_INDEX].equals(meaning)) {
                return i;
            }
        }
        return -1;
    }
}
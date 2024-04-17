package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText;
    private ImageView profileImageView;
    private Button updateProfileButton, changeProfilePicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        profileImageView = findViewById(R.id.profileImageView);
        updateProfileButton = findViewById(R.id.updateProfileButton);
        changeProfilePicButton = findViewById(R.id.changeProfilePicButton);

        updateProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });

        changeProfilePicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open image picker activity or dialog
                // For simplicity, let's assume it returns the selected image URI
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
    }

    private void updateProfile() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        // Perform validation here if needed

        // Save/update profile information in the database or SharedPreferences

        // Example: Display a toast message for demonstration
        String message = "Profile Updated: Name - " + name + ", Email - " + email;
        // Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Get the selected image URI and set it to the ImageView
            // For demonstration, let's assume the URI is obtained as "selectedImageUri"
            // Uri selectedImageUri = data.getData();
            // profileImageView.setImageURI(selectedImageUri);
        }
    }
}

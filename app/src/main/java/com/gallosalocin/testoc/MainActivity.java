package com.gallosalocin.testoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEmailInput;
    private EditText mPasswordInput;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailInput = findViewById(R.id.activity_main_email_input);
        mPasswordInput = findViewById(R.id.activity_main_password_input);
        mLoginButton = findViewById(R.id.activity_main_login_btn);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(mEmailInput.getText().toString(), mPasswordInput.getText().toString());
            }
        });
    }

    private void validate (String userEmail, String userPassword) {
        if ((userEmail.equals("admin@admin.com")) && (userPassword.equals("admin"))){
            Intent animalsList = new Intent(MainActivity.this, AnimalsList.class);
            startActivity(animalsList);
        }else{
            Toast.makeText(this, "Email ou Password incorrect!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.laboratorinis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Button register = findViewById(R.id.register);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final EditText email = findViewById(R.id.email);
        register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,
                        "Username: " + username.getText() + "\n" + "Password: " + password.getText() + "\n" + "Email: " + email.getText().toString(),
                        Toast.LENGTH_SHORT).show();

                username.setError(null);
                if (!Validation.isValidCredentials(username.getText().toString()))
                {
                 username.setError("Nepavyko prisijungti");
                 username.requestFocus();

                } else{
                    Intent goToMainActivity = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(goToMainActivity);
                }


                password.setError(null);
                if (!Validation.isValidPassword(password.getText().toString()))
                {
                    password.setError("Nepavyko prisijungti");
                    password.requestFocus();

                } else{
                    Intent goToMainActivity = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(goToMainActivity);
                }

                email.setError(null);
                if (!Validation.isValidEmail(email.getText().toString()))
                {
                    email.setError("Nepavyko prisijungti");
                    email.requestFocus();

                } else{
                    Intent goToMainActivity = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(goToMainActivity);
                }


            }

        });
    }
}

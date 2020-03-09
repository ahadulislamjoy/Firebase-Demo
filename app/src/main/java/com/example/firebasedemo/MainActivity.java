package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText Email, Password;
    private Button SignIn;
    private FirebaseAuth userAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userAuth = FirebaseAuth.getInstance();
    Email = findViewById(R.id.email);
    Password = findViewById(R.id.pass);
    SignIn = findViewById(R.id.button);


    SignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String email, password;
            email = Email.getText().toString();
            password = Password.getText().toString();
            userAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                    {
                        Email.setText("");
                        Password.setText("");
                        Toast.makeText(MainActivity.this, "Succesfull", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    });

    }
}

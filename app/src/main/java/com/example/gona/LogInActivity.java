package com.example.gona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    EditText userLogInEmail, userLogInPassword;
    TextInputLayout userEmailWrapper, userPasswordWrapper;
    Button btnSignIn;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth=FirebaseAuth.getInstance();

        userLogInEmail=findViewById(R.id.userLoginEmail);
        userLogInPassword=findViewById(R.id.userLoginPassword);

        userEmailWrapper=findViewById(R.id.userEmailWrapper);
        userPasswordWrapper=findViewById(R.id.userPasswordWrapper);

        btnSignIn=findViewById(R.id.btnUserLogin);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=userLogInEmail.getText().toString().trim();
                String password=userLogInPassword.getText().toString().trim();

                if(email.isEmpty()){
                    userEmailWrapper.setError("Enter Your Email");
                    userEmailWrapper.requestFocus();
                    return;
                }
                if (password.isEmpty()){
                    userPasswordWrapper.setError("Enter Your Password");
                    userPasswordWrapper.requestFocus();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(LogInActivity.this, GonaActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}

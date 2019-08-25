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
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText ufirstname, ulastname,  upassword, ucpassword, uemail;
    TextInputLayout userFirstNameWrapper, userLastNameWrapper, userEmailWrapper,
                    userPasswordWrapper, userConfpasswordWrapper;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();

        ufirstname=findViewById(R.id.userFirstName);
        ulastname=findViewById(R.id.userLastName);
        upassword=findViewById(R.id.userPassword);
        ucpassword=findViewById(R.id.userConfirmPassword);
        uemail=findViewById(R.id.userEmail);

        userFirstNameWrapper=findViewById(R.id.userFirstNameWrapper);
        userLastNameWrapper=findViewById(R.id.userLastNameWrapper);
        userPasswordWrapper=findViewById(R.id.userPasswordWrapper);
        userConfpasswordWrapper=findViewById(R.id.userConfirmPasswordWrapper);
        userEmailWrapper=findViewById(R.id.userEmailWrapper);

        btnRegister=findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mAuth.getCurrentUser() == null){
                    //Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
                    //startActivity(intent);
                }
                else {
                final String firstname = ufirstname.getText().toString().trim();
                final String lastname = ulastname.getText().toString().trim();
                String password = upassword.getText().toString().trim();
                String confpassword = ucpassword.getText().toString().trim();
                final String email = uemail.getText().toString().trim();

                if(firstname.isEmpty()){
                    userFirstNameWrapper.setError("Enter First Name");
                    userFirstNameWrapper.requestFocus();
                    return;
                }
                if(lastname.isEmpty()){
                    userLastNameWrapper.setError("Enter Last Name");
                    userLastNameWrapper.requestFocus();
                    return;
                }
                if(password.isEmpty()){
                    userPasswordWrapper.setError("Password must not be blank");
                    userPasswordWrapper.requestFocus();
                    return;
                }
                if(confpassword.isEmpty()){
                    userConfpasswordWrapper.setError("Enter confirm password");
                    userConfpasswordWrapper.requestFocus();
                    return;
                }
                if(email.isEmpty()){
                    userEmailWrapper.setError("Email must not be empty");
                    userEmailWrapper.requestFocus();
                    return;
                }
                if(!password.equals(confpassword)){
                    userConfpasswordWrapper.setError("Password did not match");
                    userConfpasswordWrapper.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        User user = new User(firstname,lastname,email);
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                }

                            }
                        });
                    }
                });

                }}
        });

    }
}

package com.example.gona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText ufirstname, ulastname, uothername, upassword, ucpassword, uemail;
    TextInputLayout userFirstNameWrapper, userLastNameWrapper, userOtherNameWrapper, userEmailWrapper,
            userPasswordWrapper, userConfpasswordWrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}

package com.epicodus.mylendinglibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toast.makeText(SignUpActivity.this, "Hey There Friend.", Toast.LENGTH_SHORT).show();
    }
}

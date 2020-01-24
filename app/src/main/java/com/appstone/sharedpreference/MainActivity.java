package com.appstone.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtUserEmail;
    private EditText mEtUserPassword;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtUserEmail = findViewById(R.id.et_user_email);
        mEtUserPassword = findViewById(R.id.et_user_password);

        preferences = getSharedPreferences("AppName", MODE_PRIVATE);
        editor = preferences.edit();

        boolean isLoggedIn = preferences.getBoolean("ISLOGIN", false);

        if(isLoggedIn){
            Intent loginIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }
    public void onLoginButtonClicked(View view) {
        String email = mEtUserEmail.getText().toString();
        String password = mEtUserPassword.getText().toString();
        editor.putString("EMAIL", email);
        editor.putString("PASSWORD", password);
        editor.putBoolean("ISLOGIN", true);
        editor.apply();
//        editor.commit();


        Intent loginIntent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(loginIntent);
        finish();
    }
}

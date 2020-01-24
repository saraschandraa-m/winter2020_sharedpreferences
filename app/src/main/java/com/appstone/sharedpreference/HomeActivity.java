package com.appstone.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onLogoutClicked(View view) {
        SharedPreferences pref = getSharedPreferences("AppName", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean("ISLOGIN", false);
        editor.apply();

        startActivity(new Intent(HomeActivity.this, MainActivity.class));
        finish();
    }
}

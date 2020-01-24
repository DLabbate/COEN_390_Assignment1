package com.example.coen390_assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button profileNameDisplayButton;
    Button goToGradesButton;
    SharedPreferencesHelper sharedpreferenceshelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferenceshelper = new SharedPreferencesHelper(MainActivity.this);
        setupUI();
        setupOnClickListeners();

        if (checkNameEmpty() == true)
        {
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        }
    }

    private void setupUI()
    {
        profileNameDisplayButton = findViewById(R.id.profileNameDisplayButton);
        goToGradesButton = findViewById(R.id.goToGradesButton);
    }

    private void setupOnClickListeners()
    {
        profileNameDisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        goToGradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,gradeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String profilename = sharedpreferenceshelper.getProfileName();
        profileNameDisplayButton.setText(profilename);
        if (checkNameEmpty() == true)
        {
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        }
    }

    private boolean checkNameEmpty() //check if the name is null
    {
        String profilename = sharedpreferenceshelper.getProfileName();
        if (profilename.isEmpty())
            return true;
        else
            return false;
    }


}


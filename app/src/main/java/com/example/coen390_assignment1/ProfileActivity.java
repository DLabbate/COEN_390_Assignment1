package com.example.coen390_assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    protected Profile userProfile;
    protected EditText nameEditText;
    protected EditText ageEditText;
    protected EditText studentID_EditText;
    protected Button saveProfileButton;
    protected boolean editMode; //Will be true if we are in edit mode

    SharedPreferencesHelper sharedpreferenceshelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedpreferenceshelper = new SharedPreferencesHelper(ProfileActivity.this);
        setupUI();
        updateUI();
        setupOnClickListeners();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editMode = sharedpreferenceshelper.getEditMode();
    }

    @Override
    protected void onStart() {
        super.onStart();
        userProfile = sharedpreferenceshelper.getProfile();
        updateUI();
        updateEditTexts(); //This makes sure the EditText will always display the profile name when onStart() is called
    }

    private void setupUI() //Links references to view id's
    {
        nameEditText = findViewById(R.id.nameEditText);
        saveProfileButton = findViewById(R.id.saveProfileButton);
        ageEditText = findViewById(R.id.ageEditText);
        studentID_EditText = findViewById(R.id.StudentID_EditText);
    }

    private void setupOnClickListeners()
    {
        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile profileCheck = new Profile(nameEditText.getText().toString(),ageEditText.getText().toString(),studentID_EditText.getText().toString());
                if (Profile.checkValidInput(profileCheck) == true) //We check if the profile meets the criteria
                {
                    sharedpreferenceshelper.saveProfile(profileCheck);
                    saveProfile(profileCheck);
                    makeToast("Saved");
                    sharedpreferenceshelper.saveEditMode(false);
                    editMode = false;
                    updateUI();
                    saveProfileButton.setVisibility(View.GONE); //if we want to get rid of button
                }

                else
                {
                    makeToast("Invalid Input!");
                }
            }
        });
    }

    private void updateEditTexts()
    {
        nameEditText.setText(userProfile.getName());
        ageEditText.setText(userProfile.getAge());
        studentID_EditText.setText(userProfile.getId());
    }

    private void makeToast(String message)
    {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case(R.id.action_settings):
                sharedpreferenceshelper.saveEditMode(true);
                enableEditTexts();
                saveProfileButton.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveInfo()
    {
        sharedpreferenceshelper.saveProfileName(nameEditText.getText().toString());
        sharedpreferenceshelper.saveProfileAge(ageEditText.getText().toString());
        sharedpreferenceshelper.saveProfileStudentID(studentID_EditText.getText().toString());
    }

    private void saveProfile(Profile profile)
    {
        sharedpreferenceshelper.saveProfileName(profile.getName());
        sharedpreferenceshelper.saveProfileAge(profile.getAge());
        sharedpreferenceshelper.saveProfileStudentID(profile.getId());
    }

    private void enableEditTexts() //This function enables all the EditText in the activity
    {
        nameEditText.setEnabled(true);
        ageEditText.setEnabled(true);
        studentID_EditText.setEnabled(true);
    }

    private void disableEditTexts() //This function enables all the EditText in the activity
    {
        nameEditText.setEnabled(false);
        ageEditText.setEnabled(false);
        studentID_EditText.setEnabled(false);
    }

    private void updateUI()
    {
        if (editMode == true)
        {
            enableEditTexts();
            saveProfileButton.setVisibility(View.VISIBLE);
        }
        else
        {
            disableEditTexts();
            saveProfileButton.setVisibility(View.GONE);
        }
    }



}

package com.example.coen390_assignment1;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    private SharedPreferences sharedPreferences;
    private Context context;
    public SharedPreferencesHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference",
                Context.MODE_PRIVATE );
        this.context = context;
    }
    public void saveProfileName(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.profile_name_key),name );
        editor.commit();
    }

    public void saveProfileAge(String age)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.profile_age_key),age);
        editor.commit();
    }

    public void saveProfileStudentID(String id)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.student_id_key),id);
        editor.commit();
    }


    public String getProfileName()
    {
        return sharedPreferences.getString(context.getString(R.string.profile_name_key), "");
    }

    public String getProfileAge()
    {
        return sharedPreferences.getString(context.getString(R.string.profile_age_key),"0");
    }

    public String getProfileStudentID()
    {
        return sharedPreferences.getString(context.getString(R.string.student_id_key), "0");
    }

    public void saveEditMode(boolean editmode)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("editMode",editmode);
        editor.commit();
    }

    public boolean getEditMode()
    {
        return sharedPreferences.getBoolean("editMode",true);
    }

    public void saveProfile(Profile profile) //Takes a profile class as a parameter and saves the name, age and ID in Shared Preferences
    {
        saveProfileName(profile.getName());
        saveProfileAge(profile.getAge());
        saveProfileStudentID(profile.getId());
    }

    public Profile getProfile()
    {
        return new Profile(getProfileName(),getProfileAge(),getProfileStudentID()); //Takes a reference to the Profile
    }
}
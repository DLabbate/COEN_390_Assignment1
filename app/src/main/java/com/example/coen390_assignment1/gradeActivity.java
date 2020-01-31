package com.example.coen390_assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class gradeActivity extends AppCompatActivity {

    public static boolean displayLetterGrades = false;
    ArrayList<Course> testdata;
    RecyclerView graderecyclerView; //Recycler View
    RecyclerView.LayoutManager gradeLayoutManager; //Layout Manager
    RecyclerView.Adapter gradeAdapter; //Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        graderecyclerView = findViewById(R.id.gradeRecyclerView);
        gradeLayoutManager = new LinearLayoutManager(this);
        //Linear Layout. Can use 2D Grid instead if we want

        testdata = new ArrayList<Course>();
        //testdata.add("TEST1");
        //testdata.add("TEST2");
        //testdata.add("TEST3");

        gradeAdapter = new gradeAdapter(testdata);
        graderecyclerView.setLayoutManager(gradeLayoutManager);
        graderecyclerView.setAdapter(gradeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grade_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Random random = new Random();
        int numCourses = random.nextInt(5) + 1; //Range 1-5
        for (int i = 0; i < numCourses; i++)
        {
            testdata.add(Course.generateRandomCourse());
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case(R.id.showGrades):
                gradeActivity.displayLetterGrades = !(gradeActivity.displayLetterGrades) ;
                Log.d("MyActivity","********************Converted Grades***********************");
                Log.d("MyActivity",Boolean.toString(displayLetterGrades));
                gradeAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

package com.example.coen390_assignment1;
import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Tawfiq on 1/13/2017.
 */
public class Course {
    private static int courseID = 0; //static ID increments with every new Course created
    private String courseTitle; //cou
    private ArrayList<Assignment> assignments;
    private Course(String title, ArrayList<Assignment> assns)
    {
        courseTitle = title;
        assignments = assns;
        courseID++;
    }
    //returns a Course instant with random assignment values
    static public Course generateRandomCourse()
    {
        Random rnd = new Random();
        int assignmentNo = rnd.nextInt(5);
        ArrayList<Assignment> tempAssns = new ArrayList<Assignment>();
        for(int i=0; i < assignmentNo; i++)
            tempAssns.add(Assignment.generateRandomAssignment());
        return new Course("Course " + courseID, tempAssns);
    }
    //****get methods*****//
    public String getCourseTitle() {return courseTitle;}
    public ArrayList<Assignment> getAssignments() {return assignments;}

    public String getAssignmentsString()
    {
        StringBuilder assignmentStringBuilder = new StringBuilder();
        if (assignments.size() == 0)
        {
            return "Assignment: NaN\n";
        }

        else
        {
            for (int i = 0; i < assignments.size(); i++)
            {
                assignmentStringBuilder.append(assignments.get(i).getAssignmentTitle()+": ");
                assignmentStringBuilder.append(assignments.get(i).getAssignmentGrade()+"\n");
                assignmentStringBuilder.append("\n");
            }
            String average = Double.toString(getAssignmentsAverage());
            assignmentStringBuilder.append("\nAssignments Average: " + average + "\n");
            return assignmentStringBuilder.toString();
        }
    }

    public double getAssignmentsAverage()
    {
        int n = assignments.size();
        double sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += assignments.get(i).getAssignmentGrade();
        }
        if (n != 0)
        {
            return sum/n;
        }
        else
        {
            return 0;
        }
    }
}
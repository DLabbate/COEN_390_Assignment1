package com.example.coen390_assignment1;
import java.util.Random;

/**
 * Created by Tawfiq on 1/13/2017.
 */
public class Assignment {
    private static int assID = 0;
    //static ID increments with every new assignment created
    private String assignmentTitle; //title of assignment
    private int assignmentGrade; //grade of assignment
    //private constructor. Increments ID.
    private Assignment(String title, int grade)
    {
        assignmentTitle = title;
        assignmentGrade = grade;
        assID++;
    }
    //returns an Assignment instance with random values
    static public Assignment generateRandomAssignment()
    {
        Random rnd = new Random();
        String tempTitle = "Assignment " + assID;
        int tempGrade = rnd.nextInt(100) + 1;
        return new Assignment(tempTitle, tempGrade);
    }
    //****get methods*****//
    public String getAssignmentTitle() {return assignmentTitle; }
    public int getAssignmentGrade() {return assignmentGrade;}

    public String getAssignmentLetterGrade()
    {
        if (assignmentGrade>=90)
        {
            return "A+";
        }
        else if ((85 <= assignmentGrade) && (assignmentGrade <= 89))
        {
            return "A";
        }

        else if ((80 <= assignmentGrade) && (assignmentGrade <= 84))
        {
            return "A-";
        }

        else if ((77 <= assignmentGrade) && (assignmentGrade <= 79))
        {
            return "B+";
        }

        else if ((73 <= assignmentGrade) && (assignmentGrade <= 76))
        {
            return "B";
        }

        else if ((70 <= assignmentGrade) && (assignmentGrade <= 72))
        {
            return "B-";
        }

        else if ((67 <= assignmentGrade) && (assignmentGrade <= 69))
        {
            return "C+";
        }

        else if ((63 <= assignmentGrade) && (assignmentGrade <= 66))
        {
            return "C";
        }

        else if ((60 <= assignmentGrade) && (assignmentGrade <= 62))
        {
            return "C-";
        }

        else if ((57 <= assignmentGrade) && (assignmentGrade <= 59))
        {
            return "D+";
        }

        else if ((53 <= assignmentGrade) && (assignmentGrade <= 56))
        {
            return "D";
        }

        else if ((50 <= assignmentGrade) && (assignmentGrade <= 52))
        {
            return "D-";
        }

        else if ((0 <= assignmentGrade) && (assignmentGrade <= 49))
        {
            return "F";
        }

        else
        {
            return "NaN";
        }
    }

    public static String convertToLetterGrade(int assignmentGrade)
    {
        if (assignmentGrade>=90)
        {
            return "A+";
        }
        else if ((85 <= assignmentGrade) && (assignmentGrade <= 89))
        {
            return "A";
        }

        else if ((80 <= assignmentGrade) && (assignmentGrade <= 84))
        {
            return "A-";
        }

        else if ((77 <= assignmentGrade) && (assignmentGrade <= 79))
        {
            return "B+";
        }

        else if ((73 <= assignmentGrade) && (assignmentGrade <= 76))
        {
            return "B";
        }

        else if ((70 <= assignmentGrade) && (assignmentGrade <= 72))
        {
            return "B-";
        }

        else if ((67 <= assignmentGrade) && (assignmentGrade <= 69))
        {
            return "C+";
        }

        else if ((63 <= assignmentGrade) && (assignmentGrade <= 66))
        {
            return "C";
        }

        else if ((60 <= assignmentGrade) && (assignmentGrade <= 62))
        {
            return "C-";
        }

        else if ((57 <= assignmentGrade) && (assignmentGrade <= 59))
        {
            return "D+";
        }

        else if ((53 <= assignmentGrade) && (assignmentGrade <= 56))
        {
            return "D";
        }

        else if ((50 <= assignmentGrade) && (assignmentGrade <= 52))
        {
            return "D-";
        }

        else if ((0 <= assignmentGrade) && (assignmentGrade <= 49))
        {
            return "F";
        }

        else
        {
            return "NaN";
        }
    }

    //public String getAssignmentLetterGrade()
    //{
    //
    //}

}
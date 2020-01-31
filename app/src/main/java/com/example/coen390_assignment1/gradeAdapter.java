package com.example.coen390_assignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class gradeAdapter extends RecyclerView.Adapter<gradeAdapter.ViewHolder> {

    ArrayList<Course> gradeList;
    gradeAdapter(ArrayList<Course> gradeList)
    {
        this.gradeList = gradeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = gradeList.get(position);
        ArrayList<Assignment> assignments = course.getAssignments();
        holder.courseText.setText(course.getCourseTitle());
        StringBuilder assignmentText = new StringBuilder();
        for (int i = 0; i < assignments.size(); i++)
        {
            assignmentText.append(assignments.get(i).getAssignmentTitle()+": ");
            assignmentText.append(assignments.get(i).getAssignmentGrade()+"\n");
            assignmentText.append("\n");
        }
        holder.assignmentText.setText(assignmentText.toString());
    }

    @Override
    public int getItemCount() {
        return gradeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView courseText;
        public TextView assignmentText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseText = itemView.findViewById(R.id.course);
            assignmentText = itemView.findViewById(R.id.assignment);
        }
    }
}

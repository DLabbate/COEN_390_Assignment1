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

    ArrayList<String> gradeList;
    gradeAdapter(ArrayList<String> gradeList)
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
        holder.courseText.setText(gradeList.get(position));
        holder.assignmentText.setText(gradeList.get(position));
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

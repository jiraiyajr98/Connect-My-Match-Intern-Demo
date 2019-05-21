package com.cssllc.connectmywatch.Adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cssllc.connectmywatch.POJO.Subjects;
import com.cssllc.connectmywatch.R;

import java.util.List;


public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.SubjectHolder> {

    private List<Subjects> listOfSubjects;
    private Context context;

    public SubjectsAdapter(List<Subjects> listOfSubjects, Context context) {
        this.listOfSubjects = listOfSubjects;
        this.context = context;
    }

    @NonNull
    @Override
    public SubjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.subject_items,viewGroup,false);

        return new SubjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectHolder subjectHolder, int i) {

        Subjects subject = listOfSubjects.get(i);

        subjectHolder.mainSubject.setText(subject.getSubjectName());
        subjectHolder.progress.setText(subject.getSubjectProgress()+"%");
        subjectHolder.progressBar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#00bcd4")));
        subjectHolder.progressBar.setProgress(Integer.parseInt(subject.getSubjectProgress()));

    }

    @Override
    public int getItemCount() {
        return listOfSubjects.size();
    }

    class SubjectHolder extends RecyclerView.ViewHolder{

        TextView mainSubject;
        TextView progress;
        ProgressBar progressBar;

        SubjectHolder(@NonNull View itemView) {
            super(itemView);

            mainSubject = (TextView)itemView.findViewById(R.id.mainsubject);
            progress =(TextView)itemView.findViewById(R.id.progresstv);
            progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar);
        }
    }
}

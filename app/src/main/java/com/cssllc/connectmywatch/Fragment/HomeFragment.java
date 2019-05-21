package com.cssllc.connectmywatch.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cssllc.connectmywatch.Adapter.SubjectsAdapter;
import com.cssllc.connectmywatch.MainActivity;
import com.cssllc.connectmywatch.POJO.Subjects;
import com.cssllc.connectmywatch.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private List<Subjects> subjectsList = new ArrayList<>();
    private View viewLayout;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewLayout= inflater.inflate(R.layout.fragment_home, container, false);
        return viewLayout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView)viewLayout.findViewById(R.id.recyclerview);
        SubjectsAdapter adapter = new SubjectsAdapter(subjectsList, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        subjectsList.add(new Subjects("Mental Ability","40"));
        subjectsList.add(new Subjects("Physics","20"));
        subjectsList.add(new Subjects("Chemistry","70"));
        subjectsList.add(new Subjects("Mathematics","40"));
        subjectsList.add(new Subjects("Biology","20"));
        subjectsList.add(new Subjects("Computer Science","90"));

        adapter.notifyDataSetChanged();
    }
}

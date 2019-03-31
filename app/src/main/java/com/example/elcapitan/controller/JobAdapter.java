package com.example.elcapitan.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.elcapitan.OnFragmentInteractionListener;
import com.example.elcapitan.R;
import com.example.elcapitan.model.Job;
import com.example.elcapitan.view.JobViewHolder;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobViewHolder> {
    private List<Job> jobList;
    private OnFragmentInteractionListener listener;

    public JobAdapter(List<Job> jobList, OnFragmentInteractionListener listener) {
        this.jobList = jobList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new JobViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.job_item_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder jobViewHolder, int i) {
        jobViewHolder.onBind(jobList.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }
}

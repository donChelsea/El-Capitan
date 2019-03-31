package com.example.elcapitan.model;

import java.util.List;

public class JobList {
    List<Job> jobs;

    public JobList(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}

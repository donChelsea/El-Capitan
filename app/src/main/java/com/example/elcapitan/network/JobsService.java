package com.example.elcapitan.network;

import com.example.elcapitan.model.Job;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JobsService {
    @GET("positions.json")
    Call<List<Job>> getJobs(@Query("description") String description,
                                  @Query("full_time") boolean full_time,
                                  @Query("location") String location);
}

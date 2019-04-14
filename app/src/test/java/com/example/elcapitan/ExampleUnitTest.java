package com.example.elcapitan;

import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.InstrumentationInfo;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.CheckBox;

import com.example.elcapitan.model.Job;
import com.example.elcapitan.view.JobViewHolder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    JobViewHolder jobViewHolder;

    @Before
    public void setUp() {
        jobViewHolder = new JobViewHolder(new View(new Instrumentation().getContext()));
    }

    @Test
    public void test_correct_created_at_date() {
        Job job = new Job();
        job.setCreated_at("Wed Apr 10 23:41:43 UTC 2019");

        String result = jobViewHolder.correctCreatedAtDate(job);
        String expected = "Apr 10 2019";

        Assert.assertEquals(expected, result);
    }


    @After
    public void tearDown() {
        jobViewHolder = null;
    }

}
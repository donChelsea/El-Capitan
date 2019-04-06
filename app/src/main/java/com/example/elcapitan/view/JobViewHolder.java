package com.example.elcapitan.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elcapitan.DetailActivity;
import com.example.elcapitan.OnFragmentInteractionListener;
import com.example.elcapitan.R;
import com.example.elcapitan.model.Job;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;
import static com.example.elcapitan.DetailActivity.COMPANY;
import static com.example.elcapitan.DetailActivity.COMPANY_LOGO;
import static com.example.elcapitan.DetailActivity.COMPANY_URL;
import static com.example.elcapitan.DetailActivity.CREATED_AT;
import static com.example.elcapitan.DetailActivity.DESCRIPTION;
import static com.example.elcapitan.DetailActivity.LOCATION;
import static com.example.elcapitan.DetailActivity.TITLE;
import static com.example.elcapitan.DetailActivity.TYPE;
import static com.example.elcapitan.DetailActivity.URL;

public class JobViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.job_title_textview) TextView titleTv;
    @BindView(R.id.company_textview) TextView companyTv;
    @BindView(R.id.location_textview) TextView locationTv;
    @BindView(R.id.created_at_textview) TextView createdAtTv;
    @BindView(R.id.type_textview) TextView typeTv;
    @BindView(R.id.company_logo_imageview) ImageView companyLogoIv;
    public JobViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void onBind(Job job, OnFragmentInteractionListener listener) {
        ButterKnife.bind(this, itemView);

        titleTv.setText(job.getTitle());
        companyTv.setText(job.getCompany());
        locationTv.setText(job.getLocation());
        createdAtTv.setText(String.format("Created: %s", correctCreatedAtDate(job)));
        typeTv.setText(job.getType());
        setCompanyLogoIv(job);
        titleTv.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtras(createArgs(job));
            v.getContext().startActivity(intent);
        });
    }

    private String correctCreatedAtDate(Job job) {
        String[] createdAtArray = job.getCreated_at().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 3; i++) {
            sb.append(createdAtArray[i]).append(" ");
        }
        sb.append(createdAtArray[5]);
        return sb.toString();
    }

    private void setCompanyLogoIv(Job job) {
        if (job.getCompany_logo() != null) {
            Picasso.get().load(job.getCompany_logo()).into(companyLogoIv);
        } else {
            companyLogoIv.setImageResource(R.drawable.el_capitan_logo);
        }
    }

    private Bundle createArgs(Job job) {
        Bundle args = new Bundle();
        args.putString(TITLE, job.getTitle());
        args.putString(COMPANY, job.getCompany());
        args.putString(COMPANY_URL, job.getCompany_url());
        args.putString(COMPANY_LOGO, job.getCompany_logo());
        args.putString(URL, job.getUrl());
        args.putString(TYPE, job.getType());
        args.putString(CREATED_AT, job.getCreated_at());
        args.putString(LOCATION, job.getLocation());
        args.putString(DESCRIPTION, job.getDescription());
        return args;
    }
}

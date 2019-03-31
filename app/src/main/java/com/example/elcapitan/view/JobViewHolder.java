package com.example.elcapitan.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elcapitan.DetailActivity;
import com.example.elcapitan.OnFragmentInteractionListener;
import com.example.elcapitan.R;
import com.example.elcapitan.model.Job;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        titleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentInteraction(job);
            }
        });
    }

    private String correctCreatedAtDate(Job job) {
        String[] createdAtArray = job.getCreated_at().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 3; i++) {
            sb.append(createdAtArray[i] + " ");
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
}

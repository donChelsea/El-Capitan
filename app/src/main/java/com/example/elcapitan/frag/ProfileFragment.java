package com.example.elcapitan.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elcapitan.R;
import com.example.elcapitan.model.Job;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.elcapitan.DetailActivity.COMPANY;
import static com.example.elcapitan.DetailActivity.COMPANY_LOGO;
import static com.example.elcapitan.DetailActivity.COMPANY_URL;
import static com.example.elcapitan.DetailActivity.CREATED_AT;
import static com.example.elcapitan.DetailActivity.DESCRIPTION;
import static com.example.elcapitan.DetailActivity.LOCATION;
import static com.example.elcapitan.DetailActivity.TITLE;
import static com.example.elcapitan.DetailActivity.TYPE;
import static com.example.elcapitan.DetailActivity.URL;


public class ProfileFragment extends Fragment {
    String title;
    String company;
    String companyUrl;
    String type;
    String url;
    String createdAt;
    String location;
    String description;
    String companyLogo;
    private com.example.elcapitan.OnFragmentInteractionListener listener;
    @BindView(R.id.profile_title_textview) TextView titleTv;
    @BindView(R.id.profile_company_textview) TextView companyTv;
    @BindView(R.id.profile_type_textview) TextView typeTv;
    @BindView(R.id.profile_description_textview) TextView descriptionTv;
    @BindView(R.id.profile_created_textview) TextView createdTv;
    @BindView(R.id.profile_location_textview) TextView locationTv;
    @BindView(R.id.profile_company_logo) ImageView logoIv;
    @BindView(R.id.see_company_site) Button seeMoreButton;

    public ProfileFragment() {
    }

    public ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof com.example.elcapitan.OnFragmentInteractionListener) {
            listener = (com.example.elcapitan.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement com.example.elcapitan.OnFragmentInteractionListener");
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(TITLE);
            company = getArguments().getString(COMPANY);
            companyUrl = getArguments().getString(COMPANY_URL);
            companyLogo = getArguments().getString(COMPANY_LOGO);
            type = getArguments().getString(TYPE);
            url = getArguments().getString(URL);
            createdAt = getArguments().getString(CREATED_AT);
            location = getArguments().getString(LOCATION);
            description = getArguments().getString(DESCRIPTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

        titleTv.setText(title);
        companyTv.setText(company);
        typeTv.setText(type);
        descriptionTv.setText(Html.fromHtml(description));
        createdTv.setText(createdAt);
        locationTv.setText(location);
        Picasso.get().load(companyLogo).into(logoIv);
        seeMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // launch intent to view job application in chrome
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}

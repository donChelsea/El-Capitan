package com.example.elcapitan.frag;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.elcapitan.DetailActivity;
import com.example.elcapitan.OnFragmentInteractionListener;
import com.example.elcapitan.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";
    public static final String USER_LANGUAGE = "user language";
    public static final String USER_LOCATION = "user location";
    public static final String SHOW_PART_TIME = "show part time";
    @BindView(R.id.location_edittext)
    EditText locationEdittext;
    @BindView(R.id.language_edittext)
    EditText languageEdittext;
    @BindView(R.id.parttime_checkbox)
    CheckBox partTimeCheckbox;
    public static boolean showPartTime = false;
    OnFragmentInteractionListener fragmentInteractionListener;
    public static String userLanguage = "";
    public static String userLocation = "";

    public MainFragment() {
    }

    public MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            fragmentInteractionListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.clearDisappearingChildren();
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        Button jobSearchButton = view.findViewById(R.id.job_search_button);
        jobSearchButton.setOnClickListener(v -> {
            userLanguage = languageEdittext.getText().toString().toLowerCase().trim();
            userLocation = locationEdittext.getText().toString().toLowerCase().trim();
            partTimeCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (partTimeCheckbox.isChecked()) {
                    showPartTime = true;
                }
            });
            fragmentInteractionListener.onResultsFragmentInteraction(userLanguage, userLocation, showPartTime);
        });
    }
}


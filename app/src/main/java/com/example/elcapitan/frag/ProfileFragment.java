package com.example.elcapitan.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elcapitan.R;
import com.example.elcapitan.model.Job;


public class ProfileFragment extends Fragment {
    private static final String TITLE = "title";
    private static final String COMPANY = "company";

    private String title;
    private String company;

    private com.example.elcapitan.OnFragmentInteractionListener listener;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance(Job job) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(TITLE);
            company = getArguments().getString(COMPANY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
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
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}

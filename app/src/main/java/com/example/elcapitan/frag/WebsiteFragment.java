package com.example.elcapitan.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elcapitan.R;

import static com.example.elcapitan.DetailActivity.COMPANY_URL;

// will be the web viewer for the application

public class WebsiteFragment extends Fragment {
    String websiteUrl;

    private com.example.elcapitan.OnFragmentInteractionListener mListener;

    public WebsiteFragment() {
    }

    public static WebsiteFragment newInstance() {
        return new WebsiteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            websiteUrl = getArguments().getString(COMPANY_URL);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_website, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof com.example.elcapitan.OnFragmentInteractionListener) {
            mListener = (com.example.elcapitan.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement com.example.elcapitan.OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}

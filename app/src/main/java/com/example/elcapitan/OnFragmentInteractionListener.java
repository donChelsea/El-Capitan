package com.example.elcapitan;

import android.os.Bundle;

import com.example.elcapitan.frag.ProfileFragment;
import com.example.elcapitan.frag.WebsiteFragment;

public interface OnFragmentInteractionListener {
    void onResultsFragmentInteraction(String language, String location, boolean showPartTime);
    WebsiteFragment onWebsiteFragmentInteraction(String url);
    ProfileFragment onProfileFragmentInteraction(Bundle args);
}

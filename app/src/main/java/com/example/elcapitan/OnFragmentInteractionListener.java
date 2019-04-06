package com.example.elcapitan;

import com.example.elcapitan.frag.WebsiteFragment;

public interface OnFragmentInteractionListener {
    void onResultsFragmentInteraction(String language, String location, boolean showPartTime);
    WebsiteFragment onCompanyFragmentInteraction(String url);

}

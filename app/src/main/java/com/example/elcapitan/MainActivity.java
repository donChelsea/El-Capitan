package com.example.elcapitan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.elcapitan.frag.MainFragment;
import com.example.elcapitan.frag.ResultsFragment;
import com.example.elcapitan.frag.WebsiteFragment;

import static com.example.elcapitan.frag.MainFragment.SHOW_PART_TIME;
import static com.example.elcapitan.frag.MainFragment.USER_LANGUAGE;
import static com.example.elcapitan.frag.MainFragment.USER_LOCATION;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment().newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, mainFragment)
                .addToBackStack("first")
                .commit();
    }

    @Override
    public void onResultsFragmentInteraction(String language, String location, boolean showPartTime) {
        ResultsFragment resultsFragment = new ResultsFragment().newInstance();
        Bundle args = new Bundle();
        args.putString(USER_LANGUAGE, language);
        args.putString(USER_LOCATION, location);
        args.putBoolean(SHOW_PART_TIME, showPartTime);
        resultsFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, resultsFragment)
                .addToBackStack("results")
                .commit();
    }

    @Override
    public WebsiteFragment onCompanyFragmentInteraction(String url) {

    }
}

package com.example.elcapitan;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.elcapitan.frag.ProfileFragment;
import com.example.elcapitan.frag.DetailFragment3;
import com.example.elcapitan.frag.MainFragment;
import com.example.elcapitan.frag.ResultsFragment;
import com.example.elcapitan.model.Job;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.elcapitan.frag.MainFragment.SHOW_PART_TIME;
import static com.example.elcapitan.frag.MainFragment.USER_LANGUAGE;
import static com.example.elcapitan.frag.MainFragment.USER_LOCATION;

public class DetailActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    @BindView(R.id.container) ViewPager viewPager;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.fab) FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String userLocation = intent.getStringExtra(USER_LOCATION);
        String userLanguage = intent.getStringExtra(USER_LANGUAGE);
        boolean showPartTime = intent.getBooleanExtra(SHOW_PART_TIME, MainFragment.showPartTime);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onFragmentInteraction(Job job) {
        ProfileFragment profileFragment = new ProfileFragment().newInstance();

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ResultsFragment resultsFragment = new ResultsFragment().newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, resultsFragment)
                            .addToBackStack("results")
                            .commit();
                    return resultsFragment;
                case 1:
                    new ProfileFragment();
                    return ProfileFragment.newInstance();
                case 2:
                    new DetailFragment3();
                    return DetailFragment3.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}

package com.example.elcapitan;


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

import com.example.elcapitan.frag.WebsiteFragment;
import com.example.elcapitan.frag.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    public static final String TITLE = "title";
    public static final String COMPANY = "company";
    public static final String COMPANY_URL = "company url";
    public static final String TYPE = "type";
    public static final String URL = "url";
    public static final String CREATED_AT = "created at";
    public static final String LOCATION = "location";
    public static final String DESCRIPTION = "description";
    public static final String COMPANY_LOGO = "company logo";
    @BindView(R.id.container)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    Bundle job;
    public static String websiteUrl;


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

        job = getIntent().getExtras();
        assert job != null;
        websiteUrl = job.getString(COMPANY_URL);
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
    public void onResultsFragmentInteraction(String language, String location, boolean showPartTime) {
        // NON OP
    }

    @Override
    public WebsiteFragment onCompanyFragmentInteraction(String url) {
        new WebsiteFragment();
        WebsiteFragment websiteFragment = new WebsiteFragment().newInstance();
        Bundle args = new Bundle();
        args.putString(COMPANY_URL, url);
        websiteFragment.setArguments(args);
        return new WebsiteFragment();
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ProfileFragment profileFragment = new ProfileFragment().newInstance();
                    profileFragment.setArguments(job);
                    return profileFragment;
                case 1:
                    onCompanyFragmentInteraction(websiteUrl);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}

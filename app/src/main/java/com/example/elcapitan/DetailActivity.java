package com.example.elcapitan;


import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.elcapitan.frag.WebsiteFragment;
import com.example.elcapitan.frag.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    public static final String TITLE = "title";
    public static final String COMPANY = "company";
    public static final String WEBSITE_URL = "company url";
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
    View view;
    private String jobPosting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(jobPosting));
            startActivity(intent);
        });

        job = getIntent().getExtras();
        assert job != null;
        jobPosting = job.getString(URL);
        websiteUrl = job.getString(WEBSITE_URL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github:
                Intent intentGitHub = new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://github.com/donChelsea"));
                startActivity(intentGitHub);
                return true;
            case R.id.linkedin:
                Intent intentLinkedIn = new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://www.linkedin.com/in/chelsea-katsidzira-184789108/"));
                startActivity(intentLinkedIn);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResultsFragmentInteraction(String language, String location, boolean showPartTime) {
        // NON OP
    }

    @Override
    public WebsiteFragment onWebsiteFragmentInteraction(String url) {
        return null;
    }

    @Override
    public ProfileFragment onProfileFragmentInteraction(Bundle args) {
        return null;
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
                    WebsiteFragment companyWebsite = WebsiteFragment.newInstance();
                    Bundle args1 = new Bundle();
                    args1.putString(WEBSITE_URL, websiteUrl);
                    companyWebsite.setArguments(args1);
                    return companyWebsite;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


}

package com.example.elcapitan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.elcapitan.frag.MainFragment;

public class MainActivity extends AppCompatActivity {


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

}

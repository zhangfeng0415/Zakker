package com.zte.zakker.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zte.zakker.home.fragment.MainHomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, MainHomeFragment.newInstance()).commit();
    }
}

package com.zte.zakker.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.zte.zakker.news.fragment.MainNewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,MainNewsFragment.newInstance()).commit();
    }
}

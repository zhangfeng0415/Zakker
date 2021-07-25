package com.zte.zakker.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zte.zakker.test.inject.component.DaggerMainActivityComponent;
import com.zte.zakker.test.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    public MainPresenter mMainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainActivityComponent.create().inject(this);
        mMainPresenter.prinitHelloWorld();
    }
}

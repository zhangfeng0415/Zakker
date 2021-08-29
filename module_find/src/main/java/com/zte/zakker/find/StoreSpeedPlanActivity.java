package com.zte.zakker.find;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;


public class StoreSpeedPlanActivity extends Activity {
    private ImageView mNextButtonView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_speed_plan);
        mNextButtonView = findViewById(R.id.next_button);
        mNextButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent mFragmentStoreDetail = new Intent(getApplicationContext(),StoreDeviceChooseDetailActivity.class);
//                startActivity(mFragmentStoreDetail);
            }
        });
    }

}

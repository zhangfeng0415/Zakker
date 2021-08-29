package com.zte.zakker.find;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class ShoppingCartActivity extends Activity {
    private ImageView mPayButtonView;
    private ImageView mBackButtonView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);
        mPayButtonView = findViewById(R.id.pay_button);
        mPayButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent mFragmentStore = new Intent(getApplicationContext(), ShoppingCartActivity.class);
//                startActivity(mFragmentStore);
                Toast.makeText(view.getContext(), R.string.store_creation_warning, Toast.LENGTH_SHORT).show();
            }
        });

        mBackButtonView = findViewById(R.id.arrow_back);
        mBackButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                Intent mBackIntent = new Intent(getApplicationContext(), StoreDeviceChooseDetailActivity.class);
//                startActivity(mBackIntent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

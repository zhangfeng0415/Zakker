package com.zte.zakker.find;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

public class StoreDeviceChooseDetailActivity extends Activity {
    private ImageView mAddShoppingCartButtonView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_device_choose_detail);
        mAddShoppingCartButtonView = findViewById(R.id.add_to_shopping_cart);
        mAddShoppingCartButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mFragmentStore = new Intent(getApplicationContext(), ShoppingCartActivity.class);
                startActivity(mFragmentStore);
            }
        });
    }
}

package com.zte.zakker;

import com.zte.zakker.api.RetrofitManager;
import com.zte.zakker.common.BaseApplication;

/**
 * Description: <MyApplication><br>
 * Author:      mxdl<br>
 * Date:        2018/12/27<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //NewsDBManager.getInstance(this).initNewsDB();
        RetrofitManager.init(this);
    }
}

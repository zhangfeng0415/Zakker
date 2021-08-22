package com.zte.zakker.home.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zte.zakker.common.provider.IHomeProvider;
import com.zte.zakker.home.fragment.MainHomeFragment;

/**
 * Description: <HomeProvider><br>
 * Author:      mxdl<br>
 * Date:        2019/5/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
@Route(path = "/home/main",name = "智能家庭")
public class HomeProvider implements IHomeProvider {
    @Override
    public Fragment getMainHomeFragment() {
        return MainHomeFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}

package com.zte.zakker.me.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zte.zakker.common.provider.IMeProvider;
import com.zte.zakker.me.fragment.MainMeFragment;

/**
 * Description: <MeProvider><br>
 * Author:      mxdl<br>
 * Date:        2019/5/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
@Route(path = "/me/main",name = "我的服务")
public class MeProvider implements IMeProvider {
    @Override
    public Fragment getMainMeFragment() {
        return MainMeFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}

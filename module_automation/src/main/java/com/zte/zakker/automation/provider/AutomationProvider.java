package com.zte.zakker.find.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zte.zakker.common.provider.IAutomationProvider;
import com.zte.zakker.find.fragment.MainAutomationFragment;

/**
 * Description: <FindProvider><br>
 * Author:      mxdl<br>
 * Date:        2019/5/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
@Route(path = "/automation/main",name = "自动化")
public class AutomationProvider implements IAutomationProvider {
    @Override
    public Fragment getMainFindFragment() {
        return MainAutomationFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}

package com.zte.zakker.test.inject.component;

import com.zte.zakker.test.MainActivity;

import dagger.Component;

/**
 * Description: <MainActivityComponent><br>
 * Author:      mxdl<br>
 * Date:        2019/5/31<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
@Component
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}

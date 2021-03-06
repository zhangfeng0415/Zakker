package com.zte.zakker.find.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.zte.zakker.common.mvvm.BaseFragment;
import com.zte.zakker.find.R;
import com.zte.zakker.find.StoreDeviceChooseActivity;
import com.zte.zakker.find.util.MyNumberPicker;

/**
 * Description: <发现Fragment><br>
 * Author:      mxdl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainFindFragment extends BaseFragment implements NumberPicker.OnValueChangeListener,NumberPicker.OnScrollListener{
    public static final String TAG = MainFindFragment.class.getSimpleName();
    private MyNumberPicker mBedRoomNumberPicker;
    private MyNumberPicker mDiningRoomNumberPicker;
    private MyNumberPicker mRestroomNumberPicker;
    private MyNumberPicker mFamilyMemberNumberPicker;
    private View mView;
    private ImageView nextButtonView;
    private ImageView mcustom_make_next;
    public static MainFindFragment newInstance() {
        return new MainFindFragment();
    }
    @Override
    public int onBindLayout() {
        return R.layout.store_speed_plan;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.store_speed_plan,container,false);
        initSpeedPlanNumberPicker();
        nextButtonView = mView.findViewById(R.id.next_button);
        nextButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mFragmentStore = new Intent(getContext(), StoreDeviceChooseActivity.class);
                startActivity(mFragmentStore);

//                StoreDeviceChooseFragment mStoreDeviceChooseFragment = new StoreDeviceChooseFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.store_speed_plan, mStoreDeviceChooseFragment).commit();
            }
        });
        mcustom_make_next = mView.findViewById(R.id.custom_make_next);
        mcustom_make_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), R.string.custom_make_warning, Toast.LENGTH_SHORT).show();
            }
        });
        return mView;
    }
    private void initSpeedPlanNumberPicker() {
        mBedRoomNumberPicker = mView.findViewById(R.id.bed_room_number);
//        mBedRoomNumberPicker.setFormatter(this);
        mBedRoomNumberPicker.setOnScrollListener(this);
        mBedRoomNumberPicker.setOnValueChangedListener(this);
        mBedRoomNumberPicker.setMaxValue(6);
        mBedRoomNumberPicker.setMinValue(1);
        mBedRoomNumberPicker.setValue(4);

        mDiningRoomNumberPicker = mView.findViewById(R.id.dining_room_number);
//        mDiningRoomNumberPicker.setFormatter(this);
        mDiningRoomNumberPicker.setOnScrollListener(this);
        mDiningRoomNumberPicker.setOnValueChangedListener(this);
        mDiningRoomNumberPicker.setMaxValue(3);
        mDiningRoomNumberPicker.setMinValue(0);
        mDiningRoomNumberPicker.setValue(2);

        mRestroomNumberPicker = mView.findViewById(R.id.restroom_number);
//        mRestroomNumberPicker.setFormatter(this);
        mRestroomNumberPicker.setOnScrollListener(this);
        mRestroomNumberPicker.setOnValueChangedListener(this);
        mRestroomNumberPicker.setMaxValue(3);
        mRestroomNumberPicker.setMinValue(0);
        mRestroomNumberPicker.setValue(2);

        mFamilyMemberNumberPicker = mView.findViewById(R.id.family_members);
//        mFamilyMemberNumberPicker.setFormatter(this);
        mFamilyMemberNumberPicker.setOnScrollListener(this);
        mFamilyMemberNumberPicker.setOnValueChangedListener(this);
        mFamilyMemberNumberPicker.setMaxValue(10);
        mFamilyMemberNumberPicker.setMinValue(1);
        mFamilyMemberNumberPicker.setValue(5);
    }

    @Override
    public void onScrollStateChange(NumberPicker numberPicker, int i) {

    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

    }

}

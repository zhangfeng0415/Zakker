package com.zte.zakker.me.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zte.zakker.me.R;

import com.zte.zakker.me.fragment.Setting;

import java.util.List;

public class SettingAdapter  extends ArrayAdapter<Setting> {
    private int resourceId;
    public SettingAdapter(@NonNull Context context, int resource, List<Setting> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Setting setting = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView settingImage = (ImageView) view.findViewById(R.id.setting_image) ;
        TextView settingName = (TextView) view.findViewById(R.id.setting_name);
        ImageView settingRight = (ImageView) view.findViewById(R.id.setting_right);
        settingImage.setImageResource(setting.getImageId_name());
        settingName.setText(setting.getName());
        settingRight.setImageResource(setting.getImageId_right());
        return view;
    }
}

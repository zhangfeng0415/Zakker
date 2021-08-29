package com.zte.zakker.find.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.lang.reflect.Field;

public class MyNumberPicker extends NumberPicker {
    public MyNumberPicker(Context context) {
        super(context);
        setPickerDividerColor(this);
    }

    public MyNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPickerDividerColor(this);
    }

    public MyNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setPickerDividerColor(this);
    }

    public MyNumberPicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setPickerDividerColor(this);
    }
    @Override
    public void addView(View child) {
        super.addView(child);
        updateView(child);
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
        updateView(child);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    public void updateView(View view) {
        if (view instanceof EditText) {
            // 修改字体的属性
            ((EditText)view).setTextColor(Color.parseColor("#1C84FF"));
//            ((EditText)view).setTextSize(20);
        }
    }
    // 通过反射拿到 mSelectionDivider 属性，然后设置上颜色值。
    private void setPickerDividerColor(NumberPicker mNumberPicker) {
        Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for (Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDivider")) {
                pf.setAccessible(true);
                try{
                    pf.set(mNumberPicker,new ColorDrawable(Color.parseColor("#1C84FF")));
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                }catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

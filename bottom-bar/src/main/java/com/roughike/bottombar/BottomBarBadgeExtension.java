package com.roughike.bottombar;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.ViewGroup;

/**
 * Created by Android Studio.
 * User: Moki
 * Email: mosicou@gmail.com
 * Date: 2017/9/5
 * Time: 14:34
 * Desc:
 */

public class BottomBarBadgeExtension extends BottomBarBadge {

    BottomBarBadgeExtension(Context context) {
        super(context);
    }

    @Override
    void attachToTab(BottomBarTab tab, int backgroundColor) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setGravity(Gravity.CENTER);
        setTextSize(12);
        setTextColor(Color.WHITE);
        setBackground(ContextCompat.getDrawable(
                getContext(),
                R.drawable.bg_long_circle_main_red
        ));
        wrapTabAndBadgeInSameContainer(tab);
    }

    @Override
    void setColoredCircleBackground(int circleColor) {
        setBackground(ContextCompat.getDrawable(
                getContext(),
                R.drawable.bg_long_circle_main_red
        ));
    }

    @Override
    void adjustPositionAndSize(BottomBarTab tab) {
        AppCompatImageView iconView = tab.getIconView();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();

        float xOffset = (float) (iconView.getWidth() / 1.25);

        setX(iconView.getX() + xOffset);
        setTranslationY(10);

        int width;
        int height;
        if (getCount() < 10) {
            width = UnitConversion.dp2px(getContext(), 20);
            height = UnitConversion.dp2px(getContext(), 20);
        } else if (getCount() < 100) {
            width = UnitConversion.dp2px(getContext(), 24);
            height = UnitConversion.dp2px(getContext(), 20);
        } else if (getCount() < 1000) {
            width = UnitConversion.dp2px(getContext(), 28);
            height = UnitConversion.dp2px(getContext(), 20);
        } else if (getCount() < 10000) {
            width = UnitConversion.dp2px(getContext(), 34);
            height = UnitConversion.dp2px(getContext(), 20);
        } else {
            setCount(9999);
            width = UnitConversion.dp2px(getContext(), 34);
            height = UnitConversion.dp2px(getContext(), 20);
        }

        layoutParams.width = width;
        layoutParams.height = height;
        setLayoutParams(layoutParams);
    }
}

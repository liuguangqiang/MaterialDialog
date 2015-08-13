package com.liuguangqiang.materialdialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;

/**
 * Created by Eric on 15/8/10.
 */
public class ThemeResolver {

    public static int getColor(Context context, @AttrRes int attr) {
        return getColor(context, attr, 0);
    }

    public static int getColor(Context context, @AttrRes int attr, int defaultColor) {
        TypedArray a = context.getTheme().obtainStyledAttributes(new int[]{attr});
        try {
            return a.getColor(0, defaultColor);
        } finally {
            a.recycle();
        }
    }

}

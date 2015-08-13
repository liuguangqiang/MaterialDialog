package com.liuguangqiang.materialdialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;

/**
 * Created by Eric on 15/8/9.
 */
public class DisplayUtils {

    public static int px2dip(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    public static int dip2px(Context context, float dip) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int getScreenWidth(Activity context) {
        Display dis = context.getWindowManager().getDefaultDisplay();
        Point outSize = new Point(0, 0);
        dis.getSize(outSize);
        if (outSize != null) {
            return outSize.x;
        }
        return 0;
    }

}

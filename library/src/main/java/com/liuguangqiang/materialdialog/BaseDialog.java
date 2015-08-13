package com.liuguangqiang.materialdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.WindowManager;

/**
 * Created by Eric on 15/8/9.
 */
public class BaseDialog extends Dialog {

    public BaseDialog(Context context, int theme) {
        super(context, R.style.MaterialDialog);
        getWindow().setBackgroundDrawableResource(R.drawable.transparent_bg);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }

}

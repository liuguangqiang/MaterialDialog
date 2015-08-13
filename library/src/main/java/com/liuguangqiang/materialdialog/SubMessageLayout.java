package com.liuguangqiang.materialdialog;

import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Eric on 15/8/11.
 */
public class SubMessageLayout extends SubLayout {

    private TextView tvMessage;
    private ScrollView scrollViewMessage;

    public static void into(LinearLayout root, MaterialDialog.Builder builder) {
        SubMessageLayout layout = new SubMessageLayout(builder, R.layout.sub_message);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        params.weight = 1;
        root.addView(layout.getView(), params);
    }

    public SubMessageLayout(MaterialDialog.Builder builder, @LayoutRes int resId) {
        super(builder, resId);
    }

    @Override
    public void initViews(View view) {
        tvMessage = findById(R.id.tv_message);
        tvMessage.setText(builder.message);
        scrollViewMessage = findById(R.id.scrollview_message);

        if (builder.messageColor != 0) {
            tvMessage.setTextColor(builder.messageColor);
        }

        if (builder.contentFont != null) {
            tvMessage.setTypeface(builder.contentFont);
        }

        if (TextUtils.isEmpty(builder.title)) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) scrollViewMessage.getLayoutParams();
            params.topMargin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_margin_small);
        }
    }

}

/*
 * Copyright 2015 Eric Liu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.liuguangqiang.materialdialog;

import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Eric on 15/8/11.
 */
public class SubButtonLayout extends SubLayout implements View.OnClickListener {

    private static final int NEGATIVE = 0;
    private static final int POSITIVE = 1;

    private TextView tvNegative;
    private TextView tvPositive;

    private MaterialDialog dialog;

    public static SubButtonLayout create(MaterialDialog dialog, MaterialDialog.Builder builder) {
        return new SubButtonLayout(dialog, builder, R.layout.sub_dialog_buttons);
    }

    public SubButtonLayout(MaterialDialog dialog, MaterialDialog.Builder builder, @LayoutRes int resId) {
        super(builder, resId);
        this.dialog = dialog;
    }

    @Override
    public void initViews(View view) {
        tvPositive = findById(R.id.tv_positive);
        tvNegative = findById(R.id.tv_negative);

        tvNegative.setTag(NEGATIVE);
        tvPositive.setTag(POSITIVE);
        tvPositive.setAllCaps(true);
        tvNegative.setAllCaps(true);

        if (builder.primaryColor != 0) {
            tvPositive.setTextColor(builder.primaryColor);
            tvNegative.setTextColor(builder.primaryColor);
        }

        if (builder.titleFont != null) {
            tvNegative.setTypeface(builder.titleFont);
            tvPositive.setTypeface(builder.titleFont);
        }

        tvNegative.setOnClickListener(this);
        tvPositive.setOnClickListener(this);

        populateUi();
    }

    private void populateUi() {
        if (!TextUtils.isEmpty(builder.negativeText)) {
            tvNegative.setText(builder.negativeText);
        } else {
            tvNegative.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(builder.positiveText)) {
            tvPositive.setText(builder.positiveText);
        } else {
            tvPositive.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        int TAG = (int) v.getTag();
        switch (TAG) {
            case NEGATIVE:
                if (builder.negativeClickListener != null) {
                    builder.negativeClickListener.onClick(dialog, -1);
                }
                dialog.dismiss();
                break;
            case POSITIVE:
                if (builder.positiveClickListener != null) {
                    builder.positiveClickListener.onClick(dialog, -1);
                }
                dialog.dismiss();
                break;
            default:
                break;
        }
    }

}

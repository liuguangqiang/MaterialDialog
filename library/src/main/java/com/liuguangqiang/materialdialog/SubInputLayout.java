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
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.liuguangqiang.materialdialog.internal.TintUtils;

/**
 * Created by Eric on 15/8/11.
 */
public class SubInputLayout extends SubLayout {

    private EditText etInput;

    public static void into(LinearLayout root, MaterialDialog.Builder builder) {
        SubInputLayout layout = new SubInputLayout(builder, R.layout.sub_input);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_default_margin);
        params.leftMargin = margin;
        params.rightMargin = margin;
        root.addView(layout.getView(), params);
    }

    public SubInputLayout(MaterialDialog.Builder builder, @LayoutRes int resId) {
        super(builder, resId);
    }

    @Override
    public void initViews(View view) {
        etInput = findById(R.id.et_content);
        etInput.setHint(builder.hint);
        etInput.setVisibility(View.VISIBLE);
        etInput.setSingleLine(builder.singleLine);
        TintUtils.setTint(etInput, builder.primaryColor);
    }

}

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

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;

import com.liuguangqiang.materialdialog.enums.ListType;

/**
 * Created by Eric on 15/8/9.
 */
public class MaterialDialog extends BaseDialog {

    private static final String TAG = "MaterialDialog";

    public MaterialDialog(Builder builder) {
        super(builder.context, 0);
        setContentView(new DialogCreator(builder, this).getView());
    }

    public static class Builder {

        protected Activity context;
        protected String title;
        protected String message;
        protected String neutralText;
        protected String positiveText;
        protected String negativeText;
        protected String hint;
        protected boolean cancelable;
        protected boolean singleLine;
        protected int primaryColor = 0;
        protected int titleColor = 0;
        protected int messageColor = 0;

        protected ListType listType = ListType.NORMAL;
        protected String[] items;

        //SingleChoice
        protected OnClickListener onItemClickListener;
        protected OnClickListener onSingleChoiceClickListener;
        protected OnMultiChoiceClickListener onMultiChoiceClickListener;
        protected int checkedItem = 0;

        protected Typeface titleFont;
        protected Typeface contentFont;

        protected OnClickListener positiveClickListener;
        protected OnClickListener negativeClickListener;

        public Builder(Activity context) {
            this.context = context;

            int defaultColor = ThemeResolver.getColor(context, android.R.attr.colorPrimary, context.getResources().getColor(R.color.color_primary));
            primaryColor = ThemeResolver.getColor(context, R.attr.md_primary_color, defaultColor);
            titleColor = ThemeResolver.getColor(context, R.attr.md_title_color, context.getResources().getColor(R.color.title_text_color));
            messageColor = ThemeResolver.getColor(context, R.attr.md_message_color, context.getResources().getColor(R.color.content_text_color));

            if (titleFont == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    titleFont = Typeface.create("sans-serif-medium", Typeface.NORMAL);
                    contentFont = Typeface.create("sans-serif", Typeface.NORMAL);
                } else {
                    titleFont = Typeface.create("sans-serif", Typeface.BOLD);
                    contentFont = Typeface.create("sans-serif", Typeface.NORMAL);
                }
            }
        }

        public Builder cancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(@StringRes int resId) {
            this.title = context.getString(resId);
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setContent(@StringRes int resId) {
            this.title = context.getString(resId);
            return this;
        }

        public Builder setNeutralButton(String neutralText) {
            this.neutralText = neutralText;
            return this;
        }

        public Builder setNegativeButton(String negativeText, OnClickListener listener) {
            this.negativeText = negativeText;
            this.negativeClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveText, OnClickListener listener) {
            this.positiveText = positiveText;
            this.positiveClickListener = listener;
            return this;
        }

        public Builder setItems(@ArrayRes int resId, OnClickListener onItemClickListener) {
            return setItems(context.getResources().getStringArray(resId), onItemClickListener);
        }

        public Builder setItems(String[] items, OnClickListener onItemClickListener) {
            this.listType = ListType.NORMAL;
            this.items = items;
            this.onItemClickListener = onItemClickListener;
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int resId, int checkedItem, OnClickListener onSingleChoiceClickListener) {
            return setSingleChoiceItems(context.getResources().getStringArray(resId), checkedItem, onSingleChoiceClickListener);
        }

        public Builder setSingleChoiceItems(String[] items, int checkedItem, OnClickListener onSingleChoiceClickListener) {
            this.listType = ListType.SINGLE_CHOICE;
            this.items = items;
            this.checkedItem = checkedItem;
            this.onSingleChoiceClickListener = onSingleChoiceClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int resId, int checkedItem, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            return setMultiChoiceItems(context.getResources().getStringArray(resId), checkedItem, onMultiChoiceClickListener);
        }

        public Builder setMultiChoiceItems(String[] items, int checkedItem, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.listType = ListType.MULTI_CHOICE;
            this.items = items;
            this.onMultiChoiceClickListener = onMultiChoiceClickListener;
            return this;
        }

        public Builder setInput(String hint, boolean singleLine) {
            this.hint = hint;
            this.singleLine = singleLine;
            return this;
        }

        public MaterialDialog build() {
            return new MaterialDialog(this);
        }
    }

}

package com.liuguangqiang.materialdialog;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Eric on 15/8/11.
 */
public abstract class SubLayout {

    public MaterialDialog.Builder builder;
    public LayoutInflater layoutInflater;
    public View view;

    public SubLayout(MaterialDialog.Builder builder, @LayoutRes int resId) {
        this.builder = builder;
        this.layoutInflater = LayoutInflater.from(builder.context);
        this.view = layoutInflater.inflate(resId, null);
        initViews(this.view);
    }

    public abstract void initViews(View view);

    public View getView() {
        return view;
    }


    public <T extends View> T findById(int resId) {
        return (T) view.findViewById(resId);
    }

}

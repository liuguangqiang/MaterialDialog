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

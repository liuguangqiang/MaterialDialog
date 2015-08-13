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

package com.liuguangqiang.materialdialog.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Eric on 15/8/10.
 */
public class BaseAdapter<T> extends android.widget.BaseAdapter {
    public Context context;
    public List<T> data;

    public BaseAdapter() {
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return this.data != null && !this.data.isEmpty() ? this.data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void clear() {
        if (this.data != null && !this.data.isEmpty()) {
            this.data.clear();
            this.notifyDataSetChanged();
        }
    }

    public void add(T t) {
        if (this.data != null) {
            this.data.add(t);
            this.notifyDataSetChanged();
        }
    }

    public void add(List<T> list) {
        if (this.data != null) {
            this.data.addAll(list);
            this.notifyDataSetChanged();
        }
    }

    public void addToTop(T t) {
        if (this.data != null) {
            this.data.add(0, t);
            this.notifyDataSetChanged();
        }
    }

    public void addToTop(List<T> list) {
        if (this.data != null) {
            this.data.addAll(0, list);
            this.notifyDataSetChanged();
        }
    }

    public void remove(int position) {
        if (this.data != null && !this.data.isEmpty()) {
            this.data.remove(position);
            this.notifyDataSetChanged();
        }
    }

    public void remove(List<T> list) {
        if (this.data != null && !this.data.isEmpty()) {
            this.data.removeAll(list);
            this.notifyDataSetChanged();
        }
    }
}

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

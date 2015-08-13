package com.liuguangqiang.materialdialog.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.liuguangqiang.materialdialog.R;
import com.liuguangqiang.materialdialog.enums.ListType;
import com.liuguangqiang.materialdialog.internal.TintUtils;

import java.util.List;

/**
 * Created by Eric on 15/8/10.
 */
public class SimpleListAdapter extends BaseAdapter<ListItem> {

    private ViewHolder viewholder;
    private ListType listType;
    private int primaryColor;

    public SimpleListAdapter(Context c, List<ListItem> list, ListType listType, int primaryColor) {
        this.context = c;
        this.data = list;
        this.listType = listType;
        this.primaryColor = primaryColor;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewholder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_simple, null);
            viewholder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            viewholder.radioButton = (RadioButton) convertView.findViewById(R.id.rb_single_choice);
            viewholder.checkBox = (CheckBox) convertView.findViewById(R.id.cb_multi_choice);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        ListItem item = data.get(position);
        viewholder.tvTitle.setText(item.title);
        if (listType == ListType.SINGLE_CHOICE) {
            viewholder.radioButton.setVisibility(View.VISIBLE);
            viewholder.radioButton.setChecked(item.checked);
            TintUtils.setTint(viewholder.radioButton, primaryColor);
        }

        if (listType == ListType.MULTI_CHOICE) {
            viewholder.checkBox.setVisibility(View.VISIBLE);
            viewholder.checkBox.setChecked(item.checked);
            TintUtils.setTint(viewholder.checkBox, primaryColor);
        }
        return convertView;
    }

    private static class ViewHolder {
        TextView tvTitle;
        RadioButton radioButton;
        CheckBox checkBox;
    }
}
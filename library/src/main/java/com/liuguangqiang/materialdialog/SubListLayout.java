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
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.liuguangqiang.materialdialog.list.ListItem;
import com.liuguangqiang.materialdialog.list.SimpleListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 15/8/11.
 */
public class SubListLayout extends SubLayout implements AdapterView.OnItemClickListener {

    private MaterialDialog dialog;
    private ListView lvContent;
    private List<ListItem> list;
    private SimpleListAdapter adapter;

    public static void into(LinearLayout root, MaterialDialog dialog, MaterialDialog.Builder builder) {
        SubListLayout layout = new SubListLayout(dialog, builder, R.layout.sub_list);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        params.bottomMargin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_margin_small);
        params.weight = 1;
        if (TextUtils.isEmpty(builder.title)) {
            params.topMargin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_margin_small);
        } else {
            params.topMargin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_default_margin_half);
        }
        root.addView(layout.getView(), params);
    }

    public SubListLayout(MaterialDialog dialog, MaterialDialog.Builder builder, @LayoutRes int resId) {
        super(builder, resId);
        this.dialog = dialog;
    }

    @Override
    public void initViews(View view) {
        lvContent = findById(R.id.lv_content);
        list = wrapItems(builder.items);
        adapter = new SimpleListAdapter(builder.context, list, builder.listType, builder.primaryColor);
        lvContent.setAdapter(adapter);
        lvContent.setVisibility(View.VISIBLE);
        lvContent.setOnItemClickListener(this);
    }

    private List<ListItem> wrapItems(String[] items) {
        List<ListItem> list = new ArrayList<>();
        ListItem listItem;
        for (String title : items) {
            listItem = new ListItem();
            listItem.title = title;
            list.add(listItem);
        }

        int checkedItem = builder.checkedItem;
        if (checkedItem >= 0 && checkedItem < items.length) {
            list.get(checkedItem).checked = true;
        }

        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (builder.listType) {
            case NORMAL:
                dialog.dismiss();
                break;
            case SINGLE_CHOICE:
                singleChoice(position);
                break;
            case MULTI_CHOICE:
                multiChoice(position);
                break;
        }
    }

    public void clearChoice() {
        for (ListItem item : list) {
            item.checked = false;
        }
    }

    private void singleChoice(int position) {
        clearChoice();
        list.get(position).checked = true;
        adapter.notifyDataSetChanged();
        if (builder.onSingleChoiceClickListener != null) {
            builder.onSingleChoiceClickListener.onClick(dialog, position);
        }
    }

    private void multiChoice(int position) {
        ListItem item = list.get(position);
        item.checked = !item.checked;
        adapter.notifyDataSetChanged();
        if (builder.onMultiChoiceClickListener != null) {
            builder.onMultiChoiceClickListener.onClick(dialog, position, item.checked);
        }
    }

}

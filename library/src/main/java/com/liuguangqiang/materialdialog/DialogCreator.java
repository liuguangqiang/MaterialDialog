package com.liuguangqiang.materialdialog;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuguangqiang.materialdialog.internal.TintUtils;

/**
 * Created by Eric on 15/8/9.
 */
public class DialogCreator {

    private int dialogWidth;
    private MaterialDialog.Builder builder;
    private MaterialDialog dialog;

    private View window;
    private LinearLayout layoutRoot;
    private TextView tvTitle;
    private EditText etContent;

    public DialogCreator(MaterialDialog.Builder builder, MaterialDialog dialog) {
        this.builder = builder;
        this.dialog = dialog;
        createRootView();
        initViews();
        populateUi();
    }

    public void createRootView() {
        int width = DisplayUtils.getScreenWidth(builder.context);
        int margin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_window_margin);
        dialogWidth = width - margin * 2;
        this.dialog.getWindow().getDecorView().setPadding(0, margin, 0, margin);
        window = LayoutInflater.from(builder.context).inflate(R.layout.dialog_basic, null);
        window.setLayoutParams(new ViewGroup.LayoutParams(dialogWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            window.setBackgroundDrawable(getBackground());
        } else {
            window.setBackground(getBackground());
        }
        layoutRoot = findById(R.id.layout_root);
    }

    private Drawable getBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setSize(dialogWidth, 10);
        gradientDrawable.setCornerRadius(5);
        gradientDrawable.setColor(Color.WHITE);
        return gradientDrawable;
    }

    public View getView() {
        return this.window;
    }

    private void initViews() {
        if (!TextUtils.isEmpty(builder.message)) {
            SubMessageLayout.into(layoutRoot, builder);
        } else if (builder.items != null) {
            SubListLayout.into(layoutRoot, dialog, builder);
        }

        if (!TextUtils.isEmpty(builder.positiveText) || !TextUtils.isEmpty(builder.negativeText)) {
            layoutRoot.addView(SubButtonLayout.create(dialog, builder).getView());
        }

        tvTitle = findById(R.id.tv_title);
        etContent = findById(R.id.et_content);

        renderTypeFace();
    }

    /**
     * render the typeface for buttons , content and title.
     */
    private void renderTypeFace() {
        if (builder.titleColor != 0) {
            tvTitle.setTextColor(builder.titleColor);
        }

        if (builder.titleFont != null) {
            tvTitle.setTypeface(builder.titleFont);
        }
    }

    private void populateUi() {
        if (!TextUtils.isEmpty(builder.title)) {
            tvTitle.setText(builder.title);
        } else {
            tvTitle.setVisibility(View.GONE);
        }

        //input
        if (builder.hint != null) {
            etContent.setHint(builder.hint);
            etContent.setVisibility(View.VISIBLE);
            etContent.setSingleLine(builder.singleLine);
            TintUtils.setTint(etContent, builder.primaryColor);
        }
    }

    public <T extends View> T findById(int resId) {
        return (T) window.findViewById(resId);
    }

}

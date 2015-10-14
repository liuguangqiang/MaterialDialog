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

package liuguangqiang.com.materialdialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.liuguangqiang.materialdialog.MaterialDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btn_basic)
    public void basic() {
        new MaterialDialog.Builder(this)
                .setTitle("Basic Dialog")
                .setMessage("This is a basic dialog!")
                .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .cancelable(false)
                .build()
                .show();
    }

    @OnClick(R.id.btn_basic_no_title)
    public void basicNoTitle() {
        new MaterialDialog.Builder(this)
                .setMessage("This app wants to access your location.")
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Refuse", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .cancelable(true)
                .build()
                .show();
    }

    int checkItem = 0;

    @OnClick(R.id.btn_single_choice_list)
    public void singleChoiceList() {
        new MaterialDialog.Builder(this)
                .setTitle("Eric's MacBook Pro")
                .setSingleChoiceItems(R.array.simple_list, checkItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        checkItem = which;
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .build()
                .show();
    }

    @OnClick(R.id.btn_simple_list)
    public void simpleList() {
        new MaterialDialog.Builder(this)
                .setTitle("Eric's MacBook Pro")
                .setItems(R.array.simple_list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(getApplicationContext(), "on click" + which, Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .show();
    }

    @OnClick(R.id.btn_simple_list_no_title)
    public void simpleListNoTitle() {
        new MaterialDialog.Builder(this)
                .setMultiChoiceItems(R.array.simple_list, 4, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .build()
                .show();
    }

    @OnClick(R.id.btn_input)
    public void input() {
        new MaterialDialog.Builder(this)
                .setTitle("Simple Input")
                .setInput("Please input your message", true)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .build()
                .show();
    }

    @OnClick(R.id.btn_progress_dialog)
    public void progressDialog() {
        new MaterialDialog.Builder(this)
                .setTitle("Progress Dialog")
                .setMessage("Please wait...")
                .isProgressDialog(true)
                .build()
                .show();
    }

    @OnClick(R.id.btn_progress_dialog_no_title)
    public void progressDialogNoTitle() {
        new MaterialDialog.Builder(this)
                .setMessage("Please wait...")
                .isProgressDialog(true)
                .build()
                .show();
    }

    @OnClick(R.id.btn_progress_dialog_black)
    public void progressDialogBlack() {
        new MaterialDialog.Builder(this)
                .setMessage("Please wait...")
                .isProgressDialog(true)
                .setBackgroundColor(getResources().getColor(R.color.black_background))
                .setMessageColor(Color.WHITE)
                .build()
                .show();
    }

}

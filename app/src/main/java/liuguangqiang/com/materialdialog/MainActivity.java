package liuguangqiang.com.materialdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
                .setTitle("你好吗？")
                .setMessage("Go fuck yourself!")
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
                .build()
                .show();
    }

    @OnClick(R.id.btn_basic_no_title)
    public void basicNoTitle() {
//        new MaterialDialog.Builder(this)
//                .setMessage("This app wants to access your location.")
//                .setPositiveButton("Positive")
//                .setNegativeButton("Negative")
//                .build()
//                .show();

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("TestTitle")
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
//                .setSingleChoiceItems()
                .setMultiChoiceItems(new String[]{"1", "2", "3"}, new boolean[]{true, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                })
                .create();
        alertDialog.show();
    }

    int checkItem = 0;

    @OnClick(R.id.btn_simple_list)
    public void simpleList() {
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
                        Toast.makeText(getApplicationContext(), "on checked" + checkItem, Toast.LENGTH_SHORT).show();
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

    @OnClick(R.id.btn_simple_list_no_title)
    public void simpleListNoTitle() {
        new MaterialDialog.Builder(this)
                .setTitle("Eric's MacBook Pro")
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
                .setTitle("输入")
                .setMessage("请输入你需要的内容")
                .setInput("请输入你需要的内容", true)
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

}

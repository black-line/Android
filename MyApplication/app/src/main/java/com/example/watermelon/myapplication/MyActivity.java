package com.example.watermelon.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.appcompat.BuildConfig;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.os.Environment;



import java.io.File;


public class MyActivity extends AppCompatActivity {
    Button buttonSign1;
    Button buttonReset1;
    View.OnClickListener buttonSign=null;
    View.OnClickListener buttonReset=null;

    String num = "0";
    TextView text = null;

    int i=0;
    int j = 1;                           //1:第一次启动2:计数3:清零
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    public static final String t = "0";
    public static final String SETTING_INFOS = "SETTING_Infos";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttonSign=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j=2;
                i++;
                text.setText(Integer.valueOf(num)+ i + "");
            }
        };
        buttonReset=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j=3;
                text.setText(0 + "");
                num = "0";
                i=0;
            }
        };
        setContentView(R.layout.activity_my);
        setTitle("签到");
        buttonSign1=(Button) findViewById(R.id.buttonSign);
        buttonSign1.setOnClickListener(buttonSign);
        buttonReset1=(Button)findViewById(R.id.buttonReset);
        buttonReset1.setOnClickListener(buttonReset);
        text=(TextView) findViewById(R.id.textView3);

        //启动时从文件获取已签到天数
        SharedPreferences settings = getSharedPreferences(SETTING_INFOS, 0);
        num = settings.getString(t, "0");                    //设置默认值
        text.setText(Integer.valueOf(num) + "");


        //text.setText(num);
    }
    protected void onStop() {
        super.onStop();
        SharedPreferences settings = getSharedPreferences(SETTING_INFOS, 0);
        settings.edit()
                .putString(t, text.getText().toString())
                .commit();

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /** Called when the user clicks the Send button */

}

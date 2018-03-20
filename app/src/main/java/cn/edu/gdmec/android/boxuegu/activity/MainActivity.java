package cn.edu.gdmec.android.boxuegu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import cn.edu.gdmec.android.boxuegu.R;

public class MainActivity extends AppCompatActivity {
    private TextView tv_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_user_name = (TextView) findViewById(R.id.tv_user_name);
        //判断是否已经登录
        if (readLoginStatus()) {
            //Toast.makeText(this, "已经登陆", Toast.LENGTH_SHORT).show();
            tv_user_name.setText(readLoginName());
        } else {
            Toast.makeText(this, "未登陆", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            MainActivity.this.finish();
        }
    }

    /**
     * 读取登录状态
     **/
    private boolean readLoginStatus() {
        SharedPreferences sp = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin", false);
        return isLogin;
    }
    private String readLoginName(){
        SharedPreferences sp = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        String loginName = sp.getString("loginUserName", "");
        return loginName;
    }
}

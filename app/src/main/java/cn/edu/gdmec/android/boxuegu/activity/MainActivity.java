package cn.edu.gdmec.android.boxuegu.activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import cn.edu.gdmec.android.boxuegu.R;

public class MainActivity extends AppCompatActivity {
    private TextView tv_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_user_name = (TextView)findViewById(R.id.tv_user_name);
        //判断是否已经登录
        if (readLoginStatus()){
            
        }else{
            //未登录跳转到登录界面
            //利用Timer让此界面延迟3秒后跳转,timer中有一个线程，这个线程不断执行task
            Timer timer =new Timer();
            //timertask实现runnable接口,TimerTask类表示一个在指定时间内执行的task
            TimerTask task=new TimerTask() {
                @Override
                public void run() {
                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
            };
            timer.schedule(task, 3000);//设置这个task在延迟3秒之后自动执行
        }
    }

    /**
     * 读取登录状态
     * @return
     */
    /**
     * 读取登录状态
     * @return
     */
    private boolean readLoginStatus(){
        SharedPreferences sp = getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin",false);
        return isLogin;
    }
}

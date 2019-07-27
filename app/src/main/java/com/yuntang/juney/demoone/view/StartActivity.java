package com.yuntang.juney.demoone.view;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.yuntang.juney.demoone.R;

public class StartActivity extends AppCompatActivity implements Animation.AnimationListener, View.OnClickListener {
    View view;
    private TextView skip;    //跳过设置,存放文本

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.activity_start, null);    //填充内容
        setContentView(view);
        initViews();
        setAlphaAnimation();
    }

    public void initViews() {    //初始化组件
        countDownTimer.start();   //开始倒计时
        skip = (TextView) findViewById(R.id.skip);
        skip.setOnClickListener(this);
    }

    private void setAlphaAnimation() {     //渐变动画设置
        AlphaAnimation animation = new AlphaAnimation(0.3f, 1.0f);    //渐变动画的透明度从30%~100%
        animation.setDuration(5000);     //持续时间为5秒
        animation.setAnimationListener(this);
        view.setAnimation(animation);     //为当前内容视图绑定渐变动画
    }



    private void redirect() {     //重定向方法
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private CountDownTimer countDownTimer = new CountDownTimer(5000 + 1000, 1000) {     //1s间隔
        @Override
        public void onTick(long millisUntilFinished) {       //重写计时的方法
            String value = String.valueOf((int) (millisUntilFinished  / 1000 ));        //强转int类型，获取当前倒数秒数
            skip.setText(value + "s | 跳过");      //显示在文本上
        }

        @Override
        public void onFinish() {      //重写计时结束方法
            return;
        }

    };

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {     //动画结束
        redirect();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    protected void onDestroy() {    //销毁资源
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        countDownTimer.cancel();     //取消倒计时
        redirect();   //跳转
    }
}

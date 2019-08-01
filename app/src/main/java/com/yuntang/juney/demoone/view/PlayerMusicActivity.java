package com.yuntang.juney.demoone.view;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.service.MusicService;


/**
 * 音乐播放器活动
 */
public class PlayerMusicActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    String url;
    Handler handler = new Handler();
    private MusicService.MusicBinder binder;
    private Button previous;
    private ToggleButton PlayOrPause;
    private Button next;
    private SeekBar seekBar;
    private ImageView imgAlbum;
    private Animation rotate;
    private ServiceConnection connection;

    @Override
    protected void onPause() {
        super.onPause();
        imgAlbum.clearAnimation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_music);
        initViews();
        setConnection();

        url = getIntent().getStringExtra("url");
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);//旋转动画
        LinearInterpolator lin = new LinearInterpolator();
        rotate.setInterpolator(lin);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(PlayerMusicActivity.this, MusicService.class);
                intent.putExtra("url", url);
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
        }).start();





    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();



    }

    public void initViews() {

        previous = (Button) findViewById(R.id.previous);
        PlayOrPause = (ToggleButton) findViewById(R.id.PlayOrPause);
        next = (Button) findViewById(R.id.next);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        imgAlbum = (ImageView) findViewById(R.id.imgAlbum);    //音乐专辑图片
        previous.setOnClickListener(this);     //上一首监听
        next.setOnClickListener(this);      //下一首监听

        PlayOrPause.setOnCheckedChangeListener(this);      //播放/暂停监听

//        seekBar.setOnSeekBarChangeListener(this);       //进度条监听


    }

    @Override
    public void onClick(View view) {      //按钮点击事件
        switch (view.getId()) {
            case R.id.previous:       //上一首按钮

                break;
            case R.id.next:          //下一首按钮

                break;
        }
    }

    public void setConnection() {
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                binder = (MusicService.MusicBinder) iBinder;
                seekBar.setMax(binder.getProgress());

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        binder.seekProgress(seekBar.getProgress());
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                handler.post(runnable);


            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }


        };
    }



    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {      //播放动作
            System.out.println("播放");




            binder.playMusic();
            imgAlbum.setAnimation(rotate);
        } else {     //暂停动作
            System.out.println("暂停");
            binder.pauseMusic();
            imgAlbum.clearAnimation();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        binder.seekProgress(seekBar.getProgress());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress(binder.getPlayPosition());
            handler.postDelayed(runnable, 2000);
        }
    };

    @Override
    protected void onDestroy() {

        super.onDestroy();
        handler.removeCallbacks(runnable);
        binder.closeMedia();
        unbindService(connection);     //解除服务绑定

    }
}

package com.yuntang.juney.demoone.view;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.presenter.RegisterPresenter;
import com.yuntang.juney.demoone.utils.Mac;

/**
 * 用户注册功能
 */
public class RegisterActivity extends AppCompatActivity implements RegisterView, View.OnClickListener {

    SharedPreferences preferences = null;    //声明SharedPreferences的对象
    private ImageView headLink;
    private EditText uid;
    private EditText password;
    private EditText realName;
    private EditText mobile;
    private EditText birth;
    private EditText email;
    private EditText address;
    private Button btnRegister;
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

    }

    /**
     * 初始化组件
     */
    private void initViews() {

        headLink = (ImageView) findViewById(R.id.headLink);
        uid = (EditText) findViewById(R.id.uid);
        password = (EditText) findViewById(R.id.password);
        realName = (EditText) findViewById(R.id.realName);
        mobile = (EditText) findViewById(R.id.mobile);
        birth = (EditText) findViewById(R.id.birth);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        registerPresenter = new RegisterPresenter(this);
    }


    @Override
    public void onClick(View view) {   //点击事件
        registerPresenter.doRegister();
    }

    @Override
    public String getMac() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Mac mac = new Mac();
        return mac.GenerateRandom(preferences);
    }

    @Override
    public String getUid() {     //从当前视图获取用户名
        return uid.getText().toString().trim();
    }

    @Override
    public String getRealName() {    //从当前视图获取真实姓名
        return realName.getText().toString().trim();
    }

    @Override
    public String getPassword() {    //从当前视图获取密码
        return password.getText().toString().trim();
    }

    @Override
    public String getAddress() {     //从当前视图获取地址
        return address.getText().toString().trim();
    }

    @Override
    public String getMobile() {
        return mobile.getText().toString().trim();
    }

    @Override
    public String getBirth() {   //从当前视图获取出生日期
        return birth.getText().toString().trim();
    }

    @Override
    public String getEmail() {     //从当前视图获取电子邮箱地址
        return email.getText().toString().trim();
    }

    @Override
    public String getHeadLink() {   //从当前视图获取用户
        return null;
    }

    @Override
    public void showSuccessMsg(User user) {      //显示注册成功的消息
        Toast.makeText(this, user.getUid(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailMsg(String feedback) {    //显示注册失败的消息
        Toast.makeText(this, feedback, Toast.LENGTH_SHORT).show();
    }
}

package com.yuntang.juney.demoone.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.presenter.LoginPresenter;
import com.yuntang.juney.demoone.utils.Mac;

/**
 * 用户登录功能
 */
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{

    SharedPreferences preferences = null;
    private EditText uidLogin;
    private EditText passwordLogin;
    private Button btnLogin;
    private TextView gotoRegister;
    private TextView forgetPassword;
    LoginPresenter loginPresenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

    }

    private void initViews() {   //初始化组件
        uidLogin = (EditText) findViewById(R.id.uidLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        gotoRegister = (TextView) findViewById(R.id.gotoRegister);
        forgetPassword = (TextView) findViewById(R.id.forgetPassword);
        gotoRegister.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);
    }


    @Override
    public String getMac() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Mac mac = new Mac();
        return mac.GenerateRandom(preferences);
    }

    @Override
    public String getUid() {    //从当前视图获取用户名
        return uidLogin.getText().toString().trim();
    }

    @Override
    public String getPassword() {   //从当前视图获取密码
        return passwordLogin.getText().toString().trim();
    }

    @Override
    public void showSuccessMsg() {   //登录成功信息
        Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailMsg() {    //登录失败信息
        Toast.makeText(this, "登录失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sharedPreferencesStore(String title, String content) {
        preferences = getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(title, content);
        editor.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                loginPresenter.doLogin();
                break;
            case R.id.gotoRegister:        //前往注册
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.forgetPassword:    //忘记密码

                break;
        }
    }

    public void gotoMain() {      //前往主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

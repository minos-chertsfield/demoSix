package com.yuntang.juney.demoone.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.presenter.LoginPresenter;

/**
 * 用户登录功能
 */
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{

    private EditText uidLogin;
    private EditText passwordLogin;
    private Button btnLogin;
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
        btnLogin.setOnClickListener(this);


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
    public void showSuccessMsg(User user) {   //登录成功信息
        Toast.makeText(this, user.getUid(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailMsg(String feedback) {    //登录失败信息
        Toast.makeText(this, feedback, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

    }
}

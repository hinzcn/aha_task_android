package com.dajunzai.android.ahatask.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.dajunzai.android.ahatask.R;
import com.dajunzai.android.ahatask.persenter.Login_Persenter;
import com.dajunzai.android.ahatask.view.base.BaseActivity;


public class LoginActivity extends BaseActivity  {
    private EditText et_login_username;
    private EditText et_login_password;
    private Button btn_login;
    private Button btn_regist;
    private Login_Persenter mPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    @Override
    protected void initData() {
        mPersenter = new Login_Persenter(this);
    }

    @Override
    protected void getData() {
        btn_login.setOnClickListener(mPersenter);
        btn_regist.setOnClickListener(mPersenter);
    }

    @Override
    protected void findViews() {
        et_login_username = (EditText) findViewById(R.id.et_login_username);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_regist = (Button) findViewById(R.id.btn_regist);
    }

    private void clearView() {
        et_login_password.setText("");
        et_login_username.setText("");
    }

    public EditText getEt_login_username() {
        return et_login_username;
    }

    public EditText getEt_login_password() {
        return et_login_password;
    }

    public Button getBtn_login() {
        return btn_login;
    }

    public Button getBtn_regist() {
        return btn_regist;
    }
}

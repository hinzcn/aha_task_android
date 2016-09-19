package com.dajunzai.android.ahatask.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dajunzai.android.ahatask.MainActivity;
import com.dajunzai.android.ahatask.MyApplication;
import com.dajunzai.android.ahatask.R;
import com.dajunzai.android.ahatask.utils.CommonBean;
import com.dajunzai.android.ahatask.utils.ServerInterface;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_login_username;
    private EditText et_login_password;
    private Button btn_login_submit;
    private Button btn_login_regist;
    ServerInterface serverInterface;

    //0登录模式 1注册模式；
    private static int model=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        serverInterface = ((MyApplication) getApplication()).getRetrofit().create(ServerInterface.class);
        getSupportActionBar().setTitle("登录模式");

    }
    private void initView() {
        et_login_username = (EditText) findViewById(R.id.et_login_username);
        et_login_password = (EditText)findViewById(R.id.et_login_password);
        btn_login_submit = (Button)findViewById(R.id.btn_login_submit);
        btn_login_regist = (Button)findViewById(R.id.btn_login_regist);
        btn_login_submit.setOnClickListener(this);
        btn_login_regist.setOnClickListener(this);
        changeView();
    }

    private void changeView() {
        if(model==1){
            btn_login_regist.setText("登录模式");
            getSupportActionBar().setTitle("注册模式");
        }else if(model==0) {
            btn_login_regist.setText("注册模式");
            getSupportActionBar().setTitle("登录模式");
        }
    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.btn_login_regist:
        if(model==0){
            model=1;
        }else if(model==1){
            model=0;
        }
        changeView();
        break;
    case R.id.btn_login_submit:
        String username = et_login_username.getText().toString();
        String password = et_login_password.getText().toString();
        Log.e("TAG",username+"-->"+password);
        clearView();
        if(model==0){
            Call<CommonBean> login = serverInterface.login(username, password);

            login.enqueue(new Callback<CommonBean>() {
                @Override
                public void onResponse(Response<CommonBean> response, Retrofit retrofit) {
                    CommonBean cb=response.body();
                    if(cb!=null){
                        if(cb.isRe()){
                            Toast.makeText(getApplicationContext(),cb.getMessage(),Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(getApplicationContext(),cb.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"连接失败",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(getApplicationContext(),"eeee",Toast.LENGTH_SHORT).show();
                }
            });
        }else if(model==1){
            Call<CommonBean> regist = serverInterface.regist(username, password);
            regist.enqueue(new Callback<CommonBean>() {
                @Override
                public void onResponse(Response<CommonBean> response, Retrofit retrofit) {
                    Log.e("TAG",response.code()+"");
                    CommonBean cb=response.body();
                    if(cb!=null){
                        if(cb.isRe()){
                            Toast.makeText(getApplicationContext(),cb.getMessage(),Toast.LENGTH_SHORT).show();
                            if(model==0){
                                model=1;
                            }else if(model==1){
                                model=0;
                            }
                            changeView();
                        }else {
                            Toast.makeText(getApplicationContext(),cb.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"连接失败",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(LoginActivity.this,"eeee",Toast.LENGTH_SHORT).show();
                }
            });
        }
        break;
}
    }

    private void clearView() {
        et_login_password.setText("");
        et_login_username.setText("");
    }
}

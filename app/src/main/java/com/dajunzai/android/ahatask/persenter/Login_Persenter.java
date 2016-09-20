package com.dajunzai.android.ahatask.persenter;

import android.text.TextUtils;
import android.view.View;

import com.dajunzai.android.ahatask.R;
import com.dajunzai.android.ahatask.model.CommonHttpClient;
import com.dajunzai.android.ahatask.utils.Utils;
import com.dajunzai.android.ahatask.view.LoginActivity;


/**
 * Created by li_zh on 2016/9/18.
 */
public class Login_Persenter implements View.OnClickListener{

    private LoginActivity mLoginActivity;
    private CommonHttpClient mHttpClient;

    public Login_Persenter(LoginActivity loginActivity) {
        this.mLoginActivity = loginActivity;
        mHttpClient = new CommonHttpClient(loginActivity);
    }

    @Override
    public void onClick(View v) {
        if(checkInPut()) {
            return;
        }
        switch (v.getId()) {
            case R.id.btn_login:
                mHttpClient.userLogin(mLoginActivity.getEt_login_username().getText().toString().trim(),
                        mLoginActivity.getEt_login_password().getText().toString());
                break;
            case R.id.btn_regist:
                mHttpClient.userRegister(mLoginActivity.getEt_login_username().getText().toString().trim(),
                        mLoginActivity.getEt_login_password().getText().toString() );
                break;
        }
    }
    private boolean checkInPut() {
        boolean result = false;
        String userName = mLoginActivity.getEt_login_username().getText().toString();
        String userPwd = mLoginActivity.getEt_login_password().getText().toString();
        if(TextUtils.isEmpty(userName)||TextUtils.isEmpty(userPwd)) {
            result = true;
            Utils.showToast(mLoginActivity,"用户名或密码不能为空");
        }
        return result;
    }
}

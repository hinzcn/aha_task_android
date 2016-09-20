package com.dajunzai.android.ahatask.model;

/**
 * Created by Hinzcn on 2016/9/19.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public class UserBean {

    private String username;
    private String password;
    private String coinpoint;

    public String getCoinpoint() {
        return coinpoint;
    }

    public void setCoinpoint(String coinpoint) {
        this.coinpoint = coinpoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", coinpoint='" + coinpoint + '\'' +
                '}';
    }
}

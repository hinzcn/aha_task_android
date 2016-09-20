package com.dajunzai.android.ahatask.model.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by li_zh on 2016/9/20.
 * 作者:李杰
 * 邮箱:577124196@qq.com
 */
public class TaskListBean {


    /**
     * return : true
     * message : 获取成功
     * datalist : [{"id":"8","username":"test","content":"seeThired","startdate":"2323232","deadline":"2323333","requiretime":"424","level":"3","taskcoin":"6360"},{"id":"10","username":"test","content":"seeThired","startdate":"2323232","deadline":"2323333","requiretime":"424","level":"3","taskcoin":"6360"},{"id":"11","username":"test","content":"seeThired","startdate":"2323232","deadline":"2323333","requiretime":"424","level":"3","taskcoin":"6360"},{"id":"12","username":"test","content":"seeThired","startdate":"2323232","deadline":"2323333","requiretime":"424","level":"3","taskcoin":"6360"}]
     */
    @Expose
    @SerializedName("return")
    private boolean returnX;
    private String message;
    /**
     * id : 8
     * username : test
     * content : seeThired
     * startdate : 2323232
     * deadline : 2323333
     * requiretime : 424
     * level : 3
     * taskcoin : 6360
     */

    private List<DatalistBean> datalist;

    public boolean isReturnX() {
        return returnX;
    }

    public void setReturnX(boolean returnX) {
        this.returnX = returnX;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DatalistBean> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<DatalistBean> datalist) {
        this.datalist = datalist;
    }

    public static class DatalistBean {
        private String id;
        private String username;
        private String content;
        private String startdate;
        private String deadline;
        private String requiretime;
        private String level;
        private String taskcoin;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStartdate() {
            return startdate;
        }

        public void setStartdate(String startdate) {
            this.startdate = startdate;
        }

        public String getDeadline() {
            return deadline;
        }

        public void setDeadline(String deadline) {
            this.deadline = deadline;
        }

        public String getRequiretime() {
            return requiretime;
        }

        public void setRequiretime(String requiretime) {
            this.requiretime = requiretime;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getTaskcoin() {
            return taskcoin;
        }

        public void setTaskcoin(String taskcoin) {
            this.taskcoin = taskcoin;
        }

        @Override
        public String toString() {
            return "DatalistBean{" +
                    "id='" + id + '\'' +
                    ", username='" + username + '\'' +
                    ", content='" + content + '\'' +
                    ", startdate='" + startdate + '\'' +
                    ", deadline='" + deadline + '\'' +
                    ", requiretime='" + requiretime + '\'' +
                    ", level='" + level + '\'' +
                    ", taskcoin='" + taskcoin + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TaskListBean{" +
                "returnX=" + returnX +
                ", message='" + message + '\'' +
                ", datalist=" + datalist +
                '}';
    }
}

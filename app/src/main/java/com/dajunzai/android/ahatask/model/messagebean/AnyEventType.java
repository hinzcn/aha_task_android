package com.dajunzai.android.ahatask.model.messagebean;

import com.joanzapata.android.QuickAdapter;

/**
 * Created by Hinzcn on 2016/9/21.
 * auther:caoyue
 * mail:hinzcn@gmail.com
 */
public class AnyEventType {

    private QuickAdapter quickAdapter;

    public AnyEventType(QuickAdapter quickAdapter) {
        this.quickAdapter = quickAdapter;
    }

    public QuickAdapter getQuickAdapter() {
        return quickAdapter;
    }

    public void setQuickAdapter(QuickAdapter quickAdapter) {
        this.quickAdapter = quickAdapter;
    }
}

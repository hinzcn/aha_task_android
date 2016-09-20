package com.dajunzai.android.ahatask.model;

import com.dajunzai.android.ahatask.MyApplication;

/**
 * Created by li_zh on 2016/9/20.
 * 作者:李杰
 * 邮箱:577124196@qq.com
 */
public class CacheMapManager {

    public static Object getCache(String cacheKey) {
        return MyApplication.getCacheMap().get(cacheKey);
    }

    public static void putCache(String cacheKey, Object cacheValue) {
        MyApplication.getCacheMap().put(cacheKey,cacheValue);

    }
}

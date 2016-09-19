package com.dajunzai.android.ahatask.utils;

import com.dajunzai.android.ahatask.constant.CommonConstant;
import com.dajunzai.android.ahatask.model.ServerInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by li_zh on 2016/9/19.
 */
public class CommonRequestFactory {
    private static Retrofit retrofit;
    private static CommonRequestFactory mCommonRequestFactory;
    private ServerInterface mServerInterface;
    private CommonRequestFactory(){

    }
    public static CommonRequestFactory buildRetrofit(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(CommonConstant.BASEURL)
                    .build();
            mCommonRequestFactory = new CommonRequestFactory();
        }
        return mCommonRequestFactory;
    }

    public ServerInterface createServerInterface(){
        if(mServerInterface==null) {
            mServerInterface = retrofit.create(ServerInterface.class);
        }
        return mServerInterface;
    }

}

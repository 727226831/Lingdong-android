package com.example.storescontrol.Url;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.storescontrol.R;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Untils {
    public static void initTitle(String title,final Activity activity) {

        TextView textViewtitle=activity.findViewById(R.id.tv_title);
        textViewtitle.setText(title);
        ImageButton imageButtonreturn=activity.findViewById(R.id.iv_return);
        imageButtonreturn.setVisibility(View.VISIBLE);
        imageButtonreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }
    /**
     * 将图片转换成Base64编码的字符串
     */
    public static String imageToBase64(String path){
        if(TextUtils.isEmpty(path)){
            return null;
        }
        InputStream is = null;
        byte[] data = null;
        String result = null;
        try{
            is = new FileInputStream(path);
            //创建一个字符流大小的数组。
            data = new byte[is.available()];
            //写入数组
            is.read(data);
            //用默认的编码格式进行编码
            result = Base64.encodeToString(data,Base64.NO_WRAP);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null !=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }
    public static String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return "IMG_" + dateFormat.format(date);
    }
    public static List<String> parseCode(String code,int type){
        List<String> stringList=new ArrayList<>();
        if(!code.isEmpty()){
            String  numbers;
            switch (type){
                case 0:
                    //$
                    numbers=code.replace("$",",");
                    break;
                case 1:
                    //|
                    numbers=code.replace("|",",");
                    break;

                default:
                    numbers=code.replace("$",",");
                    break;
            }

            stringList = Arrays.asList(numbers.split(","));
        }
        Log.i("parsecode-->",stringList.toString());
        return  stringList;

    }
    public static SampleApplicationBean getSampleApplicationBean(Context context){
        SampleApplicationBean bean=null;
        SharedPreferences sharedPreferences=context.getSharedPreferences("sp",0);
        String data=sharedPreferences.getString("SampleApplicationBean","");
        if(!data.isEmpty()){
            bean=new Gson().fromJson(data,SampleApplicationBean.class);
        }
        return  bean;
    }
    public static void  setSampleApplicationBean(Context context,SampleApplicationBean bean){
        SharedPreferences sharedPreferences=context.getSharedPreferences("sp",0);
        sharedPreferences.edit().putString("SampleApplicationBean",new Gson().toJson(bean)).commit();
    }
    public static SampleApplicationBean.Product getProductBean(Context context){
        SampleApplicationBean.Product bean=null;
        SharedPreferences sharedPreferences=context.getSharedPreferences("sp",0);
        String data=sharedPreferences.getString("ProductBean","");
        if(!data.isEmpty()){
            bean=new Gson().fromJson(data,SampleApplicationBean.Product.class);
        }
        return  bean;
    }
    public static void  setProductBean(Context context,SampleApplicationBean.Product bean){
        SharedPreferences sharedPreferences=context.getSharedPreferences("sp",0);
        sharedPreferences.edit().putString("ProductBean",new Gson().toJson(bean)).commit();
    }
}

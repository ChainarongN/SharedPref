package com.example.ngz.quiz1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


public class Process {
    private final String Key_user = "key";

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    public Process(Context context){

        sharedPref = context.getSharedPreferences("NGz",Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public boolean CheckLogin(String text){

        String text1 = sharedPref.getString(Key_user,"");

        if(text.equals(text1)){
            return true;
        }
        return false;
    }

    public boolean Register(String text){

        editor.putString(Key_user,text);
        return editor.commit();

    }
}

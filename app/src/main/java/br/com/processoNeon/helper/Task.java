package br.com.processoNeon.helper;

import android.app.ProgressDialog;
import android.content.Context;

import java.util.Map;

/**
 * Created by Moisés on 07/08/2016.
 */
public abstract class Task {

    protected String mURL;
    protected AppHTTP conn;
    protected Map<String, String> params;

    protected Context mContext;
    protected ProgressDialog mProgress;

    public Task(Context context){
        this.mContext = context;
    }




}

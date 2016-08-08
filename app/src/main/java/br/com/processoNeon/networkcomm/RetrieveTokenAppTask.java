package br.com.processoNeon.networkcomm;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.HashMap;

import br.com.processoNeon.helper.AppHTTP;
import br.com.processoNeon.helper.Task;
import br.com.processoNeon.system.ApplicationInit;

/**
 * Created by Moisés on 07/08/2016.
 */
public class RetrieveTokenAppTask extends Task{

    public RetrieveTokenAppTask(Context context) {
        super(context);
    }

    public class MyToken extends AsyncTask <Object, Void, String>{

        @Override
        protected String doInBackground(Object... objects) {
            if(isCancelled()) {
                return null;
            }
            params = new HashMap<String, String>();
            params.put("nome",ApplicationInit.sNome);
            params.put("email",ApplicationInit.sEmail);
            conn = new AppHTTP();

            try {
                ApplicationInit.sToken = conn.connect(AppHTTP.GET,ApplicationInit.sURLtoken,params);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

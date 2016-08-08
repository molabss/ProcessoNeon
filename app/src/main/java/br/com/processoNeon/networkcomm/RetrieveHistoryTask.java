package br.com.processoNeon.networkcomm;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import br.com.processoNeon.R;
import br.com.processoNeon.helper.AppHTTP;
import br.com.processoNeon.helper.AsyncResponse;
import br.com.processoNeon.helper.NeonRESTParamsWrapper;
import br.com.processoNeon.helper.Task;
import br.com.processoNeon.model.ContactHistory;


/**
 * Created by Moisés on 07/08/2016.
 */

public class RetrieveHistoryTask  extends Task{

    private NeonRESTParamsWrapper mWrapper;
    public List<ContactHistory> listHist;

    public RetrieveHistoryTask(Context context) {
        super(context);
    }

    public class GetHistory extends AsyncTask<Object, String, List<ContactHistory>>{
        public AsyncResponse delegate = null;

        @Override
           protected List<ContactHistory> doInBackground(Object... objects) {
               mWrapper = (NeonRESTParamsWrapper)objects[0];
               params = new HashMap<String,String>();
               params.put("token",mWrapper.getToken());

              try {
                  conn = new AppHTTP();
                  listHist = conn.connectTestNeon(AppHTTP.GET,mWrapper.getUrl(),params);

               } catch (IOException e) {
                   e.printStackTrace();

                  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                  dialog.setMessage(mContext.getResources().getString(R.string.errorGetHistory));
                  dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface di, int arg) {
                          di.dismiss();
                      }
                  });
                  dialog.setTitle(mContext.getResources().getString(R.string.warning));
                  dialog.show();
               }
               return listHist;
           }

        @Override
        protected void onPostExecute(List<ContactHistory> l) {
            super.onPostExecute(l);
            delegate.processFinish(l);
        }

       @Override
       protected void onPreExecute() {
            super.onPreExecute();
        }

       @Override
       protected void onProgressUpdate(String... values) {
           super.onProgressUpdate(values);
       }

       @Override
       protected void onCancelled() {
           super.onCancelled();
       }
       }
}

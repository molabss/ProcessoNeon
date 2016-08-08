package br.com.processoNeon.networkcomm;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import java.io.IOException;
import java.util.HashMap;

import br.com.processoNeon.R;
import br.com.processoNeon.helper.AppHTTP;
import br.com.processoNeon.helper.NeonRESTParamsWrapper;
import br.com.processoNeon.helper.Task;

/**
 * Created by casa on 07/08/2016.
 */
public class SendMoneyTask extends Task {

    private boolean mRetorno = false;
    private static final int PROGRESS_INCREMENT = 50;
    private NeonRESTParamsWrapper mWrapper;

    public SendMoneyTask(Context context) {
        super(context);
    }
                              //PARAMETRO - PROGRESSO - RESULTADO
    public class Send extends AsyncTask<Object, String, Void> {

        @Override
        protected Void doInBackground(Object... objects) {

            if(isCancelled()) {
                return null;
            }
            mWrapper = (NeonRESTParamsWrapper)objects[0];
            params = new HashMap<String, String>();
            params.put("clientID",mWrapper.getClientID());
            params.put("token",mWrapper.getToken());
            params.put("valor",mWrapper.getValor());
            conn = new AppHTTP();

            try {
                addProgress(mContext.getResources().getString(R.string.sendingValue));
                mRetorno = Boolean.parseBoolean(conn.connect(AppHTTP.POST,mWrapper.getUrl(),params));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            mProgress.setMessage(values[1]);
            mProgress.setProgress(Integer.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mProgress.dismiss();
            String msg = "";
            if(mRetorno){
                msg= mContext.getResources().getString(R.string.successSendValue);
            }else{
                msg= mContext.getResources().getString(R.string.failSendValue);
            }
            AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
            dialog.setMessage(msg);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface di, int arg) {
                    di.dismiss();
                }
            });
            dialog.setTitle(mContext.getResources().getString(R.string.warning));
            dialog.show();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgress = new ProgressDialog(mContext);
            mProgress.setTitle(mContext.getResources().getString(R.string.wait));
            mProgress.setMessage(mContext.getResources().getString(R.string.working));
            mProgress.setCancelable(false);
            mProgress.setIndeterminate(false);
            mProgress.setProgress(0);
            mProgress.setMax(100);
            mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgress.show();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        public void addProgress(String newMessage) {
            if(mProgress.getProgress() < mProgress.getMax()){
                publishProgress(String.valueOf(mProgress.getProgress()+PROGRESS_INCREMENT),newMessage);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

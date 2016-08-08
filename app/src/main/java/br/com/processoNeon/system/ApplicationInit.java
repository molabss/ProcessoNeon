package br.com.processoNeon.system;

import android.app.Application;

import br.com.processoNeon.networkcomm.RetrieveTokenAppTask;

/**
 * Created by Moisés on 07/08/2016.
 */
public class ApplicationInit  extends Application {

    public static String sToken ="";
    public static String sNome = "Moisés Santana";
    public static String sEmail = "ijkMoises@gmail.com";
    public static String sURLtoken = "http://processoseletivoneon.azurewebsites.net/GenerateToken";

    @Override
    public void onCreate() {
        super.onCreate();
        RetrieveTokenAppTask.MyToken task = new RetrieveTokenAppTask(this).new MyToken();
        task.execute();
    }
}

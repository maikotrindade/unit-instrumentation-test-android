package maikotrindade.com.br.unitinstrumentationtests.util;

import android.app.Application;

import maikotrindade.com.br.unitinstrumentationtests.model.DatabaseHelper;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class AeaApplication extends Application {

    private static AeaApplication sInstance;
    private static DatabaseHelper sDatabaseHelper;


    public static synchronized AeaApplication getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public DatabaseHelper getDatabaseHelper() {
        if (sDatabaseHelper == null) {
            sDatabaseHelper = new DatabaseHelper(getApplicationContext());
        }
        return sDatabaseHelper;
    }


}

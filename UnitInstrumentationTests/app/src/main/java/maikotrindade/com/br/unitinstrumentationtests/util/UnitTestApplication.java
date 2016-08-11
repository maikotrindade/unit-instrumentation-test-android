package maikotrindade.com.br.unitinstrumentationtests.util;

import android.app.Application;

import maikotrindade.com.br.unitinstrumentationtests.model.DatabaseHelper;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class UnitTestApplication extends Application {

    private static UnitTestApplication sInstance;
    private static DatabaseHelper sDatabaseHelper;


    public static synchronized UnitTestApplication getInstance(){
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

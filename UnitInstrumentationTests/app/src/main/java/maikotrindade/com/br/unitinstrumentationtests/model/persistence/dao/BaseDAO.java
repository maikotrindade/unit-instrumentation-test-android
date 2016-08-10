package maikotrindade.com.br.unitinstrumentationtests.model.persistence.dao;

import android.database.sqlite.SQLiteDatabase;

import maikotrindade.com.br.unitinstrumentationtests.model.DatabaseHelper;
import maikotrindade.com.br.unitinstrumentationtests.util.AeaApplication;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class BaseDAO {

    protected SQLiteDatabase database;
    private static BaseDAO sDAOInstance;


    public BaseDAO(){
        DatabaseHelper databaseHelper = AeaApplication.getInstance().getDatabaseHelper();
        if(database == null){
            database = databaseHelper.getWritableDatabase();
        }
    }

    public static BaseDAO getInstance(){
        if(sDAOInstance == null){
            sDAOInstance = new BaseDAO();
        }
        return sDAOInstance;
    }
}

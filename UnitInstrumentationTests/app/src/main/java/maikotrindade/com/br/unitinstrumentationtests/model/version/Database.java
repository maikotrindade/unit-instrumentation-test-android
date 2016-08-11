package maikotrindade.com.br.unitinstrumentationtests.model.version;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public interface Database {

    String CREATE_USER_TB =
            "CREATE TABLE "+ DatabaseContract.Tables.USER_TB + " ( "+
//                    DatabaseContract.UserTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
//                    DatabaseContract.UserTable.COLUMN_LOGIN + " TEXT NOT NULL, "+
                    DatabaseContract.UserTable.COLUMN_NAME + " TEXT " +
//                    DatabaseContract.UserTable.COLUMN_COMPANY + " TEXT, "+
//                    DatabaseContract.UserTable.COLUMN_LOCATION + " TEXT, "+
//                    DatabaseContract.UserTable.COLUMN_EMAIL + " TEXT NOT NULL, "+
//                    DatabaseContract.UserTable.COLUMN_TIME_CREATED + " TEXT, "+
//                    DatabaseContract.UserTable.COLUMN_TIME_UPDATED + " TEXT " +
                    ")";

}

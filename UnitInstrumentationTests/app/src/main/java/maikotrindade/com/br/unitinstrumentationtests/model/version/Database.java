package maikotrindade.com.br.unitinstrumentationtests.model.version;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public interface Database {

    String CREATE_USER_TB = "CREATE TABLE " + DatabaseContract.Tables.USER_TB + " ( " +
            DatabaseContract.UserTable.COLUMN_ID + " INTEGER PRIMARY KEY, " +
            DatabaseContract.UserTable.COLUMN_NAME + " TEXT NULL, " +
            DatabaseContract.UserTable.COLUMN_LOGIN + " TEXT NULL, " +
            DatabaseContract.UserTable.COLUMN_LOCATION + " TEXT NULL, " +
            DatabaseContract.UserTable.COLUMN_AVATAR_URL + " TEXT NULL)";
}
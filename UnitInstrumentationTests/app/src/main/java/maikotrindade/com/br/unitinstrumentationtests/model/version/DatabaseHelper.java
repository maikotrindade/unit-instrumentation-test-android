package maikotrindade.com.br.unitinstrumentationtests.model.version;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String name = "githubtest.db";
    public static final int version = 1;

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Database.CREATE_USER_TB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

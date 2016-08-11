package maikotrindade.com.br.unitinstrumentationtests.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.model.version.DatabaseContract;
import maikotrindade.com.br.unitinstrumentationtests.model.version.DatabaseHelper;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class UserDAO {

    private SQLiteDatabase database;

    public UserDAO(Context context){
        database = (new DatabaseHelper(context)).getWritableDatabase();
    }


    public long insert(final User user){

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.UserTable.COLUMN_ID, user.getId());
        values.put(DatabaseContract.UserTable.COLUMN_LOGIN, user.getLogin());
        values.put(DatabaseContract.UserTable.COLUMN_NAME, user.getName());
        values.put(DatabaseContract.UserTable.COLUMN_EMAIL, user.getEmail());
        values.put(DatabaseContract.UserTable.COLUMN_COMPANY, user.getCompany());
        values.put(DatabaseContract.UserTable.COLUMN_LOCATION, user.getLocation());
        values.put(DatabaseContract.UserTable.COLUMN_TIME_CREATED, user.getTimeCreated());
        values.put(DatabaseContract.UserTable.COLUMN_TIME_UPDATED, user.getTimeUpdated());
        long localUserId = database.insertOrThrow(DatabaseContract.Tables.USER_TB, null, values);
        return localUserId;
    }


    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        Cursor cursor = database.query(DatabaseContract.Tables.USER_TB,
                DatabaseContract.UserTable.projection, null, null, null, null, null);

        if(cursor != null && cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                User user = cursorToUser(cursor);
                users.add(user);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return users;
    }


    private User cursorToUser(Cursor cursor){
        User user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_ID)));
        user.setLogin(cursor.getString(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_LOGIN)));
        user.setName(cursor.getString(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_NAME)));
        user.setEmail(cursor.getString(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_EMAIL)));
        user.setCompany(cursor.getString(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_COMPANY)));
        user.setLocation(cursor.getString(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_LOCATION)));
        user.setTimeCreated(cursor.getString(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_TIME_CREATED)));
        user.setTimeUpdated(cursor.getString(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_TIME_UPDATED)));
        return user;
    }



}

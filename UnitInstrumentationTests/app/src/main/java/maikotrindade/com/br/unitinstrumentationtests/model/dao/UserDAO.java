package maikotrindade.com.br.unitinstrumentationtests.model.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.model.version.DatabaseContract;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class UserDAO {

    private SQLiteDatabase database;

    public UserDAO(SQLiteDatabase database) {
        this.database = database;
    }


    public long insert(final User user) {

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.UserTable.COLUMN_ID, user.getId());
        values.put(DatabaseContract.UserTable.COLUMN_NAME, user.getName());
        values.put(DatabaseContract.UserTable.COLUMN_LOGIN, user.getLogin());
        values.put(DatabaseContract.UserTable.COLUMN_LOCATION, user.getLocation());
        values.put(DatabaseContract.UserTable.COLUMN_AVATAR_URL, user.getAvatarUrl());
        long localUserId = database.insertOrThrow(DatabaseContract.Tables.USER_TB, null, values);
        return localUserId;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Cursor cursor = database.query(DatabaseContract.Tables.USER_TB,
                DatabaseContract.UserTable.projection, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                User user = cursorToUser(cursor);
                users.add(user);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return users;
    }

    private User cursorToUser(Cursor cursor) {
        User user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_ID)));
        user.setName(cursor.getString(
                cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_NAME)));
        user.setLogin(cursor.getString(
                        cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_LOGIN)));
        user.setLocation(cursor.getString(
                cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_LOCATION)));
        user.setAvatarUrl(cursor.getString(
                cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_AVATAR_URL)));
        user.setLocation(cursor.getString(
                cursor.getColumnIndex(DatabaseContract.UserTable.COLUMN_LOCATION)));

        return user;
    }


}

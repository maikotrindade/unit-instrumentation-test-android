package maikotrindade.com.br.unitinstrumentationtests.model.version;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class DatabaseContract {

    public interface Tables {
        String USER_TB = "user_tb";
    }

    public interface UserTable {
        String COLUMN_ID = "user_id";
        String COLUMN_NAME = "user_name";
        String COLUMN_LOGIN = "user_login";
        String COLUMN_LOCATION = "user_location";
        String COLUMN_AVATAR_URL = "user_avatar_url";

        String[] projection = {
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_LOGIN,
                COLUMN_LOCATION,
                COLUMN_AVATAR_URL
        };
    }
}

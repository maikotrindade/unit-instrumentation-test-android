package maikotrindade.com.br.unitinstrumentationtests.model.persistence.version;

/**
 * Created by ricardo.sgobbe on 10/08/2016.
 */
public class DatabaseContract {

    public interface Tables{
        String USER_TB = "user_tb";
    }


    public interface UserTable{
        String COLUMN_LOGIN = "user_login";
        String COLUMN_ID = "user_id";
        String COLUMN_NAME = "user_name";
        String COLUMN_COMPANY = "user_company";
        String COLUMN_LOCATION = "user_location";
        String COLUMN_EMAIL = "user_email";
        String COLUMN_TIME_CREATED = "user_created_at";
        String COLUMN_TIME_UPDATED = "user_updated_at";

        String[] projection = {
                COLUMN_ID,
                COLUMN_LOGIN,
                COLUMN_NAME,
                COLUMN_COMPANY,
                COLUMN_LOCATION,
                COLUMN_EMAIL,
                COLUMN_TIME_CREATED,
                COLUMN_TIME_UPDATED
        };
    }
}

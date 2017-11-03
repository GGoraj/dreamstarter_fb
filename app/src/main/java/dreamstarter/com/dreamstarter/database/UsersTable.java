package dreamstarter.com.dreamstarter.database;

/**
 * Created by q on 5/5/17.
 */

public class UsersTable {

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_USER_FIRST_NAME = "userFirstName";
    public static final String COLUMN_USER_LAST_NAME = "userLastName";
    public static final String COLUMN_USER_LOGIN = "userLogin";
    public static final String COLUMN_USER_PASSWORD = "userPassword";
    public static final String COLUMN_USER_PHOTO = "userPhoto";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_USERS + "(" +
                    COLUMN_USER_ID + " TEXT PRIMARY KEY," +
                    COLUMN_USER_FIRST_NAME + " TEXT," +
                    COLUMN_USER_LAST_NAME + " TEXT," +
                    COLUMN_USER_LOGIN + " TEXT," +
                    COLUMN_USER_PASSWORD + " TEXT," +
                    COLUMN_USER_PHOTO + " TEXT" + ");";

    public static final String[] ALL_COLUMNS = {
            COLUMN_USER_ID, COLUMN_USER_FIRST_NAME,
            COLUMN_USER_LAST_NAME, COLUMN_USER_LOGIN,
            COLUMN_USER_PASSWORD, COLUMN_USER_PHOTO};

    public static final String SQL_DELETE_USERS =
            "DROP TABLE " + TABLE_USERS;


    //Used to verify if user exists in the database
    public static final String[] ALL_LOGINS = {
            COLUMN_USER_LOGIN
    };

}

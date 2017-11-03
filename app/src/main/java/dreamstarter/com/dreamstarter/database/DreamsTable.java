package dreamstarter.com.dreamstarter.database;


public class DreamsTable {

    public static final String TABLE_DREAMS = "dreams";
    public static final String COLUMN_DREAM_ID = "dreamId";
    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_PRODUCT_ID = "productId";
    public static final String COLUMN_DREAM_ETA = "dreamEta";


    public static final String[] ALL_DREAMS = {COLUMN_DREAM_ID, COLUMN_USER_ID, COLUMN_PRODUCT_ID, COLUMN_DREAM_ETA};


    /**
     *  Method used by DBHelper class
     *  SQLiteDatabase.execSql() method takes it as a parameter
     *  to produce a query
     */
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_DREAMS + "(" +
                    COLUMN_DREAM_ID + " TEXT PRIMARY KEY," +
                    COLUMN_USER_ID + " TEXT," +
                    COLUMN_PRODUCT_ID + " TEXT," +
                    COLUMN_DREAM_ETA + " TEXT" + ");";

    public static final String SQL_DELETE_DREAMS = "DROP TABLE " + TABLE_DREAMS;



}
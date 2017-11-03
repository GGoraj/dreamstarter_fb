package dreamstarter.com.dreamstarter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * the whole process of managing these methods is done 'by the framework'
 */
public class DBHelper extends SQLiteOpenHelper {


    public static final String DB_FILE_NAME = "dreamstarter.db";
    public static final int DB_VERSION = 1;


    /**
     * Constructor
     */
    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION); // null -- no factory
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DreamsTable.SQL_CREATE);
        db.execSQL(UsersTable.SQL_CREATE);
        db.execSQL(ProductsTable.SQL_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // after changes I increment db version to '2',
        //first time the user opens the new version of the app - onUpgrade method
        //if I want to upgrade the database I have to dump database to f.ex. json file,
        //then drop the tables and recreate Database from that json file
        // .....   and I would do that here, in this onUpgrade method at once.


        //here I DROP the table from database and create new one :
        db.execSQL(ProductsTable.SQL_DELETE_PRODUCTS);
        db.execSQL(UsersTable.SQL_DELETE_USERS);
        db.execSQL(DreamsTable.SQL_DELETE_DREAMS);

        onCreate(db);

    }
}

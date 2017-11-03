package dreamstarter.com.dreamstarter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dreamstarter.com.dreamstarter.model.Dream;
import dreamstarter.com.dreamstarter.model.Product;
import dreamstarter.com.dreamstarter.model.User;

import static dreamstarter.com.dreamstarter.database.ProductsTable.TABLE_PRODUCTS;
import static dreamstarter.com.dreamstarter.database.UsersTable.TABLE_USERS;

/**
 * Class acts as a layer between the Database and any other class
 * using database;
 * <p>
 * <Wrapper Class>
 * <p>
 * Each method that refers to Cursor - should ALWAYS close() it after use to prevent errors.
 */

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    private SQLiteOpenHelper mDbHelper; // m - member object of the class (private)


    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();

    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public boolean isDbOpen(){
        return mDatabase.isOpen();
    }


    /**
     * Seeding DataBase with 'defaultDataProvider' class content. // Temporarily
     */
    public void seedDbProductsTable(List<Product> productList) {


        for (Product item : productList) {

            try {
                createProduct(item);
                //if primary key value matches the key
                //that's already in the DB table, there is 'SQLiteConstraintException'
                //the insert error.

            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }
    }

    public void seedDbUsersTable(List<User> userList) {

        for (User u : userList) {

            try {
                createUser(u);

                //if primary key value matches the key
                //that's already in the DB table, there is 'SQLiteConstraintException'
                //the insert error.

            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        mDbHelper.close();
    }


    /**
     * I could implement these with SQL queres but Im exposed to typo errors,
     * and do that hard work by myself but... ;) why should I ?
     * Instead I'll use built-in methods of SDK
     * To do this I need an object derived from class 'ContentValues'
     * its like a Bundle - set of (key, value)
     * I take later that derived object and pass to one of the provided DB methods.
     * That simple. It generates well formed SQL statements automatically.
     */
    public Product createProduct(Product product) {

        //Cursor is equivalent of 'result set' in JDBC
        //Java Database Connectivity

        Cursor cursor = mDatabase.query(TABLE_PRODUCTS, ProductsTable.ALL_TITLES, null, null, null, null, null); //mDatabase.query returns a cursor from database /result set/
        //3rd argument - selection clause - is used to filter f.ex. by category.
        // checking if product already exists in database
        List<String> productTitles = new ArrayList<>();

        while (cursor.moveToNext()) {
            productTitles.add(cursor.getString(cursor.getColumnIndex(ProductsTable.COLUMN_PRODUCT_TITLE)));
        }

        if (!productTitles.contains(product.getProductTitle())) {

            ContentValues values = product.toValues();
            mDatabase.insert(TABLE_PRODUCTS, null, values);// it will do the insert and return to processing the rest of the code
            cursor.close();
            Log.d("Item: ", product.getProductTitle() + "      ********************* Added to database");
            return product;
        } else {
            Log.d("Item: ", product.getProductTitle() + "      *********************  exists already in database");
            cursor.close();

        }

        return null;
    }


    /**
     * Create User
     */
    public User createUser(User user) {

        //mDatabase.query returns a cursor from database
        Cursor cursor = mDatabase.query(TABLE_USERS, UsersTable.ALL_LOGINS, null, null, null, null, null);
        List<String> userLogins = new ArrayList<>();

        while (cursor.moveToNext()) {
            userLogins.add(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_USER_LOGIN)));
        }

        //checking if the user already exists in database
        if (!userLogins.contains(user.getUserLogin())) {

            ContentValues values = user.toValues();
            // it will do the insert and return to processing the rest of the code
            // if 2nd parameter is null - nullCollumnHack - wont insert empty values to columns.
            mDatabase.insert(TABLE_USERS, null, values);
            cursor.close();

            //user added to database
            return user;
        } else {
            // user already exists in database
            cursor.close();
        }
        return null;

    }


    public Dream createDream(Dream dream) {
        ContentValues values = dream.toValues();
        mDatabase.insert(DreamsTable.TABLE_DREAMS, null, values);// it will do the insert and return to processing the rest of the code

        return null;
    }


    /**
     * These methods retrieve PRODUCTS from Database
     */

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Cursor cursor = mDatabase.query(TABLE_PRODUCTS, ProductsTable.ALL_COLUMNS, null, null, null, null, ProductsTable.COLUMN_PRODUCT_TITLE); //mDatabase.query returns a cursor from database
        //Cursor is equvalent of 'result set' in JDBC
        //Java Database Connectivity

        //adding each retrieved product to products list
        while (cursor.moveToNext()) {
            Product product = new Product();
            product.setProductId(cursor.getString(cursor.getColumnIndex(ProductsTable.COLUMN_PRODUCT_ID)));
            product.setProductCategory(cursor.getString(cursor.getColumnIndex(ProductsTable.COLUMN_PRODUCT_CATEGORY)));
            product.setProductTitle(cursor.getString(cursor.getColumnIndex(ProductsTable.COLUMN_PRODUCT_TITLE)));
            product.setProductDescription(cursor.getString(cursor.getColumnIndex(ProductsTable.COLUMN_PRODUCT_DESCRIPTION)));
            product.setProductPrice(cursor.getDouble(cursor.getColumnIndex(ProductsTable.COLUMN_PRODUCT_PRICE)));
            product.setProductPhoto(cursor.getString(cursor.getColumnIndex(ProductsTable.COLUMN_PRODUCT_PHOTO)));


            products.add(product);
        }


        cursor.close();
        return products;
    }


    /**
     * This method will return 'Null' if authentication failed and
     * a 'User' object if it succeeded.
     * <p>
     * User built of (userId, Name, Login, Photo)
     */

    public User authenticateUser(String etLoginString, String etPasswordString) {

        User user = null;


        // Null values won't be considered in the authentication process
        if (!etLoginString.equals("") && !etPasswordString.equals("")) { // improve that condition!!

            //mDatabase.query returns a cursor from database
            //Cursor is equvalent of 'result set' in JDBC
            //Java Database Connectivity
            Cursor cursorLogin = mDatabase.query(TABLE_USERS, UsersTable.ALL_LOGINS, null, null, null, null, null);

            List<String> userLogins = new ArrayList<>();
            while (cursorLogin.moveToNext()) {
                userLogins.add(cursorLogin.getString(cursorLogin.getColumnIndex(UsersTable.COLUMN_USER_LOGIN)));
            }
            cursorLogin.close();

            if (userLogins.contains(etLoginString)) {

                Cursor usersCursor = mDatabase.query(TABLE_USERS, UsersTable.ALL_COLUMNS, null, null, null, null, null);

                //iterating over users table
                while (usersCursor.moveToNext()) {
                    String login = usersCursor.getString(usersCursor.getColumnIndex(UsersTable.COLUMN_USER_LOGIN));
                    String password = usersCursor.getString(usersCursor.getColumnIndex(UsersTable.COLUMN_USER_PASSWORD));

                    if (login.equals(etLoginString) && password.equals(etPasswordString)) {
                        //good
                        String firstName = usersCursor.getString(usersCursor.getColumnIndex(UsersTable.COLUMN_USER_FIRST_NAME));
                        String photo = usersCursor.getString(usersCursor.getColumnIndex(UsersTable.COLUMN_USER_PHOTO));

                        user = new User();
                        user.setUserLogin(login);
                        user.setUserFirstName(firstName);
                        user.setUserPhoto(photo);
                        return user;
                    }
                    //else - continue looping
                }
            }
        }

        return user;
    }


}

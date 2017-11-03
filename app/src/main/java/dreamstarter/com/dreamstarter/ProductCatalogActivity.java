package dreamstarter.com.dreamstarter;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import dreamstarter.com.dreamstarter.customTools.ProductListAdapter;
import dreamstarter.com.dreamstarter.database.DataSource;
import dreamstarter.com.dreamstarter.defaultDataProvider.DefaultProductDataProvider;
import dreamstarter.com.dreamstarter.defaultDataProvider.DefaultUserDataProvider;
import dreamstarter.com.dreamstarter.model.Product;
import dreamstarter.com.dreamstarter.model.User;


public class ProductCatalogActivity extends AppCompatActivity {

    // contains all the operations on database + opens connection to DB
    private DataSource dataSource;
    private List<Product> productsFromDb;
    /**
     * Seeding Database - Temporary Solution
     */
    private List<Product> productList = DefaultProductDataProvider.defaultProductList;
    private List<User> userList = DefaultUserDataProvider.defaultUserList;

    /**
     * Create
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalog);

        /**
         *  Getting writable database object
         */
        dataSource = new DataSource(this); // at this point database is OPENED
        Toast.makeText(this, "Database connection acquired!", Toast.LENGTH_SHORT).show();

        /**
         * Seeding database users + products
         */
        dataSource.seedDbProductsTable(productList);
        dataSource.seedDbUsersTable(userList);

        /**
         * Getting List of Products from Database
         */
        productsFromDb = dataSource.getAllProducts();

        /**
         *   Recycler view block:
         *   Displaying Products in RecyclerView
         */

        ProductListAdapter productListAdapter = new ProductListAdapter(productsFromDb, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItem);
        recyclerView.setAdapter(productListAdapter);
    }


    /**
     *  Managing Database connection
     *  Accordingly to Activity Lifecycle:
     */
    @Override
    protected void onPause() {
        super.onPause();
        dataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataSource = new DataSource(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        dataSource.close();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        dataSource = new DataSource(this);
    }
}
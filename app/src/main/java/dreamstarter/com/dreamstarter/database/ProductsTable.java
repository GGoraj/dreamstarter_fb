package dreamstarter.com.dreamstarter.database;


public class ProductsTable {

    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_PRODUCT_ID = "productId";
    public static final String COLUMN_PRODUCT_TITLE = "productTitle";
    public static final String COLUMN_PRODUCT_CATEGORY = "productCategory";
    public static final String COLUMN_PRODUCT_DESCRIPTION = "productDescription";
    public static final String COLUMN_PRODUCT_PHOTO = "productPhoto";
    public static final String COLUMN_PRODUCT_PRICE = "productPrice";

    public static final String[] ALL_COLUMNS = {
            COLUMN_PRODUCT_ID, COLUMN_PRODUCT_TITLE,
            COLUMN_PRODUCT_CATEGORY, COLUMN_PRODUCT_DESCRIPTION,
            COLUMN_PRODUCT_PHOTO, COLUMN_PRODUCT_PRICE
    };

    public static final String[] ALL_TITLES = {
            COLUMN_PRODUCT_TITLE
    };

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                    COLUMN_PRODUCT_ID + " TEXT PRIMARY KEY," +
                    COLUMN_PRODUCT_TITLE + " TEXT," +
                    COLUMN_PRODUCT_CATEGORY + " TEXT," +
                    COLUMN_PRODUCT_DESCRIPTION + " TEXT," +
                    COLUMN_PRODUCT_PHOTO + " TEXT," +
                    COLUMN_PRODUCT_PRICE + " TEXT" + ");";

    public static final String SQL_DELETE_PRODUCTS = "DROP TABLE " + TABLE_PRODUCTS;

}

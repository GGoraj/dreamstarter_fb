package dreamstarter.com.dreamstarter.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import dreamstarter.com.dreamstarter.database.ProductsTable;


/**
 * Class implements Parcelable because -
 */
public class Product implements Parcelable {

    /**
     * Private Class Members
     */
    private String productId;
    private String productCategory;
    private String productTitle;
    private String productDescription;
    private String productPhoto;
    private Double productPrice;


    /**
     * Empty Constructor for use in DataSource class
     */
    public Product() {
        // Helpful while retrieving object in database --> look to getAll() in DataSource
    }


    /**
     * CONSTRUCTOR
     */
    public Product(String productId, String productCategory, String productTitle,
                   String productDescription, String productPhoto, Double productPrice) {

        //setting up and item Id.
        if (productId == null) {

            //UUID
            //Universally Unique identifier
            productId = UUID.randomUUID().toString();
        }

        this.productId = productId;
        this.productCategory = productCategory;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPhoto = productPhoto;
        this.productPrice = productPrice;
    }


    /**
     * Product constructor for Parcelable interface
     */
    protected Product(Parcel in) {
        productId = in.readString();
        productCategory = in.readString();
        productTitle = in.readString();
        productDescription = in.readString();
        productPhoto = in.readString();
        productPrice = in.readDouble();
    }


    /**
     * CREATOR and parcelable interface methods:
     * CREATOR field generates instances of Parcelable class from a Parcel.
     *
     */
    public static final Creator<Product> CREATOR = new Creator<Product>() {
        /**
         *  Returns a new instance of the Parcelable class. That was previously saved to parcel.
         */
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;   // default = 0
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeString(productCategory);
        dest.writeString(productTitle);
        dest.writeString(productDescription);
        dest.writeString(productPhoto);
        dest.writeDouble(productPrice);

    }


    /**
     * SQLiteDB object accepts ContentValues in order to generate and send queries to DB
     */
    public ContentValues toValues() {
        ContentValues values = new ContentValues(4); // numeric value for size of the values object (7 columns of database table in this case..
        values.put(ProductsTable.COLUMN_PRODUCT_ID, productId);
        values.put(ProductsTable.COLUMN_PRODUCT_CATEGORY, productCategory);
        values.put(ProductsTable.COLUMN_PRODUCT_TITLE, productTitle);
        values.put(ProductsTable.COLUMN_PRODUCT_DESCRIPTION, productDescription);
        values.put(ProductsTable.COLUMN_PRODUCT_PHOTO, productPhoto);
        values.put(ProductsTable.COLUMN_PRODUCT_PRICE, productPrice);

        return values;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPhoto='" + productPhoto + '\'' +
                '}';
    }



    /**
     * GETTERS SETTERS
     */
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }


    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}

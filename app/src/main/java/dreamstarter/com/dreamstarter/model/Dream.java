package dreamstarter.com.dreamstarter.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import dreamstarter.com.dreamstarter.database.DreamsTable;
import dreamstarter.com.dreamstarter.database.ProductsTable;

/**
 * Created by q on 5/5/17.
 */

public class Dream implements Parcelable {

    /**
     * Private Class Members
     */
    private String dreamId;
    private String userId;
    private String productId;
    private String dreamEta;


    /**
     * CONSTRUCTOR
     */

    public Dream(String dreamId, String userId, String productId) {

        if (dreamId == null) {

            //UUID
            //Universally unique identifier
            dreamId = UUID.randomUUID().toString();
        }

        this.dreamId = dreamId;
        this.userId = userId;
        this.productId = productId;
        this.dreamEta = null;
    }


    /**
     * Constructor for Parcelable interface
     */

    protected Dream(Parcel in) {
        dreamId = in.readString();
        userId = in.readString();
        productId = in.readString();
        dreamEta = in.readString();
    }


    public static final Creator<Dream> CREATOR = new Creator<Dream>() {
        @Override
        public Dream createFromParcel(Parcel in) {
            return new Dream(in);
        }

        @Override
        public Dream[] newArray(int size) {
            return new Dream[size];
        }
    };


    public String getDreamId() {
        return dreamId;
    }

    public void setDreamId(String dreamId) {
        this.dreamId = dreamId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDreamEta() {
        return dreamEta;
    }

    public void setDreamEta(String dreamEta) {
        this.dreamEta = dreamEta;
    }

    public static Creator<Dream> getCREATOR() {
        return CREATOR;
    }

    /**
     *  method gathers Tables Column Names and puts it into ContentValues bundle.
     *  to be inserted into Database in class DataSource
     */
    public ContentValues toValues() {
        ContentValues values = new ContentValues(3); // numeric value for size of the values object (3 columns of database table in this case..
        values.put(DreamsTable.COLUMN_DREAM_ID, dreamId);
        values.put(DreamsTable.COLUMN_PRODUCT_ID, productId);
        values.put(DreamsTable.COLUMN_DREAM_ETA, dreamEta);

        return values;
    }


    /**
     * Interface Parcelable requires these 2 methods:
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dreamId);
        dest.writeString(productId);
        dest.writeString(dreamEta);
    }
}

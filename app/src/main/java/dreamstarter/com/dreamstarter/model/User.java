package dreamstarter.com.dreamstarter.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import dreamstarter.com.dreamstarter.database.UsersTable;

/**
 * Created by q on 5/5/17.
 */

public class User implements Parcelable {

    /**
     * Private Class Members
     */
    private String userId;
    private String userFirstName;
    private String userLastName;
    private String userLogin;
    private String userPassword;
    private String userPhoto;


    /**
     * Constructor
     */
    public User(String userId, String userFirstName, String userLastName,
                String userLogin, String userPassword, String userPhoto) {


        if (userId == null) {
            //UUID
            //Universally unique identifier
            userId = UUID.randomUUID().toString();
        }

        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userPhoto = userPhoto;
    }


    protected User(Parcel in) {
        userId = in.readString();
        userFirstName = in.readString();
        userLastName = in.readString();
        userLogin = in.readString();
        userPassword = in.readString();
        userPhoto = in.readString();
    }


    public User() {
        //Constructor 2 - used in login/password authentication
    }


    /**
     * Methods of Parcelable interface
     */

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    /**
     * Getter & Setters
     */

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }


    /**
     * Content Values are passed
     */
    public ContentValues toValues() {
        ContentValues values = new ContentValues(6); // numeric value for size of the values object (6 columns of database table in this case..
        values.put(UsersTable.COLUMN_USER_ID, userId);
        values.put(UsersTable.COLUMN_USER_FIRST_NAME, userFirstName);
        values.put(UsersTable.COLUMN_USER_LAST_NAME, userLastName);
        values.put(UsersTable.COLUMN_USER_LOGIN, userLogin);
        values.put(UsersTable.COLUMN_USER_PASSWORD, userPassword);
        values.put(UsersTable.COLUMN_USER_PHOTO, userPhoto);
        return values;
    }


    /**
     * Methods Required by Implemented Interface: PARCELABLE
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.userFirstName);
        dest.writeString(this.userLastName);
        dest.writeString(this.userLogin);
        dest.writeString(this.userPassword);
        dest.writeString(this.userPhoto);

    }
}

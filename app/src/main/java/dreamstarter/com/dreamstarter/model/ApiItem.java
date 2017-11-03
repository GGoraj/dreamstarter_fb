package dreamstarter.com.dreamstarter.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by q on 10/30/17.
 */

public class ApiItem implements Parcelable {

        private String itemName;
        private String category;
        private String description;
        private int sort;
        private Double price;
        private String image;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemName);
        dest.writeString(this.category);
        dest.writeString(this.description);
        dest.writeInt(this.sort);
        dest.writeValue(this.price);
        dest.writeString(this.image);
    }

    public ApiItem() {
    }

    protected ApiItem(Parcel in) {
        this.itemName = in.readString();
        this.category = in.readString();
        this.description = in.readString();
        this.sort = in.readInt();
        this.price = (Double) in.readValue(Double.class.getClassLoader());
        this.image = in.readString();
    }

    public static final Parcelable.Creator<ApiItem> CREATOR = new Parcelable.Creator<ApiItem>() {
        @Override
        public ApiItem createFromParcel(Parcel source) {
            return new ApiItem(source);
        }

        @Override
        public ApiItem[] newArray(int size) {
            return new ApiItem[size];
        }
    };
}

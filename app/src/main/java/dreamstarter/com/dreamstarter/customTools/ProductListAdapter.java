package dreamstarter.com.dreamstarter.customTools;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import dreamstarter.com.dreamstarter.ProductDetailsActivity;
import dreamstarter.com.dreamstarter.R;
import dreamstarter.com.dreamstarter.model.Product;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {


    public static final String ITEM_KEY = "product_key";
    private List<Product> productList;
    private Context mContext;
    //Context -
    // Interface to global information about an application environment.
    // This is an abstract class whose implementation is provided by the Android system.
    // It allows access to application-specific resources and classes,
    // as well as up-calls for application-level operations such as launching activities, broadcasting and receiving intents, etc.


    /**
     * CONSTRUCTOR
     *
     */
    public ProductListAdapter(List<Product> productList, Context mContext) {
        this.productList = productList;
        this.mContext = mContext;
    }


    /**
     * onCreateViewHolder - is called by the adapter each time when it needs visual representation of the 'Product'
     */
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.recycler_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }


    /**
     * onBindViewHolder is called each time the adapter encounter a new Product that it needs to display in this case - Photo
     * Event handlers - set up here
     * Data to display to user - set up here
     *
     * holder - The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     *  position - The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ProductListAdapter.ViewHolder holder, int position) {
        final Product item = productList.get(position);

        try {
            holder.tvTitle.setText(item.getProductTitle());  // Im referring to the view holder here to get reference of the layout file component
            String imageFile = item.getProductPhoto();
            InputStream inputStream = mContext.getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * Passing chosen item in intent extra - thx to Parcelable interface implemented in its model - yey!
                 */
                Intent intent = new Intent(mContext, ProductDetailsActivity.class);
                intent.putExtra(ITEM_KEY, item);
                mContext.startActivity(intent);
                //Toast.makeText(mContext, "You selected" + item.getProductTitle() + "details", Toast.LENGTH_SHORT).show();
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(mContext, item.getProductTitle() + " loooooooong Clicked!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    /**
     * getItemCount returns number of product in the productList

     */
    @Override
    public int getItemCount() {
        return productList.size();
    }


    /**
     * This inner class is responsible for the bindings to XML layout file.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public ImageView imageView;

        //mView class member represents our itemView. we bind it in Constructor
        //so we can set on click listener on the dataItem element (productView)
        public View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.textViewCustom);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewCustom);
            mView = itemView;
        }
    }
}

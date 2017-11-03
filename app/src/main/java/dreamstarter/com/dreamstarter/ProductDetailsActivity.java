package dreamstarter.com.dreamstarter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import dreamstarter.com.dreamstarter.customTools.ImagePrinter;
import dreamstarter.com.dreamstarter.customTools.ProductListAdapter;
import dreamstarter.com.dreamstarter.model.Product;

/**
 * Not interacting with Database here
 * Using Parcelable object from ProductCatalog
 * Layout: PercentRelativeLayout - Embedded ScrollView Container
 */


public class ProductDetailsActivity extends AppCompatActivity {

    private TextView tvName, tvPrice, scrollViewContent;
    private ImageView imageView;
    private String imageFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        //getting the Product object out of the intent/extras/parcelable
        final Product product = getIntent().getExtras().getParcelable(ProductListAdapter.ITEM_KEY);
        if (product == null) {
            throw new AssertionError("Null data item received!"); // that should never happen - assertion // vs // exception - it might happen
        }

        tvName = (TextView) findViewById(R.id.tvItemName);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        imageView = (ImageView) findViewById(R.id.ivProductDetails);
        tvName.setText(product.getProductTitle());
        scrollViewContent = (TextView) findViewById(R.id.scrollViewContent);
        scrollViewContent.setText(product.getProductDescription());

        //NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault()); no Danish implementation
        tvPrice.setText(product.getProductPrice().toString() + "Dkk");

        imageFile = product.getProductPhoto();
        ImagePrinter.printImage(this, imageFile, imageView);


        /**
         *  Button Dream
         */

        Button dreamBtn = (Button) findViewById(R.id.btnDream);
        dreamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Passing ProductName to assign it to the basket
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("chosenProductName", product.getProductTitle());
                startActivity(intent);

            }
        });
    }


}

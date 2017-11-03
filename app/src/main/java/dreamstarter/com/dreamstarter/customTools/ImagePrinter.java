package dreamstarter.com.dreamstarter.customTools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by q on 6/9/17.
 */

public class ImagePrinter {

    /**
     *  Profile Picture Printer
     *
     *  Parameters:
     *   context -class context
     *  imageFileName - name of the file containing image
     *  imageView - ImageView object - layout
     *
     */

    public static void printImage(Context context, String imageFileName, ImageView imageView) {

        InputStream inputStream = null;
        try {
            String imageFile = imageFileName;
            inputStream = context.getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}

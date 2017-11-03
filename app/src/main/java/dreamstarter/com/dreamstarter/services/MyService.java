package dreamstarter.com.dreamstarter.services;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import dreamstarter.com.dreamstarter.model.ApiItem;
import dreamstarter.com.dreamstarter.utils.HttpHelper;

public class MyService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor
     */
    public static final String TAG = "MyService";

    public MyService() {
        super("MyService");
    }

    public static final String MY_SERVICE_MESSAGE = "myServiceMessage";
    public static final String MY_SERVICE_PAYLOAD = "myServicePayload";

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Uri uri = intent.getData();
        Log.i(TAG, "onHandleIntent: " + uri.toString());



        String response = null;
        try {
            response =
                    HttpHelper.downloadUrl(uri.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        ApiItem[] apiItems = gson.fromJson(response, ApiItem[].class);


        Intent messageIntent = new Intent(MY_SERVICE_MESSAGE);
        messageIntent.putExtra(MY_SERVICE_PAYLOAD, apiItems);

        LocalBroadcastManager manager =
                LocalBroadcastManager.getInstance(getApplicationContext());
        manager.sendBroadcast(messageIntent); // any service throughout the application can listen to it now*/

    }
}

package dreamstarter.com.dreamstarter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dreamstarter.com.dreamstarter.model.ApiItem;
import dreamstarter.com.dreamstarter.services.MyService;
import dreamstarter.com.dreamstarter.utils.NetworkHelper;

public class ApiActivity extends AppCompatActivity {

    private static final String JSON_URL = "http://560057.youcanlearnit.net/services/json/itemsfeed.php";
    private TextView apiOutput;
    private Button getApiButton;
    private Button clearButton;
    private boolean networkOk;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            ApiItem[] apiItems = (ApiItem[]) intent.getParcelableArrayExtra(MyService.MY_SERVICE_PAYLOAD);

            for (ApiItem item: apiItems
                 ) {
                apiOutput.append(item.getItemName() + "\n");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        apiOutput = (TextView) findViewById(R.id.api_textview);
        getApiButton = (Button) findViewById(R.id.api_button);
        clearButton = (Button) findViewById(R.id.clear_button);

        networkOk = NetworkHelper.hasNetworkAccess(this);
        Log.i("NetworkStatus", String.valueOf(networkOk));

        getApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.setData(Uri.parse(JSON_URL));
                startService(intent);

                LocalBroadcastManager.getInstance(getApplicationContext())
                        .registerReceiver(mBroadcastReceiver,
                                new IntentFilter(MyService.MY_SERVICE_MESSAGE));
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiOutput.setText("");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(mBroadcastReceiver);
    }














}

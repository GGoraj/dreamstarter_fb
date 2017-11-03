package dreamstarter.com.dreamstarter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

;import dreamstarter.com.dreamstarter.model.ApiItem;
import dreamstarter.com.dreamstarter.services.MyService;
import dreamstarter.com.dreamstarter.utils.NetworkHelper;

public class IntroductionActivity extends AppCompatActivity {

    private Button btnIntroduction;
    private boolean networkOK;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String message =
                    intent.getStringExtra(MyService.MY_SERVICE_PAYLOAD);
            System.out.println("MESSAGE PAYLOAD ************" + message + "\n");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        btnIntroduction = (Button) findViewById(R.id.btnIntroduction);
        btnIntroduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(), ProductCatalogActivity.class));
                startActivity(new Intent(getApplicationContext(), ApiActivity.class));
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

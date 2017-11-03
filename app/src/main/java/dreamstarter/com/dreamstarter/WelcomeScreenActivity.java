package dreamstarter.com.dreamstarter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        splashScreen();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        splashScreen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashScreen();
    }

    private void splashScreen() {
        /**
         * Splash screen thread
         */
        Thread thread = new Thread() {

            public void run() {
                try {
                    sleep(3000);
                    Intent toIntroduction = new Intent(getApplicationContext(), IntroductionActivity.class);
                    startActivity(toIntroduction);
                    //finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }


}

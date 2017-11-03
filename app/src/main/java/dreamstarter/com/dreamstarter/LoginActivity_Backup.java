package dreamstarter.com.dreamstarter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dreamstarter.com.dreamstarter.database.DataSource;
import dreamstarter.com.dreamstarter.model.User;

public class LoginActivity_Backup extends AppCompatActivity {

    public static String MY_GLOBAL_PREFS = "default_prefs"; // required for Shared Prefs to remind of users Login
    private String authUserId;
    private String authPhoto;
    private String authUserName;
    private String authLogin;
    //Gaining Access to authentication method
    private DataSource dataSource;




    /**
     * Create
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dataSource = new DataSource(this);


        final TextView tvErrorRed = (TextView) findViewById(R.id.tvAuthErrorRed); //
        /*

        @Override
public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.splash, container, false);

    loginButton = (LoginButton) view.findViewById(R.id.login_button);
    loginButton.setReadPermissions("email");
    // If using in a fragment
    loginButton.setFragment(this);
    // Other app specific specialization

    // Callback registration
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            // App code
        }

        @Override
        public void onCancel() {
            // App code
        }

        @Override
        public void onError(FacebookException exception) {
            // App code
        }
    });
}
         */

        /**
         * that method fills up the login EditText field
         * based on settings saved in shared preferences
         * during the last session
         */
        loginReminder();


        /**
         * Login Button
         */
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 *  passing 'Extra' values (as a bundle (String, String))
                 *  so the DreamBuilderActivity can create a Dream object (with userId)
                 */
                User userAuthenticated = authenticate();
                if( userAuthenticated != null) {
                    authUserId = userAuthenticated.getUserId();
                    authPhoto = userAuthenticated.getUserPhoto();


                    Intent intentForDreamBuilderPanel = new Intent(getApplicationContext(), DreamBuilderPanelActivity.class);
                    intentForDreamBuilderPanel.putExtra("authName", authUserName);
                    intentForDreamBuilderPanel.putExtra("authPhoto", authPhoto);
                    intentForDreamBuilderPanel.putExtra("authUserId", authUserId);

                    //recieving ProductName from ProductDetailsActivity Intent:
                    Intent intent = getIntent();
                    String chosenProductName = intent.getStringExtra("chosenProductName");

                    //sending chosenProductName to IntentForDreamBuilderPanel
                    intentForDreamBuilderPanel.putExtra("chosenProductName", chosenProductName);



                    startActivity(intentForDreamBuilderPanel);

                }
                else{
                    tvErrorRed.setText("Wrong Login or Password\n" + "Try Again");
                }
            }
        });



        /**
         * Back Button
         */
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProductDetailsActivity.class));
            }
        });



        /**
         *  HiperLink 'REGISTER'
         */
        TextView registerLink = (TextView) findViewById(R.id.tvGetAccountHiperlink);
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

    }

    


    /**
     * Login verification
     */
    @Nullable
    private User authenticate() {

        EditText etLogin = (EditText) findViewById(R.id.etLogin);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        String etLoginString = etLogin.getText().toString();
        String etPasswordString = etPassword.getText().toString();


        User userAuthenticated = dataSource.authenticateUser(etLoginString, etPasswordString);

        /**
         * passing user data to private Strings,
         * so they are passed as extra in intent to DreamBuilderPanelActivity
         */
        if(userAuthenticated != null) {
            authUserId = userAuthenticated.getUserId();
            authLogin = userAuthenticated.getUserLogin();
            authUserName = userAuthenticated.getUserFirstName();
            authPhoto = userAuthenticated.getUserPhoto();

            saveLoginLocalReminder();
            return userAuthenticated;
        }
        else {
            return null;
        }

    }

    /**
     *  Saving Login to shared preferences
     *  so it is used as a 'login reminder' during previous login attempt.
     */
    private void saveLoginLocalReminder(){

        //Editor is an Interface to interact with SharedPreferences
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(MY_GLOBAL_PREFS, MODE_PRIVATE).edit(); // other MODEs other values are depreciated
        editor.putString("authLogin", authLogin);
        editor.commit();

    }


    /**
     *  Previous Login Reminder
     */
    private void loginReminder(){

        SharedPreferences prefs = getSharedPreferences(MY_GLOBAL_PREFS, MODE_PRIVATE);
        String previousAuthenticatedUser = prefs.getString("authLogin", ""); // "" is default value

        //if the previous login was saved then set that value visible:
        if(!TextUtils.isEmpty(previousAuthenticatedUser)){
            EditText etLogin = (EditText) findViewById(R.id.etLogin);
            etLogin.setText(previousAuthenticatedUser);
        }
        else{
            Log.d("Error", "Shared preferences for login reminder are empty!***************************");
        }

    }

    /**
     *  Managing Database connection
     *  Accordingly to Activity Lifecycle:
     */
    @Override
    protected void onPause() {
        super.onPause();
        dataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataSource = new DataSource(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        dataSource.close();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        dataSource = new DataSource(this);

    }



}

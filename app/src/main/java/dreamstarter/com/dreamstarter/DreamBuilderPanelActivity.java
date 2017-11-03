package dreamstarter.com.dreamstarter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import dreamstarter.com.dreamstarter.customTools.ImagePrinter;



/**
 *  This class is responsible to deliver Dreaming options such ass:
 *      * edit User Profile
 *      * create new Dream
 *      * invite facebook Friends
 *      * and other functions that belong to UserAccount
 */
public class DreamBuilderPanelActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_builder_panel);

        TextView tvAuthName = (TextView) findViewById(R.id.tvAuthName);
        ImageView ivProfilePicture = (ImageView) findViewById(R.id.profilePic);

        /** Return the intent that started this activity. */

        Intent intent = getIntent();
        String authName = intent.getStringExtra("authName");
        String authPhoto = intent.getStringExtra("authPhoto");
        String chosenProductName = intent.getStringExtra("chosenProductName");

        tvAuthName.setText("Hello " + authName + " !\n" +
                            "You chose the " + chosenProductName + "\n\n\nGreat Success!!!! :D :D :D :D :D");

        //print the picture
        ImagePrinter.printImage(this, authPhoto, ivProfilePicture);
    }



}

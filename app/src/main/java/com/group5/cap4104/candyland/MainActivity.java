package com.group5.cap4104.candyland;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button startGameBtn, continueGameBtn, settingsBtn, logOutBtn;
    Boolean loggedIn;

    CharSequence players[] = new CharSequence[] {"1", "2", "3", "4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loggedIn = !(SaveSharedPreference.getUserName(getApplicationContext()).length() == 0);

        if (!loggedIn) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        //Assigning the buttons to their views and setting the onClickListeners
        startGameBtn = (Button) findViewById(R.id.startGameBtn);
        continueGameBtn = (Button) findViewById(R.id.continueGameBtn);
        settingsBtn = (Button) findViewById(R.id.settingsBtn);
        logOutBtn = (Button) findViewById(R.id.logoutBtn);

        startGameBtn.setOnClickListener(this);
        continueGameBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);
        logOutBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startGameBtn:

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("How many players?").setItems(players, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });

                builder.create();
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("openingPastGame", "false");
                startActivity(intent);

                //code to start the game
                //need to create a new activity and kick it off here

                break;

            case R.id.continueGameBtn:

                //code to continue the game
                //same activity as start game but it needs to get passed
                //different data so that it knows to load the past game

                Intent contIntent = new Intent(MainActivity.this, GameActivity.class);
                contIntent.putExtra("openingPastGame", "true");
                startActivity(contIntent);

                break;

            case R.id.settingsBtn:

                //go to the settings activity
                //I don't think we need to do anything here, but it's there for looks

                break;

            case R.id.logoutBtn:

                SaveSharedPreference.setPassword(getApplicationContext(), "");
                SaveSharedPreference.setUserName(getApplicationContext(), "");
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                break;

            default:
                //should be nothing...
        }
    }

}

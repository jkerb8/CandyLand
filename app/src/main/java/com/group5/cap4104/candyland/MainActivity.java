package com.group5.cap4104.candyland;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startGameBtn, continueGameBtn, settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning the buttons to their views and setting the onClickListeners
        startGameBtn = (Button) findViewById(R.id.startGameBtn);
        continueGameBtn = (Button) findViewById(R.id.continueGameBtn);
        settingsBtn = (Button) findViewById(R.id.settingsBtn);

        startGameBtn.setOnClickListener(this);
        continueGameBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startGameBtn:
                //code to start the game
                //need to create a new activity and kick it off here

                break;

            case R.id.continueGameBtn:
                //code to continue the game
                //same activity as start game but it needs to get passed
                //different data so that it knows to load the past game

                break;

            case R.id.settingsBtn:
                //go to the settings activity
                //I don't think we need to do anything here, but it's there for looks

                break;

            default:
                //should be nothing...
        }
    }
}

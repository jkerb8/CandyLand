package com.group5.cap4104.candyland;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends Activity implements View.OnClickListener {

    private Button drawCardBtn;
    private TextView bannerText;
    private ImageView playerTurnIV;
    private String[] boardSpaces = new String[139];
    private ArrayList<Integer> drawCards = new ArrayList<>();
    Toast m_currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        drawCardBtn = (Button) findViewById(R.id.drawCardBtn);
        drawCardBtn.setOnClickListener(this);

        //might need to change this for each turn
        bannerText = (TextView) findViewById(R.id.banner);

        //might need to change this for each turn
        playerTurnIV = (ImageView) findViewById(R.id.playerTurnImageView);
        //example: playerTurnIV.setImageResource(R.drawable.plumcard);

        //gets the previously created intent
        Intent intent = getIntent();

        if (intent.getStringExtra("openingPastGame").equals("true")) {
            //load past game
        }
        else {
            assignCards();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.drawCardBtn:
                //drawCard();

                break;

            default:
                //idk
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.saveBtn:
                saveGame();
                showMessage("Game Saved");
                return true;
            case R.id.settingsBtn:
                //go to settings
                return true;
            case R.id.exitGameBtn:
                exitGameDialog();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        exitGameDialog();
    }

    private void exitGameDialog() {
        AlertDialog.Builder possBuilder = new AlertDialog.Builder(this);
        possBuilder
                .setMessage("Save Game Before Exiting?")
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Don't Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setPositiveButton("Save Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        saveGame();
                        finish();
                    }
                })
                .show();
    }

    public void saveGame() {
        //do something to save the state
    }

    public void assignCards() {

        for (int i = 0; i < 6; i++) {
            drawCards.add(R.drawable.sb);
            drawCards.add(R.drawable.sg);
            drawCards.add(R.drawable.so);
            drawCards.add(R.drawable.sp);
            drawCards.add(R.drawable.sr);
            drawCards.add(R.drawable.sy);
        }

        for (int i = 0; i < 2; i++) {
            drawCards.add(R.drawable.db);
            drawCards.add(R.drawable.dg);
            drawCards.add(R.drawable.db);
            drawCards.add(R.drawable.dp);
            drawCards.add(R.drawable.dr);
            drawCards.add(R.drawable.dy);
        }

        drawCards.add(R.drawable.candycanecard);
        drawCards.add(R.drawable.plumcard);
        drawCards.add(R.drawable.snowfalkecard);
        drawCards.add(R.drawable.gumdropcard);
        drawCards.add(R.drawable.peanutcard);
        drawCards.add(R.drawable.lollipopcard);

        Collections.shuffle(drawCards);
    }


    /**
     * 0 starting
     * 134 win
     *
     * 5 skip to 57
     * 32 skips to 45
     *
     * 46 is skip
     * 84 is skip
     * 119 is skip
     *
     * 8 plum
     * 18 candycane
     * 41 gumdrop
     * 73 peanut
     * 94 lollipop
     * 102 snowflake
     */
    public void assignSpaces() {


    }


    public void showMessage(String message) {
        if(m_currentToast != null)
        {
            m_currentToast.cancel();
        }
        m_currentToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        m_currentToast.show();
    }
}

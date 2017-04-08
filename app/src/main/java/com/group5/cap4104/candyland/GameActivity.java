package com.group5.cap4104.candyland;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameActivity extends Activity implements View.OnClickListener {

    private Button drawCardBtn;
    private TextView bannerText;
    private ImageView playerTurnIV, boardIV;
    private String[] boardSpaces = new String[137];
    private String[] colors = new String[6];
    private ArrayList<Integer> drawCards = new ArrayList<>();
    private String playerCountArray[] = new String[] {"2","3","4"};
    private ArrayList<String> colorPieces;
    private ArrayList<Player> players;
    private int playerCount, currentTurn, turnCtr;
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
        boardIV = (ImageView) findViewById(R.id.board);
        //example: playerTurnIV.setImageResource(R.drawable.plumcard);

        colorPieces = new ArrayList<>();
        colorPieces.add("Blue");
        colorPieces.add("Green");
        colorPieces.add("Yellow");
        colorPieces.add("Red");

        players = new ArrayList<>();
        currentTurn = 0;
        turnCtr = 0;

        //gets the previously created intent
        Intent intent = getIntent();

        if (intent.getStringExtra("openingPastGame").equals("true")) {

            assignCards();
            assignSpaces();

        }
        else {

            assignCards();
            assignSpaces();
        }

        //This needs to be in onCreate, not onStart
        askForAI();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.drawCardBtn:
                //drawCard();
                drawCardForVideo();
                nextTurn();
                break;

            default:
                //formality
        }
    }

    private void drawCard() {
        if (drawCards.size() == 0)
            assignCards();

        Random rand = new Random();
        Integer randomInt = drawCards.get(rand.nextInt(drawCards.size()));
        playerTurnIV.setImageResource(randomInt);
        drawCards.remove(randomInt);
    }

    private void drawCardForVideo() {
        switch (turnCtr) {
            case 0:
                playerTurnIV.setImageResource(R.drawable.sb);
                boardIV.setImageResource(R.drawable.board_0);
                break;
            case 1:
                playerTurnIV.setImageResource(R.drawable.dr);
                boardIV.setImageResource(R.drawable.board_1);
                break;
            case 2:
                playerTurnIV.setImageResource(R.drawable.sg);
                boardIV.setImageResource(R.drawable.board_2);
                break;
            case 3:
                playerTurnIV.setImageResource(R.drawable.sy);
                boardIV.setImageResource(R.drawable.board_3);
                break;
            case 4:
                playerTurnIV.setImageResource(R.drawable.sy);
                boardIV.setImageResource(R.drawable.board_4);
                break;
            case 5:
                playerTurnIV.setImageResource(R.drawable.so);
                boardIV.setImageResource(R.drawable.board_5);
                break;
            case 6:
                playerTurnIV.setImageResource(R.drawable.sg);
                boardIV.setImageResource(R.drawable.board_6);
                break;
            case 7:
                playerTurnIV.setImageResource(R.drawable.dy);
                boardIV.setImageResource(R.drawable.board_7);
                break;
            case 8:
                playerTurnIV.setImageResource(R.drawable.sg);
                boardIV.setImageResource(R.drawable.board_8);
                break;
            case 9:
                playerTurnIV.setImageResource(R.drawable.sb);
                boardIV.setImageResource(R.drawable.board_9);
                break;
            case 10:
                playerTurnIV.setImageResource(R.drawable.sy);
                boardIV.setImageResource(R.drawable.board_10);
                break;
            case 11:
                playerTurnIV.setImageResource(R.drawable.so);
                boardIV.setImageResource(R.drawable.board_11);
                break;
            case 12:
                playerTurnIV.setImageResource(R.drawable.so);
                boardIV.setImageResource(R.drawable.board_12);
                break;
            case 13:
                playerTurnIV.setImageResource(R.drawable.peanutcard);
                boardIV.setImageResource(R.drawable.board_13);
                break;
            case 14:
                playerTurnIV.setImageResource(R.drawable.sg);
                boardIV.setImageResource(R.drawable.board_14);
                break;
            case 15:
                playerTurnIV.setImageResource(R.drawable.dp);
                boardIV.setImageResource(R.drawable.board_15);
                break;
            case 16:
                playerTurnIV.setImageResource(R.drawable.sy);
                boardIV.setImageResource(R.drawable.board_16);
                break;
            case 17:
                playerTurnIV.setImageResource(R.drawable.sp);
                boardIV.setImageResource(R.drawable.board_17);
                break;
            case 18:
                playerTurnIV.setImageResource(R.drawable.candycanecard);
                boardIV.setImageResource(R.drawable.board_18);
                break;
            case 19:
                playerTurnIV.setImageResource(R.drawable.sp);
                boardIV.setImageResource(R.drawable.board_19);
                break;
            case 20:
                playerTurnIV.setImageResource(R.drawable.sg);
                boardIV.setImageResource(R.drawable.board_20);
                break;
            case 21:
                playerTurnIV.setImageResource(R.drawable.db);
                boardIV.setImageResource(R.drawable.board_21);
                break;
            case 22:
                playerTurnIV.setImageResource(R.drawable.so);
                boardIV.setImageResource(R.drawable.board_22);
                break;
            case 23:
                playerTurnIV.setImageResource(R.drawable.sp);
                boardIV.setImageResource(R.drawable.board_23);
                break;
            case 24:
                playerTurnIV.setImageResource(R.drawable.sy);
                boardIV.setImageResource(R.drawable.board_24);
                break;
            case 25:
                playerTurnIV.setImageResource(R.drawable.blank);
                showMessage("Skip, No draw");
                boardIV.setImageResource(R.drawable.board_25);
                break;
            case 26:
                playerTurnIV.setImageResource(R.drawable.sr);
                boardIV.setImageResource(R.drawable.board_26);
                break;
            case 27:
                playerTurnIV.setImageResource(R.drawable.sb);
                boardIV.setImageResource(R.drawable.board_27);
                break;
            default:
                delcareWinnder(2);
                break;
        }

        turnCtr++;
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

        colors[0] = "red";
        colors[1] = "purple";
        colors[2] = "yellow";
        colors[3] = "blue";
        colors[4] = "orange";
        colors[5] = "green";

        boardSpaces[0] = "start"; // not seen on board
        boardSpaces[134] = "win"; // not seen on board
//        boardSpaces[5] = "skipfrom1";
//        boardSpaces[57] = "skipto1";
//        boardSpaces[32] = "skipfrom2";
//        boardSpaces[45] = "skipto2";
//        boardSpaces[46] = "stop1";
//        boardSpaces[84] = "stop2";
//        boardSpaces[119] = "stop3";
        boardSpaces[8] = "plum";
        boardSpaces[18] = "candycane";
        boardSpaces[41] = "gumdrop";
        boardSpaces[73] = "peanut";
        boardSpaces[94] = "lollipop";
        boardSpaces[102] = "snowflake";

        int i = 0;
        int j = 0;
        while (i < 136) {
            if(boardSpaces[i] == null) {
                if (j == 6)
                    j = 0;
                boardSpaces[i] = colors[j];
                j++;
            }
            i++;
        }

    }

    public void nextTurn() {
        currentTurn++;

        if (currentTurn > playerCount) currentTurn = 1;

        bannerText.setText("Player " + currentTurn + ", draw a card!");
    }

    public void showMessage(String message) {
        if(m_currentToast != null)
        {
            m_currentToast.cancel();
        }
        m_currentToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        m_currentToast.show();
    }

    public void askForAI() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Play other players or computer?")
                .setPositiveButton("Other Players", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pickPlayerCount();
                    }
                })
                .setNegativeButton("Computer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pickPlayerCount();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void pickPlayerCount () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("How many players")
                .setItems(playerCountArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (id == 0) playerCount = 2;
                if (id == 1) playerCount = 3;
                if (id == 2) playerCount = 4;

                pickColorPieces(playerCount, colorPieces);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void pickColorPieces(final int playersLeft, final ArrayList<String> colors) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Player " + (playerCount - playersLeft + 1) + ", pick the color of your game piece.")
                .setItems(colors.toArray(new String[colors.size()]), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        players.add(new Player(colors.get(id)));
                        colors.remove(id);

                        if (playersLeft > 1) pickColorPieces(playersLeft - 1, colors);
                        else nextTurn();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void delcareWinnder(int player) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Player " + player + " has won the game! Return to main menu?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}

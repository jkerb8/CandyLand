package com.group5.cap4104.candyland;

import android.widget.ImageView;

import java.util.*;

public class BoardSetup {

    public String[] boardSpaces = new String[139];
    public ArrayList<Integer> drawCards = new ArrayList<>();

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

}

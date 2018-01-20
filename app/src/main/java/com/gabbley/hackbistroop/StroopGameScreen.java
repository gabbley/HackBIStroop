package com.gabbley.hackbistroop;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StroopGameScreen extends AppCompatActivity {

    //fields
    public static String stroopCompare;
    public static String stroopWord;
    public static int[] colorArray;
    public TextView mainWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_game_screen);
        initialSetup(); //sets initial layouts/settings

    }

    public void initialSetup(){

        //sets main word to random color (text and color)
        mainWord = findViewById(R.id.txtStroopWord);
        mainWord.setTextColor(randColor());
        mainWord.setText(getRandColorWord());

        //identifies which word is displayed
        stroopWord = mainWord.getText().toString();


        //adds color effect to title on game screen
        TextView gameTitle = findViewById(R.id.lblTitle);
        discoTitle(gameTitle);

    }

    public void setStroop(View view){
        whichButtonClicked(view); //identifies which button is chosen

        //colorNameArray(); //sets Stroop Compare
        if (stroopWord.equals(stroopCompare)) { //compares the two answers
            scoreUpdate(); //updates score accordingly
        }

    }

    //returns a random color to set word to
    public int randColor(){

        colorArray = new int[] {Color.YELLOW, Color.GREEN,
                Color.RED, Color.BLUE, Color.MAGENTA, Color.BLACK,
                Color.CYAN, Color.GRAY};

        return colorArray[(int)(Math.random() * colorArray.length) ]; //error, thinks length is zero
    }


    //randomly changes text view color every .5 second
    public void discoTitle(final TextView disco){
        Thread t = new Thread() {


            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                disco.setTextColor(randColor());
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    //identifies which button is clicked
    public void whichButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.btnYellow: stroopCompare = "yellow";
                break;
            case R.id.btnGreen: stroopCompare = "green";
                break;
            case R.id.btnRed : stroopCompare = "red";
                break;
            case R.id.btnBlue : stroopCompare = "blue";
                break;
            case R.id.btnPurple : stroopCompare = "purple";
                break;
            case R.id.btnBlack : stroopCompare = "black";
                break;
            case R.id.btnOrange : stroopCompare = "orange";
                break;
            case R.id.btnPink : stroopCompare = "pink";
                break;
            default: stroopCompare = "no color";
        }

    }

    //returns random color name
    public void colorNameArray(){


        String[] colorNames = new String[] {"yellow", "green", "blue", "orange",
                "red", "purple", "pink", "black"};

        stroopWord = colorNames[(int)(Math.random()*colorNames.length)];


    }

    //returns random color
    public String getRandColorWord(){
        String[] colorNames = new String[] {"yellow", "green", "blue", "orange",
                "red", "purple", "pink", "black"};

        return colorNames[(int)(Math.random()*colorNames.length)];
    }

    //displays score on screen
    public void viewScore(){

        //Missing code
        //Access the TextView for the score by initializing a TextView variable

        //set the text to the current score
    }

    //updates score, new word
    public void scoreUpdate(){

        //Missing Code

        //update score variable
        //display updated score
        //reset Stroop word (rand color, rand color name)
        //display new word

    }

    //resets score to zero
    public void resetScore(View view){
        //Missing Code

        //set score variable to -1
        scoreUpdate();
    }



}

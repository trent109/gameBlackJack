package com.trenthamilton.gameblackjack;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.trenthamilton.gameblackjack.R.color.colorPrimaryDark;
import static com.trenthamilton.gameblackjack.R.string.BustedBlackJackTextView;
import static com.trenthamilton.gameblackjack.R.string.blackJackTitle;
import static com.trenthamilton.gameblackjack.R.string.charlieTitle;


public class MainActivity extends AppCompatActivity {
    //Declare variables
    private int dealersScore = 0;
    private int playersScore = 0;

    private int dealersCard1 = 0;
    private int playersCard1 = 0;


    private int dealersWins = 0;
    private int playersWins = 0;
    private int gameDraw = 0;

    String gameUpdate = "";

    //Declare Views
    //users Image views
    private ImageView userFirstCardImageView;
    private ImageView userSecondCardImageView;
    private ImageView userThirdCardImageView;
    private ImageView userForthCardImageView;
    private ImageView userFifthCardImageView;

    //dealers image views
    private ImageView dealersFirstCardImageView;
    private ImageView dealersSecondCardImageView;
    private ImageView dealersThirdCardImageView;
    private ImageView dealersForthCardImageView;
    private ImageView dealersFifthCardImageView;

    //TextViews
    private TextView dealersScoreTextView;
    private TextView playersScoreTextView;
    private TextView blackjackTextView;

    //Buttons
    private Button standButton;
    private Button hitButton;

    CardDeck myDeck;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //=================================onCreate=====================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaer views
        //Users Cards
        userFirstCardImageView = (ImageView) findViewById(R.id.userFirstCardImageView);
        userSecondCardImageView = (ImageView) findViewById(R.id.userSecondCardImageView);
        userThirdCardImageView = (ImageView) findViewById(R.id.userThirdCardImageView);
        userForthCardImageView = (ImageView) findViewById(R.id.userForthCardImageView);
        userFifthCardImageView = (ImageView) findViewById(R.id.userFifthCardImageView);

        //Dealers Cards
        dealersFirstCardImageView = (ImageView) findViewById(R.id.dealersFirstCardImageView);
        dealersSecondCardImageView = (ImageView) findViewById(R.id.dealersSecondCardImageView);
        dealersThirdCardImageView = (ImageView) findViewById(R.id.dealersThirdCardImageView);
        dealersForthCardImageView = (ImageView) findViewById(R.id.dealersForthCardImageView);
        dealersFifthCardImageView = (ImageView) findViewById(R.id.dealersFifthCardImageView);

        //TextViews
        playersScoreTextView = (TextView) findViewById(R.id.playersScoreTextView);
        dealersScoreTextView = (TextView) findViewById(R.id.dealersScoreTextView);
        blackjackTextView = (TextView) findViewById(R.id.blackjackTextView);

        cardsInvisible();

        //Creates the deck
        myDeck = new CardDeck();
        myDeck.Shuffle();

        //making the buttons invisible til the user starts the game... So i dont have to program around more bugs ;)
        standButton = (Button) findViewById(R.id.standButton);
        hitButton = (Button) findViewById(R.id.hitButton);

        standButton.setVisibility(View.INVISIBLE);
        hitButton.setVisibility(View.INVISIBLE);
//======================dealButton onClickListener==================================================
        //declare buttons
        final Button dealButton = (Button) findViewById(R.id.dealButton);
        dealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //setting deal button to invisible  after it is pressed

        //setting hit and stand button visible so the buttons cant be pressed before the cards a delt
        //more to make the games a little more user friendly
                dealButton.setVisibility(View.INVISIBLE);
                standButton.setVisibility(View.VISIBLE);
                hitButton.setVisibility(View.VISIBLE);
        //on the deal the dealer gets one card.
        //made a deal method to clean up the code a bit.
                deal();
            }
        });
//===========================end of  deal onClickListener===========================================
//======================hitButton onClickListener==================================================
        Button hitButton = (Button) findViewById(R.id.hitButton);
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        //number of cards in the players hand is to because the player gets two cards upon the deal button being
        //clicked on
                if (playersCard1 == 2) {
                    Card thirdCard = myDeck.DealCard();
                    userThirdCardImageView.setVisibility(View.VISIBLE);
                    userThirdCardImageView.setImageResource(thirdCard.getImageResourceID());
                    playersScore = playersScore + thirdCard.getValue();
                    playersScoreTextView.setText(String.valueOf(playersScore));
                    playersCard1++;
                    isTwentyOne();

                } else {
                    //three cards
                    if (playersCard1 == 3) {
                        Card fourCard = myDeck.DealCard();
                        userForthCardImageView.setVisibility(View.VISIBLE);
                        userForthCardImageView.setImageResource(fourCard.getImageResourceID());
                        playersScore = playersScore + fourCard.getValue();
                        playersScoreTextView.setText(String.valueOf(playersScore));
                        playersCard1++;
                        isTwentyOne();

                    } else {
                    //four cards
                        if (playersCard1 == 4) {
                            Card fifthCard = myDeck.DealCard();
                            userFifthCardImageView.setVisibility(View.VISIBLE);
                            userFifthCardImageView.setImageResource(fifthCard.getImageResourceID());
                            playersScore = playersScore + fifthCard.getValue();
                            playersScoreTextView.setText(String.valueOf(playersScore));
                            playersCard1++;
                            isTwentyOne();
                        }
                    }
                }
            }
        });
//====================end of hit onClickListener====================================================
//======================stand onClickListener=======================================================
        Button standButton = (Button) findViewById(R.id.standButton);
        standButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dealersCards();
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }//end of onCrete
//=============================end of onCreate=====================================================
 //===============================configurationChange(==============================================

    //this is set up so if the user changes the orientation of the phone it will save the state
    //this seem alot more efficent than
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            //was going to put a toast here but decided not to. maybe later
        }
    }
//==============================end of configurationChange==========================================
    //===================================dealersCards()=============================================
//Method for the dealer to get his cards. there is a do loop to keep repeating up til the dealers score
    //is at least 17
    private void dealersCards() {
            //Loop to do the if statement until the dealer is atleast to 17
        do {
            if (dealersCard1 <= 0) {

            // dealer already has one card showing so
                Card dealerSecondCard = myDeck.DealCard();
                dealersSecondCardImageView.setImageResource(dealerSecondCard.getImageResourceID());
                dealersScore = dealersScore + dealerSecondCard.getValue();
                dealersScoreTextView.setText(String.valueOf(dealersScore));
                //because there are two cards in the dealers hand
                dealersCard1 = dealersCard1 + 2;

                if (dealersScore <= 16 && dealersCard1 == 2) {
                    Card dealersThirdCard = myDeck.DealCard();
                    dealersThirdCardImageView.setVisibility(View.VISIBLE);
                    dealersThirdCardImageView.setImageResource(dealersThirdCard.getImageResourceID());
                    dealersScore = dealersScore + dealersThirdCard.getValue();
                    dealersScoreTextView.setText(String.valueOf(dealersScore));
                    dealersCard1++;
                }

            } else {
                if (dealersScore <= 16 && dealersCard1 == 3) {

                    Card dealersFourthCard = myDeck.DealCard();
                   dealersForthCardImageView.setVisibility(View.VISIBLE);
                    dealersForthCardImageView.setImageResource(dealersFourthCard.getImageResourceID());
                    dealersScore = dealersScore + dealersFourthCard.getValue();
                    dealersScoreTextView.setText(String.valueOf(dealersScore));
                    dealersCard1++;

                } else {
                    if (dealersScore <= 16 && dealersCard1 == 4) {
                        Card dealersFifthCard = myDeck.DealCard();
                        dealersFifthCardImageView.setVisibility(View.VISIBLE);
                        dealersFifthCardImageView.setImageResource(dealersFifthCard.getImageResourceID());
                        dealersScore = dealersScore + dealersFifthCard.getValue();
                        dealersScoreTextView.setText(String.valueOf(dealersScore));
                    }
                }
            }
        } while (dealersScore <= 16);
        //method called to compare the scores of the game
        compare();
    }

    //=====================================compare()================================================
    //used to see if the player or the user won.
    private void compare() {

        //Declare Variable. gameUpdate string used to update textbox when the game has ended.

        // if both dealer and player are over 21 then the game would be a push
        String soundMade;
        //this if statement the user lost
        if (dealersScore > playersScore && dealersScore <= 21 || playersScore > 21 && dealersScore <= 21) {
            gameUpdate = "YOU LOST :(";
            dealersWins++;
            makeView(gameUpdate);
            soundMade = "lost";
            sound(soundMade);
        //this else if statement the user won
        } else if (playersScore > dealersScore && playersScore <= 21 || dealersScore > 21 && playersScore <= 21) {
            gameUpdate = "YOU WON!!";
            playersWins++;
            makeView(gameUpdate);
            soundMade = "won";
            sound(soundMade);
        //this if statement is for tie. either both players busted ot tied in score
        } else if (dealersScore > 21 && playersScore > 21 || dealersScore == playersScore) {
            gameUpdate = "PUSH";
            gameDraw++;
            makeView(gameUpdate);
            soundMade = "push";
            sound(soundMade);
        }
    }//end of compare

    //======================makeView()============================================================
    // to make a view at the bottom of the screen that will display if you won or lost.
    private void makeView(String gameUpdate) {
        clearView();

        //Casting layout
        LinearLayout cardLayout = (LinearLayout) findViewById(R.id.cardLinearLayout);
        //make text view to tell user if they won or lost
        TextView gameStatus = new TextView(getApplicationContext());
        gameStatus.setText(gameUpdate);
        gameStatus.setPadding(0, 0, 20, 0);
        gameStatus.setTextSize(22);
        gameStatus.setTextColor(this.getResources().getColor(colorPrimaryDark));
        gameStatus.setTypeface(null, Typeface.BOLD);
        cardLayout.addView(gameStatus);

        //reset button to reset game with blackjack game was finished.
        Button resetButton = new Button(getApplicationContext());
        resetButton.setText(R.string.resetButton);
        cardLayout.addView(resetButton);
        //textview to give the score of how many times the dealer an user has won
        TextView scoreCard = new TextView(getApplicationContext());
        scoreCard.setText(String.valueOf("Dealers: " + dealersWins + "\n" + "Player: " + playersWins + "\n" + "Push: " + gameDraw));
        scoreCard.setPadding(15, 0, 0, 0);
        scoreCard.setTextColor(this.getResources().getColor(colorPrimaryDark));
        cardLayout.addView(scoreCard);


//============================RESET BUTTON onCLickListener==========================================
//Resets the game after you find out if you won or lost.
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
        //once the reset button is pressed (now says new game) it starts a new game.
                deal();
            }
        });
    }
    //==============================end of COMPARE()====================================================

//=====================================isTwentyOne==================================================
    private void isTwentyOne() {
        //Checks to see if score is over twenty one. If it is over 21 it will deal the dealers car.
        if (playersScore > 21) {
            //called to deal the dealers Cards because you BUSTED!
            blackjackTextView.setText(BustedBlackJackTextView);
            dealersCards();
        } else {
            //this is called a 5 card charlie. if the user has 5 cards and under twenty one. The user
            //automatically wins.
            if (playersScore <= 21 && playersCard1 == 5) {
                gameUpdate = "Won";
                makeView(gameUpdate);
                playersWins++;
                blackjackTextView.setText(charlieTitle);
            }
        }
    }
//=================================end of isTwentyOne===============================================

    //=================================clear()======================================================
    // clears out the game so it can start a new game.
    private void clear() {
        //removing layout
        LinearLayout cardLayout = (LinearLayout) findViewById(R.id.cardLinearLayout);
        cardLayout.removeAllViews();

        //resettings text views
        playersScoreTextView.setText("0");
        dealersScoreTextView.setText("0");
        blackjackTextView.setText(blackJackTitle);
        //resetting variables
        playersScore = 0;
        dealersScore = 0;
        dealersCard1 = 0;
        playersCard1 = 0;

          //reset users cards
        userFirstCardImageView.setImageResource(R.drawable.cardback);
        userSecondCardImageView.setImageResource(R.drawable.cardback);
        userThirdCardImageView.setImageResource(R.drawable.cardback);
        userForthCardImageView.setImageResource(R.drawable.cardback);
        userFifthCardImageView.setImageResource(R.drawable.cardback);

        //reset dealers cards
        dealersFirstCardImageView.setImageResource(R.drawable.cardback);
        dealersSecondCardImageView.setImageResource(R.drawable.cardback);
        dealersThirdCardImageView.setImageResource(R.drawable.cardback);
        dealersForthCardImageView.setImageResource(R.drawable.cardback);
        dealersFifthCardImageView.setImageResource(R.drawable.cardback);

        cardsInvisible();

        showView();
    }

    //================================clearView()=======================================================
    private void clearView() {
        LinearLayout buttonLayout = (LinearLayout) findViewById(R.id.buttonsLinearLayout);
        buttonLayout.setVisibility(View.INVISIBLE);
    }

    //=================================showView()=======================================================
    //shows a layout after the game is finished
    private void showView() {
        LinearLayout buttonLayout = (LinearLayout) findViewById(R.id.buttonsLinearLayout);
        buttonLayout.setVisibility(View.VISIBLE);
    }

    //==============================deal================================================================
    private void deal() {
        Card dealerFirstCard = myDeck.DealCard();
        dealersFirstCardImageView.setImageResource(dealerFirstCard.getImageResourceID());
        dealersFirstCardImageView.setVisibility(View.VISIBLE);
        dealersSecondCardImageView.setVisibility(View.VISIBLE);
        dealersScore = dealerFirstCard.getValue();
        dealersScoreTextView.setText(String.valueOf(dealersScore));


        //Statement so the user can hit deal again and keep repeating getting different cards
        //couldnt get boolean to work
        if (playersCard1 <= 0) {
            Card firstCard = myDeck.DealCard();
            userFirstCardImageView.setVisibility(View.VISIBLE);
            userFirstCardImageView.setImageResource(firstCard.getImageResourceID());
            playersScore = firstCard.getValue();
            playersCard1++;

            Card secondCard = myDeck.DealCard();
            userSecondCardImageView.setVisibility(View.VISIBLE);
            userSecondCardImageView.setImageResource(secondCard.getImageResourceID());

            playersScore = playersScore + secondCard.getValue();
            playersScoreTextView.setText(String.valueOf(playersScore));
            playersCard1++;
        }
    }
    //===============================sound()============================================================
    //just playing around with java code here but this will make a sound according to what the compare
    //method outputs
    private void sound(String Sound) {
        if (Sound == "lost") {
            MediaPlayer mySound = MediaPlayer.create(this, R.raw.doh);
            mySound.start();
        } else if (Sound == "won") {
            MediaPlayer mySound = MediaPlayer.create(this, R.raw.woohoo);
            mySound.start();
        } else if (Sound == "push") {
            MediaPlayer mySound = MediaPlayer.create(this, R.raw.push);
            mySound.start();
        }
    }

    private void cardsInvisible()
    {
        dealersFirstCardImageView.setVisibility(View.INVISIBLE);
        dealersSecondCardImageView.setVisibility(View.INVISIBLE);
        dealersThirdCardImageView.setVisibility(View.INVISIBLE);
        dealersForthCardImageView.setVisibility(View.INVISIBLE);
        dealersFifthCardImageView.setVisibility(View.INVISIBLE);

        userFirstCardImageView.setVisibility(View.INVISIBLE);
        userSecondCardImageView.setVisibility(View.INVISIBLE);
        userThirdCardImageView.setVisibility(View.INVISIBLE);
        userForthCardImageView.setVisibility(View.INVISIBLE);
        userFifthCardImageView.setVisibility(View.INVISIBLE);

    }
    //==========================================onStart()-==========================================
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.trenthamilton.gameblackjack/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    //===============================onStop()===========================================================
    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.trenthamilton.gameblackjack/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}
//=================================endOfCode========================================================
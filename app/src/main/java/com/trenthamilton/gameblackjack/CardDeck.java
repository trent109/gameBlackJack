package com.trenthamilton.gameblackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Trents Laptop on 2/14/2016.
 */
public class CardDeck {

    private ArrayList<Card> theDeck = new ArrayList<Card>();
    private Integer topOfDeck = 0;
    private Random random = new Random();


    // default constructor
    public CardDeck() {
        // creates a deck of 52 cards of the standard suits.
        // spades
        theDeck.add(new Card(1, Card.Suit.Spades, "Ace of Spades", "1s", R.drawable.card1s));
        theDeck.add(new Card(2, Card.Suit.Spades, "Two of Spades", "2s", R.drawable.card2s));
        theDeck.add(new Card(3, Card.Suit.Spades, "Three of Spades", "3s", R.drawable.card3s));
        theDeck.add(new Card(4, Card.Suit.Spades, "Four of Spades", "4s", R.drawable.card4s));
        theDeck.add(new Card(5, Card.Suit.Spades, "Five of Spades", "5s", R.drawable.card5s));
        theDeck.add(new Card(6, Card.Suit.Spades, "Six of Spades", "6s", R.drawable.card6s));
        theDeck.add(new Card(7, Card.Suit.Spades, "Seven of Spades", "7s", R.drawable.card7s));
        theDeck.add(new Card(8, Card.Suit.Spades, "Eight of Spades", "8s", R.drawable.card8s));
        theDeck.add(new Card(9, Card.Suit.Spades, "Nine of Spades", "9s", R.drawable.card9s));
        theDeck.add(new Card(10, Card.Suit.Spades, "Ten of Spades", "10s", R.drawable.card10s));
        theDeck.add(new Card(10, Card.Suit.Spades, "Jack of Spades", "11s", R.drawable.card11s));
        theDeck.add(new Card(10, Card.Suit.Spades, "Queen of Spades", "12s", R.drawable.card12s));
        theDeck.add(new Card(10, Card.Suit.Spades, "King of Spades", "13s", R.drawable.card13s));
        // Hearts
        theDeck.add(new Card(1, Card.Suit.Hearts, "Ace of Hearts", "1h", R.drawable.card1h));
        theDeck.add(new Card(2, Card.Suit.Hearts, "Two of Hearts", "2h", R.drawable.card2h));
        theDeck.add(new Card(3, Card.Suit.Hearts, "Three of Hearts", "3h", R.drawable.card3h));
        theDeck.add(new Card(4, Card.Suit.Hearts, "Four of Hearts", "4h", R.drawable.card4h));
        theDeck.add(new Card(5, Card.Suit.Hearts, "Five of Hearts", "5h", R.drawable.card5h));
        theDeck.add(new Card(6, Card.Suit.Hearts, "Six of Hearts", "6h", R.drawable.card6h));
        theDeck.add(new Card(7, Card.Suit.Hearts, "Seven of Hearts", "7h", R.drawable.card7h));
        theDeck.add(new Card(8, Card.Suit.Hearts, "Eight of Hearts", "8h", R.drawable.card8h));
        theDeck.add(new Card(9, Card.Suit.Hearts, "Nine of Hearts", "9h", R.drawable.card9h));
        theDeck.add(new Card(10, Card.Suit.Hearts, "Ten of Hearts", "10h", R.drawable.card10h));
        theDeck.add(new Card(10, Card.Suit.Hearts, "Jack of Hearts", "11h", R.drawable.card11h));
        theDeck.add(new Card(10, Card.Suit.Hearts, "Queen of Hearts", "12h", R.drawable.card12h));
        theDeck.add(new Card(10, Card.Suit.Hearts, "King of Hearts", "13h", R.drawable.card13h));
        // Clubs
        theDeck.add(new Card(1, Card.Suit.Clubs, "Ace of Clubs", "1c", R.drawable.card1c));
        theDeck.add(new Card(2, Card.Suit.Clubs, "Two of Clubs", "2c", R.drawable.card2c));
        theDeck.add(new Card(3, Card.Suit.Clubs, "Three of Clubs", "3c", R.drawable.card3c));
        theDeck.add(new Card(4, Card.Suit.Clubs, "Four of Clubs", "4c", R.drawable.card4c));
        theDeck.add(new Card(5, Card.Suit.Clubs, "Five of Clubs", "5c", R.drawable.card5c));
        theDeck.add(new Card(6, Card.Suit.Clubs, "Six of Clubs", "6c", R.drawable.card6c));
        theDeck.add(new Card(7, Card.Suit.Clubs, "Seven of Clubs", "7c", R.drawable.card7c));
        theDeck.add(new Card(8, Card.Suit.Clubs, "Eight of Clubs", "8c", R.drawable.card8c));
        theDeck.add(new Card(9, Card.Suit.Clubs, "Nine of Clubs", "9c", R.drawable.card9c));
        theDeck.add(new Card(10, Card.Suit.Clubs, "Ten of Clubs", "10c", R.drawable.card10c));
        theDeck.add(new Card(10, Card.Suit.Clubs, "Jack of Clubs", "11c", R.drawable.card11c));
        theDeck.add(new Card(10, Card.Suit.Clubs, "Queen of Clubs", "12c", R.drawable.card12c));
        theDeck.add(new Card(10, Card.Suit.Clubs, "King of Clubs", "13c", R.drawable.card13c));
        // Diamonds
        theDeck.add(new Card(1, Card.Suit.Diamonds, "Ace of Diamonds", "1d", R.drawable.card1d));
        theDeck.add(new Card(2, Card.Suit.Diamonds, "Two of Diamonds", "2d", R.drawable.card2d));
        theDeck.add(new Card(3, Card.Suit.Diamonds, "Three of Diamonds", "3d", R.drawable.card3d));
        theDeck.add(new Card(4, Card.Suit.Diamonds, "Four of Diamonds", "4d", R.drawable.card4d));
        theDeck.add(new Card(5, Card.Suit.Diamonds, "Five of Diamonds", "5d", R.drawable.card5d));
        theDeck.add(new Card(6, Card.Suit.Diamonds, "Six of Diamonds", "6d", R.drawable.card6d));
        theDeck.add(new Card(7, Card.Suit.Diamonds, "Seven of Diamonds", "7d", R.drawable.card7d));
        theDeck.add(new Card(8, Card.Suit.Diamonds, "Eight of Diamonds", "8d", R.drawable.card8d));
        theDeck.add(new Card(9, Card.Suit.Diamonds, "Nine of Diamonds", "9d", R.drawable.card9d));
        theDeck.add(new Card(10, Card.Suit.Diamonds, "Ten of Diamonds", "10d", R.drawable.card10d));
        theDeck.add(new Card(10, Card.Suit.Diamonds, "Jack of Diamonds", "11d", R.drawable.card11d));
        theDeck.add(new Card(10, Card.Suit.Diamonds, "Queen of Diamonds", "12d", R.drawable.card12d));
        theDeck.add(new Card(10, Card.Suit.Diamonds, "King of Diamonds", "13d", R.drawable.card13d));
    }   /// end constructor

    // This method deals a card to the caller
    public Card DealCard() {
        if (topOfDeck >= 52)
            topOfDeck = 0;  // keep within the bounds of the array
        return theDeck.get(topOfDeck++);
    }

    // This method returns the number of cards dealt since the last shuffle
    public Integer NumberOfCardsDealt() {
        return topOfDeck;
    }

    //============================Suffle()==============================================================
    public void Shuffle() {
        Collections.shuffle(theDeck, random);
        topOfDeck = 0;  //reset pointer to the top of the deck
    }

}
//=========================End of Code==============================================================
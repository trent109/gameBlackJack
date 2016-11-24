package com.trenthamilton.gameblackjack;

/**
 * Created by Trent on 2/13/2016.
 */
public class Card {
    public enum Suit {Spades, Hearts, Diamonds, Clubs, undefined}

    ;

    private int value; // 1 to 13 representing
    private Suit suit;  // enumerated value of the Suit
    private String name;  // ex: 3 of Clubs or Ace of Diamonds
    private String textValue; // ex: 1s for Ace of Spades
    private int imageResourceID;  // ID of the picture of this card

    // default constructor - sets up some invalid values
    public Card() {
        value = 0;
        suit = Suit.undefined;
        name = "blank card";
        textValue = "blank";
        imageResourceID = 0;  // unspecified
    }

    public Card(int Value, Suit Suit, String Name,
                String TextValue, int ImageResourceID) {
        setValue(Value);
        setSuit(Suit);
        setName(Name);
        setTextValue(TextValue);
        setImageResourceID(ImageResourceID);
    }


    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }


    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }


    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }


    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the textValue
     */
    public String getTextValue() {
        return textValue;
    }


    /**
     * @param textValue the textValue to set
     */
    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }


    /**
     * @return the imageResourceID
     */
    public int getImageResourceID() {
        return imageResourceID;
    }


    /**
     * @param imageResourceID the imageResourceID to set
     */
    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

}
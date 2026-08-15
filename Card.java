/*
file name:      Card.java
Authors:        Parth Thapa Chhetri
last modified:  2/25
Purpose:        Represents a single playing card with a specific numerical value for Blackjack.
*/
public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val the value of the card (should be between 2 and 11)
     */
    public Card(int val) {
        // Simple range checking to ensure valid Blackjack card values
        if (val >= 2 && val <= 11) {
            this.value = val;
        } else {
            System.out.println("Warning: Invalid card value initialized.");
            this.value = val;
        }
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return String.valueOf(this.value);
    }
}
/*
file name:      Hand.java
Authors:        Parth Thapa Chhetri
last modified:  2/25
Purpose:        Represents a collection of cards held by a player or dealer and calculates their total value.
*/
import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    public Hand() {
        cards = new ArrayList<Card>();
    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset() {
        cards.clear();
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size() {
        return cards.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue() {
        int sum = 0;
        // Loop through the cards and aggregate their total values
        for (Card c : cards) {
            sum += c.getValue();
        }
        return sum;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString() {
        // Automatically calls ArrayList.toString() which formats as [val1, val2]
        return cards.toString() + " : " + getTotalValue();
    }
}
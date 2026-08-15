/*
file name:      Deck.java
Authors:        Parth Thapa Chhetri
last modified:  2/25
Purpose:        Represents a 52-card deck that can be built, shuffled, and dealt from during a game.
*/
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {
        cards = new ArrayList<Card>();
        build();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {
        cards.clear(); // Clear out any remaining cards before rebuilding
        
        // Add 4 of each card from 2-9 and 11
        for (int i = 0; i < 4; i++) {
            for (int val = 2; val <= 9; val++) {
                cards.add(new Card(val));
            }
            cards.add(new Card(11));
        }
        
        // Add 16 cards with the value 10 (representing 10, Jack, Queen, King)
        for (int i = 0; i < 16; i++) {
            cards.add(new Card(10));
        }
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        if (cards.size() > 0) {
            // Remove from position 0 (top of the deck)
            return cards.remove(0);
        }
        return null; // Return null if deck is empty
    }

    /**
     * Shuffles the cards currently in the deck using the Fisher-Yates algorithm.
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            // Generate a random index between 0 and i inclusive
            int j = rand.nextInt(i + 1);
            
            // Swap cards at index i and index j
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        return cards.toString();
    }
}
/*
file name:      Blackjack.java
Authors:        Parth Thapa Chhetri
last modified:  2/25
Purpose:        Contains the core game logic and rules for simulating a single round of Blackjack.
*/
public class Blackjack {
    
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    /**
     * Constructor sets up a game with a shuffled deck and empty hands.
     */
    public Blackjack() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand();
        dealerHand = new Hand();
    }

    /**
     * Resets hands and determines if the deck needs to be rebuilt based on remaining size.
     */
    public void reset() {
        playerHand.reset();
        dealerHand.reset();
        
        // Reshuffle condition: if less than 26 cards remain out of 52
        if (deck.size() < 26) {
            deck.build();
            deck.shuffle();
        }
    }

    /**
     * Deals two initial cards each to the player and the dealer.
     */
    public void deal() {
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
    }

    /**
     * Processes the player's turn. Hits until the hand value is >= 16.
     * @return false if player busts (> 21), true otherwise.
     */
    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.add(deck.deal());
        }
        // Player survives if their hand doesn't exceed 21
        return playerHand.getTotalValue() <= 21;
    }

    /**
     * Processes the dealer's turn. Hits until the hand value is >= 17.
     * @return false if dealer busts (> 21), true otherwise.
     */
    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.add(deck.deal());
        }
        // Dealer survives if their hand doesn't exceed 21
        return dealerHand.getTotalValue() <= 21;
    }

    /**
     * Plays a complete single game of Blackjack.
     * @param verbose whether or not to print textual updates of hands and results
     * @return 1 if player wins, -1 if dealer wins, 0 for push (tie)
     */
    public int game(boolean verbose) {
        reset();
        deal();
        
        if (verbose) {
            System.out.println("Initial Deal:");
            System.out.println(this.toString());
        }
        
        // Player acts first
        boolean playerSafe = playerTurn();
        if (!playerSafe) {
            if (verbose) System.out.println("\nPlayer busted! Dealer wins.\nFinal State:\n" + this.toString());
            return -1; 
        }
        
        // Dealer acts only if player didn't bust
        boolean dealerSafe = dealerTurn();
        if (!dealerSafe) {
            if (verbose) System.out.println("\nDealer busted! Player wins.\nFinal State:\n" + this.toString());
            return 1;
        }
        
        // Both survived, compare values
        int pVal = playerHand.getTotalValue();
        int dVal = dealerHand.getTotalValue();
        
        if (verbose) {
            System.out.println("\nFinal State:");
            System.out.println(this.toString());
        }

        if (pVal > dVal) {
            if (verbose) System.out.println("Player wins!");
            return 1;
        } else if (pVal < dVal) {
            if (verbose) System.out.println("Dealer wins!");
            return -1;
        } else {
            if (verbose) System.out.println("Push (Tie)!");
            return 0;
        }
    }

    /**
     * Returns a string representation of the current game state.
     * @return game state text
     */
    public String toString() {
        return "Player: " + playerHand.toString() + "\nDealer: " + dealerHand.toString();
    }

    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        
        System.out.println("--- GAME 1 ---");
        game.game(true); 
        
        System.out.println("\n--- GAME 2 ---");
        game.game(true); 
        
        System.out.println("\n--- GAME 3 ---");
        game.game(true); 
    }
}
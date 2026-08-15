/*
file name:      DeckTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea DeckTests
*/

public class DeckTests {

    public static void deckTests() {

        // case 1: testing Deck() and size()
        {
            Deck d1 = new Deck();
            System.out.println(d1);
            assert d1 != null : "Error in Deck::Deck()";
            assert d1.size() == 52 : "Error in Deck::Deck()";
        }

        // case 2: testing deal()
        {
            Deck d1 = new Deck();
            Card c1 = d1.deal();
            assert d1 != null : "Error in Deck::deal()";
            assert c1 != null : "Error in Deck::deal()";
            assert d1.size() == 51 : "Error in Deck::deal()";
        }

        // case 3: testing build()
        {
            Deck d1 = new Deck();
            Card c1 = d1.deal();
            Card c2 = d1.deal();
            Card c3 = d1.deal();
            d1.build();
            assert d1 != null : "Error in Deck::build()";
            assert c1 != null : "Error in Deck::deal()";
            assert c2 != null : "Error in Deck::deal()";
            assert c3 != null : "Error in Deck::deal()";
            assert d1.size() == 52 : "Error in Deck::build()";
        }

        // case 4: testing shuffle()
        {
            Deck d1 = new Deck();
            String before = d1.toString();
            d1.shuffle();
            String after = d1.toString();
            assert !before.equals(after) : "Error in Deck::shuffle()";
            assert d1.size() == 52 : "Error in Deck::shuffle()";
        }

        // case 5: check correct number of each card
        {
            Deck d1 = new Deck();
            int[] counts = new int[12]; // Create buckets for cards 2-11
            
            while(d1.size() > 0){
                Card c = d1.deal();
                counts[c.getValue()]++;
            }
            
            for(int i = 2; i <= 9; i++){
                assert counts[i] == 4 : "Error: Did not find exactly 4 of card value " + i;
            }
            assert counts[10] == 16 : "Error: Did not find exactly 16 of card value 10";
            assert counts[11] == 4 : "Error: Did not find exactly 4 of card value 11";
        }

        // case 6: check reshuffle randomness (two consequent shuffles should be distinct)
        {
            Deck d1 = new Deck();
            d1.shuffle();
            String shuffle1 = d1.toString();
            
            d1.shuffle();
            String shuffle2 = d1.toString();
            
            assert !shuffle1.equals(shuffle2) : "Error: Deck configurations were identical across shuffles (not random)";
        }

        System.out.println("*** Done testing Deck! ***\n");
    }

    public static void main(String[] args) {
        deckTests();
    }
}
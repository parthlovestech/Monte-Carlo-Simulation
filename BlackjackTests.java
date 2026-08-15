/*
file name:      BlackjackTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea BlackjackTests
*/

public class BlackjackTests {

    public static void blackjackTests() {

        Blackjack game = new Blackjack();
        int playerWins = 0;
        int dealerWins = 0;
        int draws = 0;
        int totalGames = 10000;
        
        // Simulate 10,000 games
        for(int i = 0; i < totalGames; i++) {
            int result = game.game(false);
            if(result == 1) playerWins++;
            else if(result == -1) dealerWins++;
            else draws++;
        }
        
        double drawPercent = (draws * 100.0) / totalGames;
        double dealerPercent = (dealerWins * 100.0) / totalGames;
        double playerPercent = (playerWins * 100.0) / totalGames;
        
        System.out.printf("Draw percent: %.2f\n", drawPercent);
        System.out.printf("Dealer win percent: %.2f\n", dealerPercent);
        System.out.printf("Player win percent: %.2f\n", playerPercent);

        // Verification checks to ensure rules are implemented roughly correctly
        assert Math.abs(drawPercent - 8) <= 2 : "Draw percent out of bounds (Expected 8 +/- 1)";
        assert Math.abs(dealerPercent - 49) <= 2 : "Dealer win percent out of bounds (Expected 49 +/- 1)";
        assert Math.abs(playerPercent - 41) <= 2 : "Player win percent out of bounds (Expected 41 +/- 1)";
        
        System.out.println("\n*** Done testing Blackjack! ***\n");
    }

    public static void main(String[] args) {
        blackjackTests();
    }
}
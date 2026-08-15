/*
file name:      Simulation.java
Authors:        Parth Thapa Chhetri
last modified:  2/25
Purpose:        Runs thousands of automated Blackjack games to collect and calculate statistical win/loss probabilities.
*/
public class Simulation {
    
    /**
     * Runs a given number of simulated Blackjack games and calculates the outcome percentages.
     * @param numberOfGames the amount of games to simulate
     */
    public static void runSimulation(int numberOfGames) {
        Blackjack game = new Blackjack();
        
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        
        for (int i = 0; i < numberOfGames; i++) {
            int result = game.game(false); // run silently
            if (result == 1) {
                playerWins++;
            } else if (result == -1) {
                dealerWins++;
            } else {
                pushes++;
            }
        }
        
        double playerPercent = (playerWins * 100.0) / numberOfGames;
        double dealerPercent = (dealerWins * 100.0) / numberOfGames;
        double pushPercent = (pushes * 100.0) / numberOfGames;
        
        System.out.println("--- Simulation Results: " + numberOfGames + " Games ---");
        System.out.printf("Player Win Percentage: %.2f%%\n", playerPercent);
        System.out.printf("Dealer Win Percentage: %.2f%%\n", dealerPercent);
        System.out.printf("Push (Tie) Percentage: %.2f%%\n\n", pushPercent);
    }
    
    public static void main(String[] args) {
        // Run experiments specifically requested in the rubric exploration section
        runSimulation(100);
        runSimulation(1000);
        runSimulation(10000);
    }
}
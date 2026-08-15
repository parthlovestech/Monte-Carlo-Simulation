# Monte Carlo Simulation of Blackjack: Quantitative House Edge Analysis

An object-oriented Java application designed to simulate, aggregate, and analyze the mathematical probabilities, short-term statistical variances, and long-term house advantages within the game of Blackjack.

## Project Overview and Statistical Findings

This system utilizes Monte Carlo methods to automate large-scale game execution, evaluating how sample size impacts statistical convergence and validating the Law of Large Numbers within empirical gaming models.

### Key Analytical Conclusions
* **Algorithmic House Advantage:** The simulation demonstrates that the dealer maintains a stable, long-term mathematical advantage over the player. While short-term variance allows for localized player winning streaks across minor sample sizes (10 to 100 iterations), execution over extended volumes demonstrates data stabilization favoring the casino.
* **Procedural Rule Disadvantage:** The structural discrepancy in win rates—wherein the dealer wins approximately 49% of games compared to the player's 41%—is primarily driven by sequential gameplay rules. Because the player must act first, a player bust terminates the round immediately, eliminating any subsequent risk of the dealer busting.

### Simulation Metrics Table

| Iterations (Sample Size) | Player Win % | Dealer Win % | Push (Tie) % |
| :--- | :--- | :--- | :--- |
| **100** | 44.00 | 46.00 | 10.00 |
| **1,000** | 42.10 | 49.30 | 8.60 |
| **10,000** | 41.45 | 49.75 | 8.80 |

---

## Technical Stack and Architecture

The application is engineered entirely in Java using Object-Oriented Programming (OOP) design patterns to cleanly segregate domain logic and state tracking:

* **Card Class:** Encapsulates raw card attributes, values, and state representation.
* **Hand Class:** Dynamically computes total hand values, manages hitting/standing states, and evaluates bust thresholds.
* **Deck Class:** Utilizes dynamically sized `ArrayList` collections to manage card states and handle physical array manipulation.
* **Pseudorandom Generation:** Implements the native Java `Random` class to model stochastic shuffling mechanics and unbiased distribution profiles.

---

## Console Output Documentation

The automated driver tracks state transitions from the initial distribution to the terminal state determination. Below are structural transcriptions of the console logger:

### Execution Profile: Player Win via Dealer Evaluation Conflict
```text
Initial Deal:
Player: [10, 6] : 16
Dealer: [10, 4] : 14

Dealer busted! Player wins.

Final State:
Player: [10, 6] : 16
Dealer: [10, 4, 11] : 25
```

### Execution Profile: Player Win via Maximum Value Attainment
```text
Initial Deal:
Player: [7, 4] : 11
Dealer: [10, 10] : 20

Final State:
Player: [7, 4, 10] : 21
Dealer: [10, 10] : 20

Player wins!
```

---

## Local Deployment Instructions

### System Prerequisites
* Java Development Kit (JDK) version 8 or higher.
* Command-line terminal interface or a supported Java Integrated Development Environment (IDE).

### Build and Compilation Sequence

1. Clone the project files to the target workspace local machine:
   ```bash
   git clone https://github.com
   ```

2. Change directories into the root source folder layout:
   ```bash
   cd blackjack-monte-carlo
   ```

3. Compile all native Java source elements:
   ```bash
   javac *.java
   ```

4. Execute the primary driver application (Note: Replace `Main` with the exact entry point class identifier if different):
   ```bash
   java Main
   ```

---
*Note: This repository represents coursework completed within the Computer Science Department curriculum.*

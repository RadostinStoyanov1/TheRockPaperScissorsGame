import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random ran = new Random();

        final String rock = "Rock";
        final String paper = "Paper";
        final String scissors = "Scissors";
        int playerRockCounter = 0;
        int playerPaperCounter = 0;
        int playerScissorsCounter = 0;
        int computerRockCounter = 0;
        int computerPaperCounter = 0;
        int computerScissorsCounter = 0;
        int playerLoseCounter = 0;
        int playerWinCounter = 0;
        int equalResultCounter = 0;
        boolean isStop = false;
        int gameCounter = 0;

        while (!isStop) {

            System.out.print("Type [stop] to finish the game or Please choose between [r]rock, [p]paper or [s]scissors: ");
            String playerChoice = "";

            for (; ; ) {
                playerChoice = scanner.next();
                if (playerChoice.equals("r") || playerChoice.equals("R") || playerChoice.equals("rock") || playerChoice.equals("Rock")) {
                    playerChoice = rock;
                    playerRockCounter++;
                    break;
                } else if (playerChoice.equals("p") || playerChoice.equals("P") || playerChoice.equals("paper") || playerChoice.equals("Paper")) {
                    playerChoice = paper;
                    playerPaperCounter++;
                    break;
                } else if (playerChoice.equals("s") || playerChoice.equals("S") || playerChoice.equals("scissors") || playerChoice.equals("Scissors")) {
                    playerChoice = scissors;
                    playerScissorsCounter++;
                    break;
                } else if (playerChoice.equals("stop") || playerChoice.equals("STOP")) {
                    isStop = true;
                    break;
                } else {
                    System.out.println("Invalid input. Please choose between [r]rock, [p]paper or [s]scissors: ");
                }
            }

            if (isStop) {
                break;
            }

            int computerRandomNumber = ran.nextInt(4); // choosing 4 options will allow to include one option which computer will always lose!
            String computerMove = "";

            switch (computerRandomNumber) {
                case 0:
                    computerMove = rock;
                    computerRockCounter++;
                    break;
                case 1:
                    computerMove = paper;
                    computerPaperCounter++;
                    break;
                case 2:
                    computerMove = scissors;
                    computerScissorsCounter++;
                    break;
                case 3: // In this option player will always win. Therefore, there is a check of player's choice.
                    // if we want to make the game more difficult, then case 3 should be excluded and random integer bound should be decreased to 3.
                    if (playerChoice.equals(rock)) {
                        computerMove = scissors;
                        computerScissorsCounter++;
                        break;
                    } else if (playerChoice.equals(paper)) {
                        computerMove = rock;
                        computerRockCounter++;
                        break;
                    } else if (playerChoice.equals(scissors)) {
                        computerMove = paper;
                        computerPaperCounter++;
                        break;
                    }
            }

            System.out.printf("The computer choose: %s%n", computerMove);

            if ((playerChoice.equals(rock) && computerMove.equals(scissors)) || (playerChoice.equals(paper) && computerMove.equals(rock)) ||
                    (playerChoice.equals(scissors) && computerMove.equals(paper))) {
                System.out.println("You win!");
                playerWinCounter++;
            } else if ((playerChoice.equals(rock) && computerMove.equals(paper)) || (playerChoice.equals(paper) && computerMove.equals(scissors)) ||
                    (playerChoice.equals(scissors) && computerMove.equals(rock))) {
                System.out.println("You lose.");
                playerLoseCounter++;
            } else if ((playerChoice.equals(rock) && computerMove.equals(rock)) || (playerChoice.equals(paper) && computerMove.equals(paper)) ||
                    (playerChoice.equals(scissors) && computerMove.equals(scissors))) {
                System.out.println("The result of the game is a draw.");
                equalResultCounter++;
            }

            gameCounter++;

            System.out.println("The game will continue. If you would like to finish it, just type [stop] below:");

        }

        System.out.printf("You played %d games.%n", gameCounter);
        System.out.printf("You won %d games.%n", playerWinCounter);
        System.out.printf("You lose %d games.%n", playerLoseCounter);
        System.out.printf("Draw games %d.%n", equalResultCounter);
        System.out.printf("You used Rock: %d times; Paper %d times and Scissors: %d times.%n", playerRockCounter, playerPaperCounter, playerScissorsCounter);
        System.out.printf("Computer used Rock: %d times; Paper %d times and Scissors: %d times.%n", computerRockCounter, computerPaperCounter, computerScissorsCounter);

    }
}

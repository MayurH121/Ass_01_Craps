import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.println("Welcome to the CRAPS game! Rolling your dice now:");
            int die1 = random.nextInt(6) + 1; // Random number for dice 1
            int die2 = random.nextInt(6) + 1; // Random number for dice 2
            int crapsRoll = die1 + die2; // Sum of the two dice

            System.out.println("You rolled " + die1 + " and " + die2 + ". Your total is: " + crapsRoll);

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) { // Numbers for losing
                System.out.println("Crapping out! Sorry, you lost.");
            } else if (crapsRoll == 7 || crapsRoll == 11) { // Numbers for winning
                System.out.println("Natural! You won!");
            } else { // All other numbers will be looped until the player wins or loses
                int point = crapsRoll;
                System.out.println("Point is set to " + point + ". Rolling again...");

                while (true) {
                    int newDie1 = random.nextInt(6) + 1;
                    int newDie2 = random.nextInt(6) + 1;
                    int newRoll = newDie1 + newDie2;

                    System.out.println("You rolled: " + newDie1 + " + " + newDie2 + " = " + newRoll);

                    if (newRoll == point) {
                        System.out.println("You rolled the point! You win!");
                        break;
                    } else if (newRoll == 7) {
                        System.out.println("You rolled a 7! Sorry, you lose.");
                        break;
                    } else {
                        System.out.println("Rolling again...");
                    }
                }
            }

            // Ask the user if they want to play again
            while (true) {
                System.out.println("Do you want to play again? (y/n)"); // Consistent prompt
                String input = scanner.next();

                if (input.equalsIgnoreCase("n")) {
                    continuePlaying = false;
                    break;
                } else if (input.equalsIgnoreCase("y")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            }
        }

        System.out.println("Thanks for playing CRAPS! Goodbye!");
        scanner.close();
    }
}
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rng = new Random();
        Scanner scan = new Scanner(System.in);
        boolean isRun = true;
        int chances = 0;
        String[] diff = {"Easy", "Medium", "Hard"};
        String[] welcome = start();
        System.out.println(welcome[0]);

        while(isRun){
            System.out.println(welcome[1]);
            System.out.print("Enter your choice: ");
            int lvl = scan.nextInt();

            switch(lvl){
                case 1 -> chances = 10;
                case 2 -> chances = 5;
                case 3 -> chances = 3;
                default -> {
                    System.out.println("Invalid number");
                    isRun = false;
                }
            }
            System.out.printf("\nGreat! You have selected the %s difficulty level.\nLet's start the game", diff[lvl-1]);
            int theNum = rng.nextInt(1, 101);
            for(int i =0; i < chances; i++){
                System.out.print("\n\nEnter your guess: ");
                int guess = scan.nextInt();

                if(guess == theNum){
                    System.out.printf("Congratulations! You guessed the correct number in %d attempts.", i);
                    i = 999;
                }
                else if(guess > theNum){
                    System.out.printf("Incorrect! The number is less than %d", guess);
                }
                else{
                    System.out.printf("Incorrect! The number is greater than %d", guess);
                }
            }
            System.out.println("\n\nWanna play again? (true/false): ");
            isRun = scan.nextBoolean();
        }

        scan.close();
    }
    public static String[] start(){
        String wc = """
                Welcome to the Number Guessing Game!
                I'm thinking of a number between 1 and 100.
                You have 5 chances to guess the correct number.\n""";
        String rules = """
                Please select the difficulty level:
                1. Easy (10 chances)
                2. Medium (5 chances)
                3. Hard (3 chances)\n""";
        String[] sysOut = new String[2];
        sysOut[0] = wc;
        sysOut[1] = rules;
        return sysOut;
    }
}

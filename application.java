import java.util.Scanner;
public class application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Hello. Let's play some Scrabble!");
        System.out.println("--------------------------------");
        System.out.println(" ");

        //Loop to create players
        for (int i = 0; i < 2; i++) {

            System.out.println("Enter the name of player "+ (i + 1) +" : ");
            String playerName = scanner.next();
            System.out.println(playerName);

            //create an array to store players?
            //call player class
        }
    }
}

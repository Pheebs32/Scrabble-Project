import java.util.Arrays;
import java.util.Scanner;
public class application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Let's play some Scrabble!");
        System.out.println("--------------------------------");
        System.out.println(" ");

        //create the players
        String[] playerNames = new String[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the name of player "+ (i+1) +" : ");
            playerNames[i] = scanner.next();
        }
        player one = new player();
        player two = new player();
        one.setName(playerNames[0]);
        two.setName(playerNames[1]);
        System.out.println(one.getName());



        //test methods for Game class
        System.out.println("begin board initialization");
        Game game = new Game();
        System.out.println("board initialization complete");

        System.out.println(game.validateWord("HELLO"));
        System.out.println(game.validateWord("PILOT"));
        System.out.println(game.validateWord("DDEINUBIUYISVY"));

        //System.out.println('Hello score: " + game.calculateWordScore("HELLO"));

    }
}

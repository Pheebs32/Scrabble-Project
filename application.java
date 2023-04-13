import java.util.Scanner;
public class application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Hello. Let's play some Scrabble!");
        System.out.println("--------------------------------");
        System.out.println(" ");

        //Loop to create players
//        for (int i = 0; i < 2; i++) {
//
//            System.out.println("Enter the name of player "+ (i + 1) +" : ");
//            String playerName = scanner.next();
//            System.out.println(playerName);
//
//            //create an array to store players?
//            //call player class
//        }

        //test methods for Game class
        System.out.println("begin board initialization");
        Game game = new Game();
        System.out.println("board initialization complete");

        System.out.println(game.validateWord("HELLO"));
        System.out.println(game.validateWord("PILOT"));
        System.out.println(game.validateWord("DDEINUBIUYISVY"));

    }
}

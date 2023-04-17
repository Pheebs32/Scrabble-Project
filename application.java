import java.util.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Let's play some Scrabble!");
        System.out.println("--------------------------------");
        System.out.println(" ");

        //Game and gameplay is initialized
        Game game = new Game();
        gameplay gameplay = new gameplay();

        //create two new players
        player[] players = new player[2];
        for (int i = 0; i < players.length; i++) {
            System.out.println("Enter the name of player "+ (i+1) +" : ");
            players[i] = new player(scanner.next(), i, new String[7]);
        }

        // TODO: should visualize the board to user
        //managing turns
        //maybe instead create another class? 'changeTurn' that takes player, and turn #
        //should be managed in gameplay??
        int turn = 1;
        boolean gameOn = true;

        //player one plays first
        player playa = new player("", 3, new String[7]);
        // TODO: fix how players are stored
        while (gameOn) {
            if (turn == 1) {
                playa = players[0];
                System.out.println("Turn 1");
            } else if (turn == 2) {
                playa = players[1];
                System.out.println("Turn 2");
            }
        }
        while (gameOn) {
            System.out.println(game.toString());
            gameplay.refillTray(playa);
            gameplay.showTray(playa);
            System.out.println(playa.getName() + ", enter a word (Skip: *, Quit: #");
            String theWord = scanner.next();

            if (theWord.equals("*")) {
                System.out.println("You have decided to skip your turn.");
                System.out.println("");
                turn = 2;
            } else if (theWord.equals("#")) {
                System.out.println("You have decide to quit the game.");
                gameOn = false;
            } else {
                if (game.validateWord(theWord) == true) {
                    System.out.println(theWord + " if valid!");
                    //place word on board
                    //calculate score
                    //add score to total
                } else {
                    System.out.println(theWord + "is not valid.");
                    System.out.println("");
                    turn = 2;
                }
            }
        }
    }
}

import java.util.*;
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
        player one = new player("", 1, new String[7]);
        player two = new player("", 2, new String[7]);
        String[] playerNames = new String[2];
        for (int i = 0; i < playerNames.length; i++) {
            System.out.println("Enter the name of player "+ (i+1) +" : ");
            playerNames[i] = scanner.next();
        }
        one.setName(playerNames[0]);
        two.setName(playerNames[1]);

        // TODO: should visualize the board to user
        //managing turns
        //maybe instead create another class? 'changeTurn' that takes player, and turn #
        //should be managed in gameplay??
        int turn = 1;
        boolean gameOn = true;

        //player one plays first
        while (gameOn) {
            if (turn == 1) {
                gameplay.refillTray(one);
                gameplay.showTray(one);
                System.out.println(one.getName() +", type a word ro start with (Skip: *, quit: #)");
                String theWord = scanner.next();

                if (theWord.equals("*")) {
                    System.out.println("You decided to skip your turn.");
                    System.out.println("");
                    turn = 2;
                } else if (theWord.equals("#")) {
                    gameOn = false;
                }
                else {
                    //check if the word is valid itself and placement if valid and uses the tray
                    if (game.validateWord(theWord) == true) {
                        System.out.println(theWord +" is valid!");
                        turn = 2;
                        //place word on board
                        //calculate score
                        //add score to total score
                    } else {
                        //if word isn't working
                        //put letters back in tray
                        System.out.println("Sorry your word isn't valid.");
                        System.out.println("");
                        turn = 1;
                    }
                }
            } else if (turn == 2) {
                // draw board
                gameplay.refillTray(two);
                gameplay.showTray(two);
                System.out.println(two.getName() +", type a word ro start with (Skip: *, quit: #)");
                String theWord = scanner.next();

                if (theWord.equals("*")) {
                    System.out.println("You decided to skip your turn.");
                    System.out.println("");
                    turn = 1;
                } else if (theWord.equals("#")) {
                    gameOn = false;
                }
                else {
                    //check if the word is valid itself and placement if valid and uses the tray
                    if (game.validateWord(theWord) == true) {
                        System.out.println(theWord +" is valid!");
                        turn = 1;
                        //place word on board
                        //calculate score
                        //add score to total score
                    } else {
                        //if word isn't working
                        //put letters back in tray
                        System.out.println("Sorry your word isn't valid.");
                        System.out.println("");
                        turn = 2;
                    }
                }
            }
        }
    }
}

import java.util.*;
public class application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Let's play some Scrabble!");
        System.out.println("--------------------------------");
        System.out.println(" ");

        //players are created
        String[] playerNames = new String[2];
        for (int i = 0; i < playerNames.length; i++) {
            System.out.println("Enter the name of player "+ (i+1) +" : ");
            playerNames[i] = scanner.next();
        }
        player one = new player();
        player two = new player();
        one.setName(playerNames[0]);
        two.setName(playerNames[1]);



        //game is initialized
        Game game = new Game();
        //System.out.println("board initialization complete");

        //System.out.println('Hello score: " + game.calculateWordScore("HELLO"));

        // TODO: should visualize the board to user

        // TODO: create user 1 their set of letters and show them

        //build logic so it loops though the different players turns
        //get random set of 7 letters from all available tiles
        String[] letterBunch = new String[7];
        // TODO: get 7 letter tiles
        Random random = new Random();
        one.setLetters(letterBunch);

        //loops through the players turns -- TODO
        System.out.println(one.getName() +", type a word to start with.");
        String theWord = scanner.next();
        //check if the word is valid
        if (game.validateWord(theWord) == true) {
            System.out.println(theWord +" is valid!");
        }
        /*
        TODO: check if the word is being placed in a valid location and valid with surrounding letters
        TODO: place word on board
        TODO: remove letter from player 1
        TODO: calculate score for player 1
        TODO: add score to table
        TODO: refill player 1's tray
        TODO: player 2 plays -- loops there on after
        */


    }


}

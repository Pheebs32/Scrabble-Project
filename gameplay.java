import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
// This class handles move validation and score handling
// It also handles tileBag and tileScores
public class gameplay {
    private HashMap<Character, Integer> tileBag;
    private player[] players = new player[2];
    private int turn;
    public gameplay() {
        this.initTileBag();

    }

    //Tile bag initialization and distribution
    //Values taken from : 'thesprucecrafts.com/scrabble-tile-distribution-and-point-values-412402'
    // TODO: Find a way to read these values from the file
    private void initTileBag() {
        this.tileBag = new HashMap<Character, Integer>();
        if (this.tileBag.isEmpty()) {
            this.tileBag.put('A', 9);
            this.tileBag.put('B', 2);
            this.tileBag.put('C', 2);
            this.tileBag.put('D', 4);
            this.tileBag.put('E', 12);
            this.tileBag.put('F', 2);
            this.tileBag.put('G', 3);
            this.tileBag.put('H', 2);
            this.tileBag.put('I', 9);
            this.tileBag.put('J', 1);
            this.tileBag.put('K', 1);
            this.tileBag.put('L', 4);
            this.tileBag.put('M', 2);
            this.tileBag.put('N', 6);
            this.tileBag.put('O', 8);
            this.tileBag.put('P', 2);
            this.tileBag.put('Q', 1);
            this.tileBag.put('R', 6);
            this.tileBag.put('S', 4);
            this.tileBag.put('T', 6);
            this.tileBag.put('U', 4);
            this.tileBag.put('V', 2);
            this.tileBag.put('W', 2);
            this.tileBag.put('X', 1);
            this.tileBag.put('Y', 2);
            this.tileBag.put('Z', 1);
        }
    }

    /*
    used when game starts and after each move
    @param C    tile to be removed
    @return     removed successfully
    */
    public boolean removeTileFromBag(char C) {
        if (this.tileBag.containsKey(C) && this.tileBag.get(C) > 0) {
            int newValue = this.tileBag.get(C) - 1;
            this.tileBag.put(C, newValue);
            return true;
        }
        return false;
    }
    /*
    used when players give up their turns
    @param C    tile added back to bag
    @return     added successfully
    */
    public boolean addTileToBag(char C) {
        if (this.tileBag.containsKey(C)) {
            int newValue = this.tileBag.get(C) + 1;
            this.tileBag.put(C, newValue);
            return true;
        }
        return false;
    }
    /*
    used when players give up their turns
    @param C    Letter missing from the tray
    */
    public Object getRandomLetterFromBag(char C) {
        Random random = new Random();
        Object[] letters = this.tileBag.keySet().toArray();
        Object randomLetter = letters[random.nextInt(letters.length)];

        if (this.tileBag.get(randomLetter) == 0) {
            //Need to call function recursively
        } else {
            int newValue = this.tileBag.get(randomLetter) - 1;
            this.tileBag.put((Character) randomLetter, newValue);
            System.out.println(randomLetter);
        }
        return randomLetter;
    }


    public void createNewPlayers() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < players.length; i++) {
            System.out.println("Enter the name of player "+ (i+1) +" : ");
            players[i] = new player(scanner.next(), i, new String[7]);
        }
    }

    public void endGame() {
        System.out.println("Game Over!");
        System.out.println("Thank for playing " + players[0].getName() + " and " + players[1].getName() + "!");

    }
    public int switchTurn() {
        if (turn == 1 || turn == 0) {
            turn = 2;
        } else if (turn == 2) {
            turn = 1;
        }
        return turn;
    }
    public void gameOn(int turn) {
        player thePlayer = null;
        if (turn == 1) {
            thePlayer = players[0];
        } else if (turn == 2) {
            thePlayer = players[1];
        }
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        //hiding the board for now for testing purposes
        //System.out.println(game.toString());
        refillTray(players[0]);
        //showTray(players[0]);
        System.out.println(players[0].getName() +", enter a word (Skip: *, Quit: #");
        String theWord = scanner.next();

        if (theWord.equals("*")) {
            System.out.println("You decided to skip you turn.");
            System.out.println("");
            gameOn(switchTurn());
        } else if (theWord.equals("#")) {
            endGame();
        } else {
            if (Game.validateWord(theWord) == true) {
                System.out.println(theWord + " is valid!");
                //place word on board
                //calculate score
                //add score to total score
                gameOn(switchTurn());
            } else {
                //if word isn't working
                //put letters back in tray
                System.out.println("Sorry " + theWord + " is invalid");
                System.out.println("");
                gameOn(switchTurn());
            }
        }
    }


    public void refillTray(player player) {
        String[] lettersTray = player.getLetters();
        int lettersMissing = 0;
        for (int i = 0; i < lettersTray.length; i++) {
            if (lettersTray[i] == "" || lettersTray[i] == null) {
                lettersTray[i] = String.valueOf(this.getRandomLetterFromBag('i'));
            }
        }
        player.setLetters(lettersTray);
    }
    public void showTray(player player) {
        System.out.println(player.getName() +", your turn: ");
        for (int i = 0; i < player.getLetters().length; i++) {
            System.out.println(player.getLetters()[i] + " ");
        }
        System.out.println(" ");
    }
}

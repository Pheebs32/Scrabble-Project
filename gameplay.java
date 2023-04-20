import java.util.ArrayList;
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
        System.out.println(game);
        refillTray(thePlayer);
        showTray(thePlayer);
        System.out.println(players[0].getName() +", enter a word (Skip: *, Quit: #");
        String theWord = scanner.next();

        if (theWord.equals("*")) {
            System.out.println("You decided to skip you turn.");
            gameOn(switchTurn());
        } else if (theWord.equals("#")) {
            endGame();
        } else {
            if (Game.validateWord(theWord)) {
                System.out.println(theWord + " is valid!");
                //place word on board
                //calculate score
                //add score to total score
                gameOn(switchTurn());
            } else {
                System.out.println("Sorry " + theWord + " is invalid");
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
    /*
    @param move move object played
    @return     boolean
    */
    public boolean isMoveValid(player player, move move, Game game) {
        String word = move.word;
        int row = move.startRow;
        int col = move.startCol;
        int dir = move.direction;
        //char[] tileCopy = player.getLetters():
        boolean tilesPresent = false;

        //does board overflow?
        if ((dir == move.RIGHT && (col + word.length() > 14)) ||
                (dir == move.DOWN && (row + word.length() > 14))) {
            System.out.println("Board overflow. Invalid move!");
            return false;
        }
        //is word valid using dictionary?
        if (!Game.validateWord(word)) {
            System.out.println("Word doesn't exist in Dictionary.");
            return false;
        }
        //does player have enough tiles to play
        if (!this.doesPlayerHaveTiles(player, move, game)) {
            System.out.println("Not enough tiles to play move!");
            return false;
        }

        //if it's the first move of the game does the work cross the centre X?
        if (move.totalNumberOfMoves == 0 && (row > 7 && col > 7)) {
            System.out.println("First move should touch the center of the board.");
            return false;
        }
        //does the second (or greater) move touch an existing tile
        if (move.totalNumberOfMoves > 0) {
            for (int i = 0; i < word.length(); i++) {
                if (dir == move.DOWN) {
                    if (game.getTileOnBoard(row, col + i) != ' ') { tilesPresent = true; }
                    } else if (dir == move.DOWN) {
                        if (game.getTileOnBoard(row + 1, col) != ' ') { tilesPresent = true; }
                    }
                }
            if (!tilesPresent) {
                System.out.println("New word has to touch an existing word.");
                return false;
            }
        }

        //can that word be constructed on the board
        // TODO: what if you wish to play 'road' with a present 'R' but there is an 'F' instead of a 'D'

        //intended word should be the largest contiguous string in that direction
        if (dir == move.RIGHT) {
            if (game.getTileOnBoard(row, col + word.length() + 1) != ' ' ||
                    game.getTileOnBoard(row, col - 1) != ' ') {
                System.out.println("Incomplete input word?");
                return false;
            }
        } else if (dir == move.DOWN) {
            if (game.getTileOnBoard(row + word.length() + 1, col) != ' ' ||
                    game.getTileOnBoard(row - 1, col) != ' ') {
                System.out.println("Incomplete input word?");
                return false;
            }
        }

        //are secondary words valid if existing
        ArrayList<String> secList = this.getSecondaryWords(move, game);
        if (!this.validateSecondaryWords(secList)) {
            System.out.println("Invalid secondary word created.");
            return false;
        }
        move.isValid = true;
        return true;
    }

    private boolean doesPlayerHaveTiles(player player, move move, Game game) {
        return false;
    }

    private boolean validateSecondaryWords(ArrayList<String> list) {
        for (String str: list) {
            if (!Game.validateWord(str)) {
                System.out.println(str+ " not valid secondary word.");
                return false;
            }
        }
        return true;
    }

    /*
    private helper method that returns the other words formed due to a move
    @param move     current move
    @param board    board object
    @return         list containing secondary words
    */
    // TODO: change to private once testing is complete
    public ArrayList<String> getSecondaryWords (move move, Game game){
        ArrayList<String> secWords = new ArrayList<String>();
        String word = move.word.toUpperCase();
        int row = move.startRow;
        int col = move.startCol;
        int dir = move.direction;

        for (int i = 0; i < word.length(); i++) {
            if (dir == move.RIGHT) {
                if (game.getTileOnBoard(row, col + i) == ' ') {
                    //user is inserting a tile
                    if (game.getTileOnBoard(row - 1, col + i) == ' ' ||
                            game.getTileOnBoard(row + 1, col + i) != ' ') {
                        System.out.println("calling construct word for: " + word.charAt(i));
                        secWords.add(this.constructWord(row, col + i, word.charAt(i), move, game));
                    }
                }
            } else if (dir == move.DOWN) {
                if (game.getTileOnBoard(row + i, col) == ' ') {
                    if (game.getTileOnBoard(row + i, col - 1) != ' ' ||
                            game.getTileOnBoard(row + i, col + 1) != ' ') {
                        System.out.println("calling construct word for: " + word.charAt(i));
                        secWords.add(this.constructWord(row + i, col, word.charAt(i), move, game));
                    }
                }
            }
        }
        return secWords;
    }

    /*
    private helper method that returns the other words formed due to a move
    @param row  row index
    @param col  col index
    @param C
    @return     constructed word/ null
    */
    private String constructWord(int row, int col, char C, move move, Game game) {
        StringBuilder newWord = new StringBuilder();
        int start;
        int end;
        int i = 1;
        int j = 1;
        int dir = move.direction;
        //String word = move.word;
        C = Character.toUpperCase(C);

        if (dir == move.DOWN) {
            System.out.println("dir down");
            while (col - j >= 0 && game.getTileOnBoard(row, col - j) != ' ') {
                j++;
            }
            start = col - j + i;
            j = 1; //reset j

            while (col + j <= 14 && game.getTileOnBoard(row, col + j) != ' ') {
                    j++;
                }
            end = col + j - 1;

            for (int newCol = start; newCol <= end; newCol++) {
                if (newCol == col)    {newWord.append(C);}
                else { newWord.append(game.getTileOnBoard(row, newCol)); }
            }
            return newWord.toString().trim();
        } else if (dir == move.RIGHT) {
            System.out.println("dir right");
            while (row - i >= 0 && game.getTileOnBoard(row - i, col) != ' ') {
                i++;
            }
            start = row - i + 1;
            i = 1;

            while (row + i <= 14 && game.getTileOnBoard(row + i, col) != ' ') {
                i++;
            }
            end = row + i - 1;
            for (int newRow = start; newRow <= end; newRow++) {
                if (newRow == row) {
                    newWord.append(C);
                } else {
                    newWord.append(game.getTileOnBoard(newRow, col));
                }
            }
            return newWord.toString().trim();
        }
        System.out.println("Constructing null");
        return null;
    }
}

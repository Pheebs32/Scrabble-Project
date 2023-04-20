/*
1. Constructs words out of tiles
2. Checks if word is valid using Game method
3. If word is valid, ask Game to place the word
4. If word is not valid, either give it back to player or put back on the board
5. If word is valid, return the total score to the player
-----
*/

import java.util.ArrayList;

class move {
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    static int totalNumberOfMoves = 0;
    String word;
    int direction;
    int startRow;
    int startCol;
    boolean isValid;

    /*
    Constructs a move object
    @param word -       the word to be constructed
    @param direction -  direction
    @param startRow -   starting row coordinate of the move
    @param startCol -   starting col coordinate of the move
    */
    public move(String word, int direction, int startRow, int startCol) {
        // TODO: add invalid argument checks
        this.word = word;
        this.direction = direction;
        this.startRow = startRow;
        this.startCol = startCol;
        this.isValid = false;
        move.totalNumberOfMoves++;
    }

    /*
    to check the game state (valid + invalid)
    @return # of moves
    */
    public static int movesPlayedSoFar() {
        return move.totalNumberOfMoves;
    }


    // @return computes total score of a word
    public int computeWordScore() {
        return -1;
    }
    /*
    Implements an algorithm to compute if the move is correct
    @param word player's input
    @return     T/F if move is valid
    */
    // might not be necessary
    public boolean isWordValid(String word) {
        return Game.validateWord(word);
    }
    public boolean registerMove() {
        return false;
    }
}

/*
1. Constructs words out of tiles - maybe land with player?
    WORD REPRESENTATION
2. Checks if word is valid using Game method
3. If word is valid, ask Game to place the word
4. If word is not valid, either give it back to player or put back on the board
5. If word is valid, return the total score to the player
-----
*/

public class move {
    char[] word;
    int direction;
    int coordinate; //Starting coordinates of a word
    boolean isValid;
    /*
    Constructs a move object
    @param word
    @param direction
    @param coordinate
    */
    public move(char[] word, int direction, int coordinate) {

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
    public boolean isWordValid(char[] word) {
        return false;
    }
    public boolean registerMove() {
        return false;
    }
}

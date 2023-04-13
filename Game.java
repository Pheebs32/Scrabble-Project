/*
    Name: Phoebe Swaine
    Date: 13/04/23
    Project: Scrabble board-game
*/

import java.util.HashMap;
//Game class for Scrabble - Handles the game logic
// TODO: convert this to a Singleton since only one object should ever be required

public class Game {
    char[][] scrabbleBoard;
    int numberOfPlayers;
    HashMap tileBag;

    public Game(int numberOfPlayers) {
        this.scrabbleBoard = new char[15][15];
        this.tileBag = new HashMap<Character, Integer>();
    }

    //Initializes the scrabble board
    private void initBoard() {

    }

    //Tile bag initialization and distribution
    //Values taken from : 'thesprucecrafts.com/scrabble-tile-distribution-and-point-values-412402'
    private void initTileBag() {
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

}

/*
    Name: Phoebe Swaine
    Date: 13/04/23
    Project: Scrabble board-game
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

//Game class for Scrabble - Handles the game logic
// TODO: convert this to a Singleton since only one object should ever be required
// TODO: change HashSet implementation of dict

public class Game {
    char[][] scrabbleBoard;
    HashMap<Character, Integer> tileBag;
    HashMap<Character, Integer> tileScore;
    HashSet<String> dict;

    public Game() {
        this.scrabbleBoard = new char[15][15];
        this.dict = new HashSet<String>();
        this.initTileBag();
        this.initTileScore();

        try { this.initDict(); }
        catch (FileNotFoundException e) {
            System.err.println("FileNotFoundExpectation: "+ e);
        }
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
    //Initializes tile scores in another hashmap
    // TODO: Find a way to read these values from the file
    public void initTileScore() {
        this.tileScore = new HashMap<Character, Integer>();
        if (this.tileScore.isEmpty()) {
            this.tileScore.put('A', 1);
            this.tileScore.put('B', 3);
            this.tileScore.put('C', 3);
            this.tileScore.put('D', 2);
            this.tileScore.put('E', 1);
            this.tileScore.put('F', 2);
            this.tileScore.put('G', 2);
            this.tileScore.put('H', 4);
            this.tileScore.put('I', 1);
            this.tileScore.put('J', 8);
            this.tileScore.put('K', 5);
            this.tileScore.put('L', 1);
            this.tileScore.put('M', 3);
            this.tileScore.put('N', 1);
            this.tileScore.put('O', 1);
            this.tileScore.put('P', 3);
            this.tileScore.put('Q', 10);
            this.tileScore.put('R', 1);
            this.tileScore.put('S', 1);
            this.tileScore.put('T', 1);
            this.tileScore.put('U', 1);
            this.tileScore.put('V', 4);
            this.tileScore.put('W', 4);
            this.tileScore.put('X', 8);
            this.tileScore.put('Y', 4);
            this.tileScore.put('Z', 10);        }
    }

    //Initializes the dictionary - text file from 'https://github.com/redbo/scrabble/blob/master/dictionary.txt'
    private void initDict() throws FileNotFoundException {
        BufferedReader dictReader = new BufferedReader(new FileReader(("words.txt")));
        try {
            String line = dictReader.readLine();

            //add all words from words.txt to hashset
            while (line != null) {
                dict.add(line);
                line = dictReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("IOException : "+ e);
            e.printStackTrace();
        }

    }
    /*
    @param word input to be validated
    @return     boolean if word is valid
    */
    public boolean validateWord(String word) {
        return this.dict.contains(word);
    }
    /*
    @param C    tile to be scored
    @return     score for a tile
    */
    private int getTileScore(Character C) {
        if (this.tileScore.containsKey(C)) {
            return (int) this.tileScore.get(C);
        }
        return -1;
    }
    /*
    used when game starts and after each move
    @param C    tile to be removed
    @return     removed successfully
    */
    public boolean removeTileFromBag(Character C) {
        if (this.tileBag.containsKey(C)) {
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
    public boolean addTileToBag(Character C) {
        if (this.tileBag.containsKey(C)) {
            int newValue = this.tileBag.get(C) + 1;
            this.tileBag.put(C, newValue);
            return true;
        }
        return false;
    }
}

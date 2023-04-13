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
    int numberOfPlayers;
    HashMap tileBag;
    HashSet dict;

    public Game() {
        this.scrabbleBoard = new char[15][15];
        this.tileBag = new HashMap<Character, Integer>();
        this.dict = new HashSet<String>();

        this.initTileBag();
        System.out.println("tile bag init done\n");
        try {   this.initDict();    }
        catch (FileNotFoundException e) {
            System.err.println("FileNotFoundExpectation: "+ e);
        }
    }

    //Initializes the scrabble board
    private void initBoard() {
        //new char array is already initialized

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

    //Initializes the dictionary - text file from 'https://github.com/redbo/scrabble/blob/master/dictionary.txt'
    private void initDict() throws FileNotFoundException {
        System.out.println("entered initDict()");
        BufferedReader dictReader = new BufferedReader(new FileReader(("words.txt")));
        try {
            String line = dictReader.readLine();
            System.out.println("first line : "+ line);

            //add all words from words.txt to hashset
            while (line != null) {
                dict.add(line);
                line = dictReader.readLine();
            }
            System.out.println("done reading entire file");
        } catch (IOException e) {
            System.err.println("IOException : "+ e);
            e.printStackTrace();
        }

    }
    /*
    @param word input to be validated
    @return boolean if word is valid
    */
    public boolean validateWord(String word) {
        return this.dict.contains(word);
    }
}

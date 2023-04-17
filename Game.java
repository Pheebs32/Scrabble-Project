/*
    Name: Phoebe Swaine
    Date: 13/04/23
    Project: Scrabble board-game
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

//Game class for Scrabble - Handles the game logic
// TODO: convert this to a Singleton since only one object should ever be required
// TODO: change HashSet implementation of dict

public class Game {
    char[][] scrabbleBoard;
    private static HashSet<String> dict;


    public Game() {
        this.scrabbleBoard = new char[15][15];
        this.initGame();
        Game.dict = new HashSet<String>();

        try {
            this.initDict();
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundExpectation: " + e);
        }
    }

    private void initGame() {
        for (int i = 0; i < 15; i++) {
            Arrays.fill(this.scrabbleBoard[i], '-');
        }
        this.scrabbleBoard[7][7] = 'X';
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
            System.err.println("IOException : " + e);
            e.printStackTrace();
        }
    }

    /*
    @param word input to be validated
    @return     boolean if word is valid
    */
    public boolean validateWord(String word) {
        return dict.contains(word.toUpperCase());
    }

    /*
    returns string representation of the board
    @return     Game string object
    */
    public String toString() {
        StringBuilder board = new StringBuilder();
        board.append(" A B C D E F G H I J K L M N O\n");
        for (int i = 0; i < 15; i++) {
            if (i >= 10) {
                board.append(i).append(" ");
            } else {
                board.append(" ").append(i).append(" ");
            }
            for (int j = 0; j < 15; j++) {
                board.append(this.scrabbleBoard[i][j]).append("  ");
            }
            board.append("\n\n");
        }
        return board.toString();
    }
}

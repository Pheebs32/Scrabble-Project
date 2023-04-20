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
import java.util.HashMap;

//Game class for Scrabble - Handles the game logic
public class Game {
    // TODO: change board represetation - adding W, w, L, l ...
    char[][] scrabbleBoard;
    private static HashSet<String> dict;
    private static HashMap<String, String> boardScores;


    public Game() {
        this.initGame();
        this.initBoardScores();

        try {
            this.initDict();
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundExpectation: " + e);
        }
    }
    // TODO: change display logic - view class handle the chars??
    // TODO: actual board only has tiles or is empty
    private void initGame() {
        this.scrabbleBoard = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                this.scrabbleBoard[i][j] = ' ';
            }
        }
        this.scrabbleBoard[7][7] = 'X';
    }

    //Initializes the dictionary - text file from 'https://github.com/redbo/scrabble/blob/master/dictionary.txt'
    private void initDict() throws FileNotFoundException {
        Game.dict = new HashSet<String>();
        BufferedReader dictReader = new BufferedReader(new FileReader(("words.txt")));
        try {
            String line = dictReader.readLine();

            //add all words from words.txt to hashset
            while (line != null) {
                dict.add(line.toUpperCase());
                line = dictReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("IOException : " + e);
            e.printStackTrace();
        }
    }

    /*
    Initializes the map that stores special scores for cells
    */
    private void initBoardScores() {
        Game.boardScores = new HashMap<String, String>();
        // TRIPLE WORD BUFF
        boardScores.put("00", "3W");
        boardScores.put("70", "3W");
        boardScores.put("07", "3W");
        boardScores.put("014", "3W");

        // DOUBLE WORD BUFF
        boardScores.put("11", "2W");
        boardScores.put("22", "2W");
        boardScores.put("33", "2W");
        boardScores.put("44", "2W");
        boardScores.put("113", "2W");
        boardScores.put("212", "2W");
        boardScores.put("311", "2W");
        boardScores.put("410", "2W");
        boardScores.put("131", "2W");
        boardScores.put("122", "2W");
        boardScores.put("113", "2W");
        boardScores.put("104", "2W");
        boardScores.put("1010", "2W");
        boardScores.put("1111", "2W");
        boardScores.put("1212", "2W");
        boardScores.put("1313", "2W");

        // TRIPLE WORD BUFF
        boardScores.put("51", "3W");
        boardScores.put("91", "3W");
        boardScores.put("15", "3W");
        boardScores.put("55", "3W");
        boardScores.put("95", "3W");
        boardScores.put("135", "3W");
        boardScores.put("19", "3W");
        boardScores.put("59", "3W");
        boardScores.put("99", "3W");
        boardScores.put("139", "3W");
        boardScores.put("513", "3W");
        boardScores.put("913", "3W");

        // DOUBLE WORD BUFF
        boardScores.put("30", "2W");
        boardScores.put("110", "2W");
        boardScores.put("62", "2W");
        boardScores.put("82", "2W");
        boardScores.put("03", "2W");
        boardScores.put("73", "2W");
        boardScores.put("143", "2W");
        boardScores.put("26", "2W");
        boardScores.put("66", "2W");
        boardScores.put("86", "2W");
        boardScores.put("126", "2W");
        boardScores.put("37", "2W");
        boardScores.put("117", "2W");
        boardScores.put("28", "2W");
        boardScores.put("68", "2W");
        boardScores.put("88", "2W");
        boardScores.put("128", "2W");
        boardScores.put("011", "2W");
        boardScores.put("711", "2W");
        boardScores.put("1411", "2W");
        boardScores.put("612", "2W");
        boardScores.put("812", "2W");
        boardScores.put("314", "2W");
        boardScores.put("1114", "2W");
    }

    /*
    returns the char on the board at (row, col)
    @param row  row index
    @param col  col index
    @return     char at (row, col)
    */
    public char getTileOnBoard(int row, int col) {
        return this.scrabbleBoard[row][col];
    }

    /*
    @param word input to be validated
    @return     boolean if word is valid
    */
    public static boolean validateWord(String word) {
        return dict.contains(word.toUpperCase());
    }
    /*
    returns string representation of the board
    @return     Game string object
    */
    public String toString() {
        StringBuilder board = new StringBuilder();
        board.append("   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14\n");
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
    //will not place a word on the board unless it is valid
    public void placeWordOnBoard(move move) {
        //assumption that the word is valid

        if (move.isValid) {
            String word = move.word;
            int row = move.startRow;
            int col = move.startCol;

            for (int i = 0; i < word.length(); i++) {
                if (move.direction == move.RIGHT) {
                    //increase row value to add word to the right
                    System.out.println("Adding the word to the right.");
                    this.scrabbleBoard[row][col+i] = word.toUpperCase().charAt(i);
                } else if (move.direction == move.DOWN) {
                    //increase col value to add word down
                    this.scrabbleBoard[row+1][col] = word.toUpperCase().charAt(i);
                }
            }
        }
    }

}

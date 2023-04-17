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
// TODO: convert this to a Singleton since only one object should ever be required
// TODO: change HashSet implementation of dict

public class Game {
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

    private void initGame() {
        this.scrabbleBoard = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                this.scrabbleBoard[i][j] = '_';
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
                dict.add(line);
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
    @param word input to be validated
    @return     boolean if word is valid
    */
    public static boolean validateWord(String word) {
        return dict.contains(word.toUpperCase());
    }

    public static String getCellScore() {
        return "";
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
    public void placeWordOnBoard(char[] word, int row, char col, int direction) {
        //assumption that the word is valid

    }
}

//testing certain scenarios for clarity
import java.util.ArrayList;
import java.util.Arrays;
public class testing {
    public static void main(String[] args) {
//        Game gameBoard = new Game();
//        gameplay game = new gameplay();
//
//        view.printGame(gameBoard);
//        move move1 = new move("start", move.RIGHT, 7, 7);
//        move1.isValid = true;
//        gameBoard.placeWordOnBoard(move1);
//        view.printGame(gameBoard);
//
//        move move2 = new move("termite", move.DOWN, 7, 11);
//        move2.isValid = true;
//        gameBoard.placeWordOnBoard(move2);
//        view.printGame(gameBoard);
//
//        move move3 = new move("tar", move.RIGHT, 9,9);
//        move3.isValid = true;
//        gameBoard.placeWordOnBoard(move3);
//        view.printGame(gameBoard);
//
//        move move4 = new move("road", move.DOWN, 7,10);
//        ArrayList<String> move4Test = game.getSecondaryWords(move4, gameBoard);
//        System.out.println("new word: " +move4Test.size());
//        System.out.println("word: " +move4Test.remove(0));
//        System.out.println("word: " +move4Test.remove(0));
//        move4.isValid = true;
//        gameBoard.placeWordOnBoard(move4);
//        view.printGame(gameBoard);
//        System.out.println("total moves: " + move.totalNumberOfMoves);

        String[] testStr = new String[5];
        testStr[0] = "A";
        testStr[1] = "B";
        testStr[2] = "C";
        testStr[3] = "D";
        testStr[4] = "E";

        String word = "ABBACD";

        System.out.println(String.valueOf(word.charAt(5)));
        //word

        int pos = Arrays.binarySearch(testStr, String.valueOf(word.charAt(5)));

        System.out.println("pos: " + pos);
    }
}

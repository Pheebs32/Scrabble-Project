//testing certain scenarios for clarity
import java.util.ArrayList;
public class testing {
    public static void main(String[] args) {
        Game gameBoard = new Game();
        gameplay game = new gameplay();

        System.out.println(gameBoard.toString());

        move move1 = new move("start", move.RIGHT, 7, 7);
        move1.isValid = true;
        gameBoard.placeWordOnBoard(move1);
        System.out.println(gameBoard.toString());

        move move2 = new move("termite", move.DOWN, 7, 11);
        move2.isValid = true;
        gameBoard.placeWordOnBoard(move2);
        System.out.println(gameBoard.toString());

        move move3 = new move("tar", move.RIGHT, 9,9);
        move3.isValid = true;
        gameBoard.placeWordOnBoard(move3);
        System.out.println(gameBoard.toString());

        move move4 = new move("road", move.DOWN, 7,10);
        ArrayList<String> move4Test = game.getSecondaryWords(move4, gameBoard);
//        System.out.println("new word: " +move4Test.size());
//        System.out.println("word: " +move4Test.remove(0));
//        System.out.println("word: " +move4Test.remove(0));
        move4.isValid = true;
        gameBoard.placeWordOnBoard(move4);
        System.out.println(gameBoard.toString());

        System.out.println("total moves: " + move.totalNumberOfMoves);

    }
}

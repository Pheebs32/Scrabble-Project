
//testing certain scenarios for clarity
public class testing {
    public static void main(String[] args) {
        Game gameBoard = new Game();
        System.out.println(gameBoard.toString());
        move move1 = new move("start", move.RIGHT, 7, 7);
        move1.isValid = true;
        gameBoard.placeWordOnBoard(move1);
        System.out.println(gameBoard.toString());

        move move2 = new move("termite", move.DOWN, 7, 11);
        move2.isValid = true;
        gameBoard.placeWordOnBoard(move2);
        System.out.println(gameBoard.toString());

    }
}

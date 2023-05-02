//This class handles all the view drawings. All methods are static.
//Other classes send an object and this class adds the UI before displaying.
public class view {
    public static void showTray(player player) {
        System.out.println(player.getName() +", your turn: ");
        for (int i = 0; i < player.getLetters().length; i++) {
            System.out.println(player.getLetters()[i] + " ");
        }
        System.out.println(" ");
    }
    public static void printGame(Game game) {
        System.out.println(game.toString());
    }
    /*
    prints out player information :
    PLAYER NAME : boo
    LETTER TRAY : [A, B, C, D, E, F, G]
    @param player   player object
    */
    public static void printPlayerInformation(player player) {

    }
    /*
    prints scores :
    not sure how to display scoring yet...
    */
    public static void printScores(scores scores) {

    }
}

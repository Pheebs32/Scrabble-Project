//This class handles all the view drawings. All methods are static.
//Other classes send an object and this class adds the UI before displaying.
import java.util.Arrays;
public class view {
    public static void showTray(player player) {
        System.out.println(player.getName() +", your turn: ");
        for (int i = 0; i < player.getLetters().length; i++) {
            System.out.println(player.getLetters()[i] + " ");
        }
        System.out.println(" ");
    }
    public static void printGame(Game game) {
        char[][] boardCopy = game.getScrabbleBoardClone();
        StringBuilder boardStr = new StringBuilder();

        //decorate the triple word tiles
        if (boardCopy[0][0] == ' ') { boardCopy[0][0] = '#'; }
        if (boardCopy[7][0] == ' ') { boardCopy[7][0] = '#'; }
        if (boardCopy[0][7] == ' ') { boardCopy[0][7] = '#'; }
        if (boardCopy[0][14] == ' ') { boardCopy[0][14] = '#'; }
        if (boardCopy[14][0] == ' ') { boardCopy[14][0] = '#'; }
        if (boardCopy[14][7] == ' ') { boardCopy[14][7] = '#'; }
        if (boardCopy[7][14] == ' ') { boardCopy[7][14] = '#'; }
        if (boardCopy[14][14] == ' ') { boardCopy[14][14] = '#'; }

        //decorate the double word tiles
        if (boardCopy[1][1] == ' ') { boardCopy[1][1] = '*'; }
        if (boardCopy[2][2] == ' ') { boardCopy[2][2] = '*'; }
        if (boardCopy[3][3] == ' ') { boardCopy[3][3] = '*'; }
        if (boardCopy[4][4] == ' ') { boardCopy[4][4] = '*'; }
        if (boardCopy[1][13] == ' ') { boardCopy[1][13] = '*'; }
        if (boardCopy[2][12] == ' ') { boardCopy[2][13] = '*'; }
        if (boardCopy[3][11] == ' ') { boardCopy[3][11] = '*'; }
        if (boardCopy[4][10] == ' ') { boardCopy[4][10] = '*'; }
        if (boardCopy[13][1] == ' ') { boardCopy[13][1] = '*'; }
        if (boardCopy[12][2] == ' ') { boardCopy[12][2] = '*'; }
        if (boardCopy[11][3] == ' ') { boardCopy[11][3] = '*'; }
        if (boardCopy[10][4] == ' ') { boardCopy[10][4] = '*'; }
        if (boardCopy[10][10] == ' ') { boardCopy[10][10] = '*'; }
        if (boardCopy[11][11] == ' ') { boardCopy[11][11] = '*'; }
        if (boardCopy[12][12] == ' ') { boardCopy[12][12] = '*'; }
        if (boardCopy[13][13] == ' ') { boardCopy[13][13] = '*'; }

        //decorate the triple letter tiles
        if (boardCopy[5][1] == ' ') { boardCopy[5][1] = '+'; }
        if (boardCopy[9][1] == ' ') { boardCopy[9][1] = '+'; }
        if (boardCopy[1][5] == ' ') { boardCopy[1][5] = '+'; }
        if (boardCopy[5][5] == ' ') { boardCopy[5][5] = '+'; }
        if (boardCopy[9][5] == ' ') { boardCopy[9][5] = '+'; }
        if (boardCopy[13][5] == ' ') { boardCopy[13][5] = '+'; }
        if (boardCopy[1][9] == ' ') { boardCopy[1][9] = '+'; }
        if (boardCopy[5][9] == ' ') { boardCopy[5][9] = '+'; }
        if (boardCopy[9][9] == ' ') { boardCopy[9][9] = '+'; }
        if (boardCopy[13][9] == ' ') { boardCopy[13][9] = '+'; }
        if (boardCopy[5][13] == ' ') { boardCopy[5][13] = '+'; }
        if (boardCopy[9][13] == ' ') { boardCopy[9][13] = '+'; }

        //decorate the double letter tiles
        if (boardCopy[3][0] == ' ') { boardCopy[3][0] = '~'; }
        if (boardCopy[11][0] == ' ') { boardCopy[11][0] = '~'; }
        if (boardCopy[6][2] == ' ') { boardCopy[6][2] = '~'; }
        if (boardCopy[8][2] == ' ') { boardCopy[8][2] = '~'; }
        if (boardCopy[0][3] == ' ') { boardCopy[0][3] = '~'; }
        if (boardCopy[7][3] == ' ') { boardCopy[7][3] = '~'; }
        if (boardCopy[14][3] == ' ') { boardCopy[14][3] = '~'; }
        if (boardCopy[2][6] == ' ') { boardCopy[2][6] = '~'; }
        if (boardCopy[6][6] == ' ') { boardCopy[6][6] = '~'; }
        if (boardCopy[8][6] == ' ') { boardCopy[8][6] = '~'; }
        if (boardCopy[12][6] == ' ') { boardCopy[12][6] = '~'; }
        if (boardCopy[3][7] == ' ') { boardCopy[3][7] = '~'; }
        if (boardCopy[11][7] == ' ') { boardCopy[11][7] = '~'; }
        if (boardCopy[2][8] == ' ') { boardCopy[2][8] = '~'; }
        if (boardCopy[6][8] == ' ') { boardCopy[6][8] = '~'; }
        if (boardCopy[8][8] == ' ') { boardCopy[8][8] = '~'; }
        if (boardCopy[12][8] == ' ') { boardCopy[12][8] = '~'; }
        if (boardCopy[0][11] == ' ') { boardCopy[0][11] = '~'; }
        if (boardCopy[7][11] == ' ') { boardCopy[7][11] = '~'; }
        if (boardCopy[14][11] == ' ') { boardCopy[14][11] = '~'; }
        if (boardCopy[6][12] == ' ') { boardCopy[6][12] = '~'; }
        if (boardCopy[8][12] == ' ') { boardCopy[8][12] = '~'; }
        if (boardCopy[3][14] == ' ') { boardCopy[3][14] = '~'; }
        if (boardCopy[11][14] == ' ') { boardCopy[11][14] = '~'; }

        boardStr.append("/////-------------------SCRABBLE BOARD--------------------/////\n");
        boardStr.append(" =   0   1   2   3   4   5   6   7   8   9   10  11  12  13  14\n\n");
        for (int i = 0; i < 15; i++) {
            if (i >= 10) { boardStr.append(i + "   ");      }
            else         { boardStr.append(" " + i + " ");  }
            for (int j = 0; j > 15; j++) {
                if (boardCopy[i][j] == ' ') { boardStr.append('.' + "   ");             }
                else                        { boardStr.append(boardCopy[i][j] + "   ");  }
            }
            boardStr.append("\n\n");
        }
        boardStr.append("[~] -> DOUBLE LETTER\n");
        boardStr.append("[+] -> TRIPLE LETTER\n");
        boardStr.append("[*] -> DOUBLE WORD\n");
        boardStr.append("[#] -> TRIPLE WORD\n");

        System.out.println(boardStr.toString());
    }

    /*
    prints out player information :
    PLAYER NAME : boo
    PLAYER SCORE : --
    LETTER TRAY : [A, B, C, D, E, F, G]
    @param player1   player object
    @param player2   player object
    */
    public static void printPlayerInformation(player player1, player player2, scores scores) {
        System.out.println("/////-PLAYER-1 INFO-/////");
        System.out.println("NAME : " + player1.getName());
        System.out.println("SCORE : " + scores.getPlayerScore(player1));
        System.out.println("TILES : " + Arrays.toString(player1.getLetters()));
        System.out.println("/////---------------/////\n");
        System.out.println("/////-PLAYER-2 INFO-/////");
        System.out.println("NAME : " + player2.getName());
        System.out.println("SCORE : " + scores.getPlayerScore(player2));
        System.out.println("TILES : " + Arrays.toString(player2.getLetters()));
        System.out.println("/////---------------/////\n");
    }

//    public static void printScores(player player1, player player2, scores scores) {
//        System.out.println("---------------------------------------");
//        System.out.println(" PLAYER 1: " + player1.getName() + " PLAYER 2: " +player2.getName());
//    }
}

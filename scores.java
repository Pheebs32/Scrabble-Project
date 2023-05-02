import java.util.ArrayList;
import java.util.HashMap;

public class scores {
    private static HashMap<player, Integer> scoreMap;
    public static HashMap<Character, Integer> tileScore;

    public scores(player player1, player player2) {
        scoreMap = new HashMap<player, Integer>();
        scoreMap.put(player1, 0);
        scoreMap.put(player2, 0);
        this.initTileScore();
    }

    //Initializes tile scores in another hashmap
    // TODO: Find a way to read these values from the file
    public void initTileScore() {
        scores.tileScore = new HashMap<Character, Integer>();
        if (scores.tileScore.isEmpty()) {
            scores.tileScore.put('A', 1);
            scores.tileScore.put('B', 3);
            scores.tileScore.put('C', 3);
            scores.tileScore.put('D', 2);
            scores.tileScore.put('E', 1);
            scores.tileScore.put('F', 2);
            scores.tileScore.put('G', 2);
            scores.tileScore.put('H', 4);
            scores.tileScore.put('I', 1);
            scores.tileScore.put('J', 8);
            scores.tileScore.put('K', 5);
            scores.tileScore.put('L', 1);
            scores.tileScore.put('M', 3);
            scores.tileScore.put('N', 1);
            scores.tileScore.put('O', 1);
            scores.tileScore.put('P', 3);
            scores.tileScore.put('Q', 10);
            scores.tileScore.put('R', 1);
            scores.tileScore.put('S', 1);
            scores.tileScore.put('T', 1);
            scores.tileScore.put('U', 1);
            scores.tileScore.put('V', 4);
            scores.tileScore.put('W', 4);
            scores.tileScore.put('X', 8);
            scores.tileScore.put('Y', 4);
            scores.tileScore.put('Z', 10);
        }
    }
    /*
    @param C    tile to be scored
    @return     score for a tile
    */
    private int getTileScore(char C) {
        if (scores.tileScore.containsKey(C)) {
            return scores.tileScore.get(C);
        }
        return -1;
    }
    /*
    updates players score
    @param player   player in question
    @param score    new score
    */
    private void updatePlayerScore(player player, int score) {
        if (score < 0)      { throw new IllegalArgumentException("negative score!"); }
        if (player == null) { throw new IllegalArgumentException("player obj null"); }

        int newScore = this.scoreMap.get(player) + score;
        this.scoreMap.put(player, newScore);
    }
    /*
    get players score
    @param player   player in question
    @return         players score
    */
    public static int getPlayerScore(player player) {
        if (player == null) { throw new IllegalArgumentException("player obj null"); }
        if (scores.scoreMap.containsKey(player)) {
            return scores.scoreMap.get(player);
        } else return -1;
    }

    /*
    returns the score of the move
    @param player   who played the move
    @param move     move being played
    @return         move score
    */
    public int computeWordScore(move move) {
        ArrayList<String> list = move.secondaryWords;
        String word = move.word;
        int dir = move.direction;
        int row = move.startRow;
        int col = move.startCol;

        int totalScore = 0;
        int tempWordScore = 0;
        int wordMultiplier = 1; //double or triple scores
        int tileMultiplier = 1;
        int secondaryScore = 0;

        for (int i = 0; i < word.length(); i++) {
            if (dir == move.RIGHT) {
                String boardRef = String.valueOf(row) + String.valueOf(col + i);
                if (Game.getBoardScoreForTile(boardRef).equals("2W")) { wordMultiplier = 2;}
                if (Game.getBoardScoreForTile(boardRef).equals("3W")) { wordMultiplier = 3;}
                if (Game.getBoardScoreForTile(boardRef).equals("2L")) { wordMultiplier = 2;}
                if (Game.getBoardScoreForTile(boardRef).equals("3L")) { wordMultiplier = 3;}

                tempWordScore += (scores.tileScore.get(Character.toUpperCase(word.charAt(i)))) * tileMultiplier;
            } else if (dir == move.DOWN) {
                String boardRef = String.valueOf(row + i) + String.valueOf(col);
                if (Game.getBoardScoreForTile(boardRef).equals("2W")) { wordMultiplier = 2;}
                if (Game.getBoardScoreForTile(boardRef).equals("3W")) { wordMultiplier = 3;}
                if (Game.getBoardScoreForTile(boardRef).equals("2L")) { wordMultiplier = 2;}
                if (Game.getBoardScoreForTile(boardRef).equals("3L")) { wordMultiplier = 3;}

                tempWordScore += (scores.tileScore.get(Character.toUpperCase(word.charAt(i)))) * tileMultiplier;
            }
        }
        totalScore += tempWordScore * wordMultiplier;
        secondaryScore = this.computeSecondaryWordScore(move);

        return totalScore + secondaryScore;
    }

    //the score of the move assuming the move is valid
    private int computeSecondaryWordScore(move move) {
        ArrayList<String> list = move.secondaryWords;
        int tempScore = 0;
        for (String str : list) {
            for (int i = 0; i < str.length(); i++) {
                tempScore += scores.tileScore.get(Character.toUpperCase(str.charAt(i)));
            }
        }
        return tempScore;
    }

}

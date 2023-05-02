import java.util.HashMap;

public class scores {
    private HashMap<player, Integer> scoreMap;
    public static HashMap<Character, Integer> tileScore;

    public scores(player player1, player player2) {
        this.scoreMap = new HashMap<player, Integer>();
        this.scoreMap.put(player1, 0);
        this.scoreMap.put(player2, 0);
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
    public int getPlayerScore(player player) {
        if (player == null) { throw new IllegalArgumentException("player obj null"); }
        if (this.scoreMap.containsKey(player)) {
            return this.scoreMap.get(player);
        } else return -1;
    }

    //the score of letters only from the formed word
    public int computeWordScore(String word) {
        return -1;
    }

    //the score of the move assuming the move is valid
    public int computeMoveScore(move move) {
        return -1;
    }

}

import java.util.HashMap;

public class scores {
    private HashMap<player, Integer> scoreMap;
    private HashMap<Character, Integer> tileScore;

    public scores(player player1, player player2) {
        this.scoreMap = new HashMap<player, Integer>();
        this.scoreMap.put(player1, 0);
        this.scoreMap.put(player2, 0);
        this.initTileScore();
    }

    //Initializes tile scores in another hashmap
    // TODO: Find a way to read these values from the file
    public void initTileScore() {
        this.tileScore = new HashMap<Character, Integer>();
        if (this.tileScore.isEmpty()) {
            this.tileScore.put('A', 1);
            this.tileScore.put('B', 3);
            this.tileScore.put('C', 3);
            this.tileScore.put('D', 2);
            this.tileScore.put('E', 1);
            this.tileScore.put('F', 2);
            this.tileScore.put('G', 2);
            this.tileScore.put('H', 4);
            this.tileScore.put('I', 1);
            this.tileScore.put('J', 8);
            this.tileScore.put('K', 5);
            this.tileScore.put('L', 1);
            this.tileScore.put('M', 3);
            this.tileScore.put('N', 1);
            this.tileScore.put('O', 1);
            this.tileScore.put('P', 3);
            this.tileScore.put('Q', 10);
            this.tileScore.put('R', 1);
            this.tileScore.put('S', 1);
            this.tileScore.put('T', 1);
            this.tileScore.put('U', 1);
            this.tileScore.put('V', 4);
            this.tileScore.put('W', 4);
            this.tileScore.put('X', 8);
            this.tileScore.put('Y', 4);
            this.tileScore.put('Z', 10);
        }
    }
    /*
    @param C    tile to be scored
    @return     score for a tile
    */
    private int getTileScore(char C) {
        if (this.tileScore.containsKey(C)) { throw new IllegalArgumentException(); }
        return this.tileScore.get(C);
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

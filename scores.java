import java.util.HashMap;

public class scores {
    private HashMap<player, Integer> scoreMap;

    public scores(player player1, player player2) {
        this.scoreMap = new HashMap<player, Integer>();
        this.scoreMap.put(player1, 0);
        this.scoreMap.put(player2, 0);
    }
    /*
    updates players score
    @param player   player in question
    @param score    new score
    */
    public void updateScore(player player, int score) {
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
    public int getScoreForPlayer(player player) {
        if (player == null) { throw new IllegalArgumentException("player obj null"); }
        if (this.scoreMap.containsKey(player)) {
            return this.scoreMap.get(player);
        } else return -1;
    }

}

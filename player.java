public class player {
    private String name;
    private int id;
    private int currentScore;
    String [] letters;

    public player(String name, int id, String[] letters) {
        this.name = name;
        this.id = id;
        this.letters = letters;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    // TODO: score should be in gameplay
    public int getCurrentScore() {
        return currentScore;
    }
    public void setCurrentScore(Integer currentScore) {
        this.currentScore = currentScore;
    }
    public String[] getLetters() {
        return letters;
    }
    public void setLetters(String[] letters) {
        this.letters = letters;
    }
}

import java.util.HashMap;
import java.util.Random;
// This class handles move validation and score handling
// It also handles tileBag and tileScores
public class gameplay {
    private HashMap<Character, Integer> tileBag;
    private HashMap<Character, Integer> tileScore;
    //private String[] lettersTray;
    public gameplay() {
        this.initTileBag();
        this.initTileScore();
    }

    //Tile bag initialization and distribution
    //Values taken from : 'thesprucecrafts.com/scrabble-tile-distribution-and-point-values-412402'
    // TODO: Find a way to read these values from the file
    private void initTileBag() {
        this.tileBag = new HashMap<Character, Integer>();
        if (this.tileBag.isEmpty()) {
            this.tileBag.put('A', 9);
            this.tileBag.put('B', 2);
            this.tileBag.put('C', 2);
            this.tileBag.put('D', 4);
            this.tileBag.put('E', 12);
            this.tileBag.put('F', 2);
            this.tileBag.put('G', 3);
            this.tileBag.put('H', 2);
            this.tileBag.put('I', 9);
            this.tileBag.put('J', 1);
            this.tileBag.put('K', 1);
            this.tileBag.put('L', 4);
            this.tileBag.put('M', 2);
            this.tileBag.put('N', 6);
            this.tileBag.put('O', 8);
            this.tileBag.put('P', 2);
            this.tileBag.put('Q', 1);
            this.tileBag.put('R', 6);
            this.tileBag.put('S', 4);
            this.tileBag.put('T', 6);
            this.tileBag.put('U', 4);
            this.tileBag.put('V', 2);
            this.tileBag.put('W', 2);
            this.tileBag.put('X', 1);
            this.tileBag.put('Y', 2);
            this.tileBag.put('Z', 1);
        }
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
    used when game starts and after each move
    @param C    tile to be removed
    @return     removed successfully
    */
    public boolean removeTileFromBag(char C) {
        if (this.tileBag.containsKey(C) && this.tileBag.get(C) > 0) {
            int newValue = this.tileBag.get(C) - 1;
            this.tileBag.put(C, newValue);
            return true;
        }
        return false;
    }
    /*
    used when players give up their turns
    @param C    tile added back to bag
    @return     added successfully
    */
    public boolean addTileToBag(char C) {
        if (this.tileBag.containsKey(C)) {
            int newValue = this.tileBag.get(C) + 1;
            this.tileBag.put(C, newValue);
            return true;
        }
        return false;
    }
    /*
    used when players give up their turns
    @param C    Letter missing from the tray
    */
    public Object getRandomLetterFromBag(char C) {
        Random random = new Random();
        Object[] letters = this.tileBag.keySet().toArray();
        Object randomLetter = letters[random.nextInt(letters.length)];

        if (this.tileBag.get(randomLetter) == 0) {
            //Need to call function again
        } else {
            int newValue = this.tileBag.get(randomLetter) - 1;
            this.tileBag.put((Character) randomLetter, newValue);
            System.out.println(randomLetter);
        }
        return randomLetter;
    }


    public void refillTray(player player) {
        String[] lettersTray = player.getLetters();
        int lettersMissing = 0;
        for (int i = 0; i < lettersTray.length; i++) {
            if (lettersTray[i] == "" || lettersTray[i] == null) {
                lettersTray[i] = String.valueOf(this.getRandomLetterFromBag('i'));
            }
        }
        player.setLetters(lettersTray);
    }
    public void showTray(player player) {
        System.out.println(player.getName() +", your turn: ");
        for (int i = 0; i < player.getLetters().length; i++) {
            System.out.println(player.getLetters()[i] + " ");
        }
        System.out.println(" ");
    }
}

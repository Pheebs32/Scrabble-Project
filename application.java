public class application {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("Let's play some Scrabble!");
        System.out.println("--------------------------------");
        System.out.println(" ");

        /*  Initializes all required classes  */
        Game board = new Game();
        gameplay gameplay = new gameplay();
        //scores scores = new scores();
        view view = new view();
        gameplay.createNewPlayers();
        gameplay.gameOn(1);
    }
}

import java.util.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class application {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("Let's play some Scrabble!");
        System.out.println("--------------------------------");
        System.out.println(" ");

        gameplay gameplay = new gameplay();
        gameplay.createNewPlayers();
        gameplay.gameOn();
    }
}

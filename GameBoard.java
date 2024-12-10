import java.util.*;

public class GameBoard {
    private static GameBoard instance;
    private int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    private GameBoard(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public static GameBoard getInstance(int size) {
        if (instance == null) {
            instance = new GameBoard(size);
        }
        return instance;
    }

    public void addSnake(int start, int end) {
        snakes.put(start, end);
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    public int getNewPosition(int position) {
        if (snakes.containsKey(position)) return snakes.get(position);
        if (ladders.containsKey(position)) return ladders.get(position);
        return position;
    }

    public int getSize() {
        return size;
    }
}

import java.util.*;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        GameBoard board = GameBoard.getInstance(100);

        // Adding snakes and ladders
        int[][] snakes = {{16, 6}, {48, 26}, {49, 11}, {56, 53}, {62, 19}, {64, 60}, {87, 24}, {93, 73}, {95, 75}, {98, 78}};
        int[][] ladders = {{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {80, 100}};
        for (int[] snake : snakes) board.addSnake(snake[0], snake[1]);
        for (int[] ladder : ladders) board.addLadder(ladder[0], ladder[1]);

        // Players
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));

        // Dice
        Dice dice = (Dice) new NormalDice();

        boolean gameOn = true;
while (gameOn) {
    for (Player player : players) {
        boolean extraTurn = true; // Allow extra turn if 6 is rolled

        while (extraTurn) {
            int roll = dice.rollDice();
            System.out.println(player.getName() + " rolled " + roll);

            int newPosition = player.getPosition() + roll;
            if (newPosition > board.getSize()) {
                newPosition = board.getSize();
            }
            newPosition = board.getNewPosition(newPosition);

            player.setPosition(newPosition);
            System.out.println(player.getName() + " moved to " + newPosition);

            if (newPosition == board.getSize()) {
                System.out.println(player.getName() + " wins!");
                gameOn = false;
                break;
            }

            // Player gets another turn if they roll a 6
            extraTurn = (roll == 6);
        }

        if (!gameOn) break;
    }
}

    }
}

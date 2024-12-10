import java.util.Random;

public interface Dice {
    int rollDice();
}

class NormalDice implements Dice {
    private Random random = new Random();

    @Override
    public int rollDice() {
        return random.nextInt(6) + 1;
    }
}

class LoadedDice implements Dice {
    private Random random = new Random();

    @Override
    public int rollDice() {
        return random.nextInt(3) + 4; // Rolls between 4 and 6
    }
}

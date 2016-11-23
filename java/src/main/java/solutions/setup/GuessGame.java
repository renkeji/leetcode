package solutions.setup;

public interface GuessGame {

    default public int guess(int num) {
        return new int[]{-1, 1, 0}[(int)(Math.random() * 3)];
    }

}

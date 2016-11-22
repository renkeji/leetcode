package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 *
 * Example:
 *  Given width = 3, height = 2, and food = [[1,2],[0,1]].
 *
 *  Snake snake = new Snake(width, height, food);
 *
 *  Initially the snake appears at position (0,0) and the food at (1,2).
 *
 *  |S| | |
 *  | | |F|
 *
 *  snake.move("R"); -> Returns 0
 *
 *  | |S| |
 *  | | |F|
 *
 *  snake.move("D"); -> Returns 0
 *
 *  | | | |
 *  | |S|F|
 *
 *  snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
 *
 *  | |F| |
 *  | |S|S|
 *
 *  snake.move("U"); -> Returns 1
 *
 *  | |F|S|
 *  | | |S|
 *
 *  snake.move("L"); -> Returns 2 (Snake eats the second food)
 *
 *  | |S|S|
 *  | | |S|
 *
 *  snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */

public class Q353 extends Solution {

    /**
     * Your SnakeGame object will be instantiated and called as such:
     * SnakeGame obj = new SnakeGame(width, height, food);
     * int param_1 = obj.move(direction);
     */
    public class SnakeGame {

        private class Cell {
            int x, y;
            Cell(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return (String.valueOf(x) + ", " + String.valueOf(y)).hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Cell)) {
                    return false;
                }
                Cell that = (Cell) obj;
                return this.x == that.x && this.y == that.y;
            }
        }

        private LinkedList<Cell> snake;
        private int foodIndex;
        private int width, height;
        private int[][] food;
        private Set<Cell> hs;
        private int score;

        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            this.score = 0;
            this.snake = new LinkedList<>();
            this.hs = new HashSet<>();
            this.width = width;
            this.height = height;
            this.food = food;
            this.foodIndex = 0;
            Cell c = new Cell(0, 0);
            snake.add(c);
            hs.add(c);
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            Cell head = snake.getFirst();
            int nextX, nextY;
            switch (direction) {
                case "U": nextX = head.x - 1; nextY = head.y; break;
                case "L": nextX = head.x; nextY = head.y - 1; break;
                case "R": nextX = head.x; nextY = head.y + 1; break;
                case "D": nextX = head.x + 1; nextY = head.y; break;
                default: nextX = -1; nextY = -1; break;
            }
            return move(nextX, nextY);
        }

        private int move(int nextX, int nextY) {
            Cell nextCell = new Cell(nextX, nextY);
            if (foodIndex < food.length && nextX == food[foodIndex][0] && nextY == food[foodIndex][1]) {
                if (isSafe(nextX, nextY)) {
                    score++;
                    foodIndex++;
                    snake.addFirst(nextCell);
                    hs.add(nextCell);
                } else {
                    score = -1;
                }
            } else {
                Cell lastCell = snake.getLast();
                hs.remove(lastCell);
                snake.removeLast();
                if (isSafe(nextX, nextY)) {
                    snake.addFirst(nextCell);
                    hs.add(nextCell);
                } else {
                    score = -1;
                }
            }
            return score;
        }

        private boolean isSafe(int x, int y) {
            return x >= 0 && x < height && y >= 0 && y < width && !hs.contains(new Cell(x, y));
        }
    }
}

/*
This class creates an object food which spawns the food randomly and gets and sets its location.
written by Vincent Melevo
 */
import java.awt.Rectangle;

public class Food {
    private int x;
    private int y;

    public Food(Snake player) {
        this.random_spawn(player);
    }

    //Makes sure that food doesn't spawn on the snake
    public void random_spawn(Snake player) {
        boolean onSnake = true;
        while(onSnake) {
            onSnake = false;

            x = (int)(Math.random() * Game.width - 1);
            y = (int)(Math.random() * Game.height - 1);

            for(Rectangle r : player.getBody()){
                if(r.x == x && r.y == y) {
                    onSnake = true;
                }
            }
        }
    }
    //getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

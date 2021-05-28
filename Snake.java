import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimension;

    private String move; //NOTHING, UP, DOWN, LEFT, RIGHT


    public Snake() {
        //array containing snake body
        body = new ArrayList<>();

        //makes the rectangle template for the snake body
        //There are better ways to do this, but I liked the aesthetics of the retro rectangles. -Vallari
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation(Game.width / 2 * Game.dimension, Game.height / 2 * Game.dimension);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
        body.add(temp);

        //sets variable move to nothing
        move = "NOTHING";
    }

    //move method moves the head of the snake.
    public void move() {
        if(move != "NOTHING") {
            Rectangle head = body.get(0);

            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

            if(move == "UP") {
                temp.setLocation(head.x, head.y - Game.dimension);
            }
            else if(move == "DOWN") {
                temp.setLocation(head.x, head.y + Game.dimension);
            }
            else if(move == "LEFT") {
                temp.setLocation(head.x - Game.dimension, head.y);
            }
            else{
                temp.setLocation(head.x + Game.dimension, head.y);
            }

            body.add(0, temp);
            body.remove(body.size()-1);
        }
    }


    //grows the body of the snake
    public void grow() {
        Rectangle head = body.get(0);

        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

        if(move == "UP") {
            temp.setLocation(head.x, head.y - Game.dimension);
        }
        else if(move == "DOWN") {
            temp.setLocation(head.x, head.y + Game.dimension);
        }
        else if(move == "LEFT") {
            temp.setLocation(head.x - Game.dimension, head.y);
        }
        else{
            temp.setLocation(head.x + Game.dimension, head.y);
        }

        body.add(0, temp);
    }

    //An array of rectangles for the body
    //was helpful: https://docs.oracle.com/javase/7/docs/api/java/awt/Rectangle.html
    public ArrayList<Rectangle> getBody() {
        return body;
    }

    //getters and setters
    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y ;
    }

    public String getMove() {
        return move;
    }

    public void up() {
        move = "UP";
    }
    public void down() {
        move = "DOWN";
    }
    public void left() {
        move = "LEFT";
    }
    public void right() {
        move = "RIGHT";
    }
}


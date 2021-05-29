/*
This class creates an object for mouse input, takes mouse event e and returns mouse x and mouse y
code referenced from: https://www.youtube.com/watch?v=qfjxLRrHS0c
code by Mohammed Alshaher
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        /*
            For Reference:
          public static Rectangle playButton = new Rectangle(Game.width / 2 * Game.dimension -50, Game.height / 2 * Game.dimension - 30, 100, 50);
          public static Rectangle quitButton = new Rectangle(Game.width / 2 * Game.dimension - 50, Game.height / 2 * Game.dimension + 60, 100, 50);
        */

        //playButton
        //(x, x+width)
        if (mx >= Game.width / 2 * Game.dimension - 50 && mx <= Game.width / 2 * Game.dimension + 50) {
            //couldn't figure it out with the varibles and resorted to numbers
            if (my >= Game.height / 2 * Game.dimension - 30 && my <= Game.height / 2 * Game.dimension +20) {
                //Pressed Play Button
                Graphics.state = "START";
            }
        }
        //Quit Button
        if (mx >= Game.width / 2 * Game.dimension - 50 && mx <= Game.width / 2 * Game.dimension + 50) {
            //couldn't figure it out with the varibles and resorted to numbers
            if (my >= Game.height / 2 * Game.dimension +60 && my <= Game.height / 2 * Game.dimension +110) {
                //Pressed Play Button
                Graphics.state = "END";
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

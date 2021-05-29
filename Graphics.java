/*
This class creates a the object 'graphics' which paints in the components of the game.
This was a really helpful repository to reference:
https://github.com/abelacosta/SnakeOnline/blob/master/client/src/com/blu3flux/GUI/SnakePanel.java

 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Graphics extends JPanel implements ActionListener {
    //renders every 100ms
    private Timer t = new Timer(100, this);
    //initializes variable for game state
    public static String state;

    private Snake s;
    private Food f;
    private Game game;

    public Graphics(Game g) {
        t.start();
        state = "MENU";

        game = g;
        s = g.getPlayer();
        f = g.getFood();

        //add mouse Listener
        this.addMouseListener(new MouseInput());


        //add key listener
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    //}
    //paints the elements of the game onto the background
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        //background
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Game.width * Game.dimension, Game.height * Game.dimension);

        //if-statement for the game state
        if (state == "MENU") {
            //calls Menu
            Menu.mainMenu(g);
        } else if (state == "START") {
            //the graphics for the start directions
            Font fnt3 = new Font("arial", Font.BOLD, 40);
            g.setFont(fnt3);
            g.setColor(Color.white);
            g.drawString("PRESS ANY KEY", Game.width / 2 * Game.dimension - 180, Game.height / 2 * Game.dimension - 90);
            Font fnt4 = new Font("arial", Font.BOLD, 20);
            g.setFont(fnt4);
            //g2d.drawString("Press Any Key", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 50);
            g.drawString("w = up", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 40);
            g.drawString("s = down", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
            g.drawString("a = left", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension);
            g.drawString("d = right", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension + 20);

        } else if (state == "RUNNING") {
            //the food is magenta and filled
            g.setColor(Color.magenta);
            g.fillRect(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.dimension, Game.dimension);

            //the snake is green and filled in, accesses the body array
            g.setColor(Color.green);
            for (Rectangle r : s.getBody()) {
                g2d.fill(r);
            }
        } else {
            //score font at the end of the game or if the player hits q for quit
            Font fnt2 = new Font("arial", Font.BOLD, 60);
            g.setFont(fnt2);
            g.setColor(Color.white);
            g.drawString("Your Score: " + (s.getBody().size() - 3), Game.width / 2 * Game.dimension - 200, Game.height / 2 * Game.dimension - 20);
        }
    }

    //Action Listener, repaints and updates
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }

}

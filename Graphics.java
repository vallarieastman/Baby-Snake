import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Graphics extends JPanel implements ActionListener {
    //renders every 100ms
    private Timer t = new Timer(100, this);
    public String state;

    private Snake s;
    private Food f;
    private Game game;

    // The Menu enums
    //private enum GAMESTATE{
       // MENU,
        //GAME
    //};

    //private GAMESTATE GameState = GAMESTATE.MENU;

    public Graphics(Game g) {
        t.start();
        state = "START";

        game = g;
        s = g.getPlayer();
        f = g.getFood();

        //add keylistener
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


        if (state == "START") {
            g2d.setColor(Color.white);
            g2d.drawString("Press Any Key", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);

        } else if (state == "RUNNING") {
            g2d.setColor(Color.red);
            g2d.fillRect(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.dimension, Game.dimension);

            g2d.setColor(Color.green);
            for (Rectangle r : s.getBody()) {
                g2d.fill(r);
            }
        } else {
            g2d.setColor(Color.white);
            g2d.drawString("Your Score: " + (s.getBody().size() - 3), Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
        }
    }
    //Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
            repaint();
            game.update();
    }
}

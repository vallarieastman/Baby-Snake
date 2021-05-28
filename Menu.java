/*
This class creates the menu object. It displayes the title, and uses Graphics and graphics2D to create
play and quit buttons.

 */
import java.awt.*;
import java.awt.Graphics;

public class Menu {
    //buttons
    public static Rectangle playButton = new Rectangle(Game.width / 2 * Game.dimension -50, Game.height / 2 * Game.dimension - 30, 100, 50);
    public static Rectangle quitButton = new Rectangle(Game.width / 2 * Game.dimension - 50, Game.height / 2 * Game.dimension + 60, 100, 50);


    public static void mainMenu(Graphics g){
        //casts Graphics2D as Graphics
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 60);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("SNAKE", Game.width / 2 * Game.dimension -90, Game.height / 2 * Game.dimension - 90);

        Font fnt1 = new Font ("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.drawString("PLAY", playButton.x+12, playButton.y+ 35);
        g.drawString("QUIT", playButton.x+12, playButton.y+ 125);
        g2d.draw(playButton);
        g2d.draw(quitButton);


    }
}

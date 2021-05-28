import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    private Snake player;
    private Food food;
    private Graphics graphics;
    private Menu menu;


    private JFrame window;
    //grid size: if statement for levels?
    public static final int width = 60;
    public static final int height= 60;
    public static final int dimension = 10;

    //simulatedPlayers = new ConcurrentHashMap<Integer, SimulatedPlayer>();??

    //This is the board
    public Game(){
        window = new JFrame();
        player = new Snake();
        food = new Food(player);
        graphics = new Graphics(this);
        window.add(graphics);
        window.setTitle("SNAKE");
        window.setSize(width * dimension, height * dimension);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //starts at the menu state
    public void start() {
        graphics.state = "MENU";
    }

    //updates the board state, snake body, and spawns food
    public void update() {
        if(graphics.state == "RUNNING") {
            if(check_food_collision()) {
                player.grow();
                food.random_spawn(player);
            }
            else if(check_wall_collision() || check_self_collision()) {
                graphics.state = "END";
            }
            else {
                player.move();
            }
        }
    }
    //functions to check collisions:
    private boolean check_wall_collision() {
        if(player.getX() < 0 || player.getX() >= width * dimension
                || player.getY() < 0|| player.getY() >= height * dimension) {
            return true;
        }
        return false;
    }

    private boolean check_food_collision() {
        if(player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension) {
            return true;
        }
        return false;
    }

    private boolean check_self_collision() {
        for(int i = 1; i < player.getBody().size(); i++) {
            if(player.getX() == player.getBody().get(i).x &&
                    player.getY() == player.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }

    //keylistener allows the user to engage with the keybaord
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
    //Game state stuff:
        //game state start means that the start menu and directions are being shown
        if (graphics.state == "START") {
            //player can hit q to quit
            if (keyCode == KeyEvent.VK_Q) {
                graphics.state = "END";
            } else {
                //game state running means the game is actually being played.
                graphics.state = "RUNNING";
            }
        }
        //as long as the game state is running, the keyevent w,a,s,d will control the snake
            if (graphics.state == "RUNNING") {
                if (keyCode == KeyEvent.VK_W  && player.getMove() != "DOWN") {
                    player.up();
                }

                if (keyCode == KeyEvent.VK_S && player.getMove() != "UP") {
                    player.down();
                }

                if (keyCode == KeyEvent.VK_A && player.getMove() != "RIGHT") {
                    player.left();
                }

                if (keyCode == KeyEvent.VK_D && player.getMove() != "LEFT") {
                    player.right();
                }

            } else {
                this.start();

            }
    }
/*
    public static void createSimulatedPlayers() {
        }
    }
 */

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //getters and setters for player, food, and window
    public Snake getPlayer() {
       return player;
    }

    public void setPlayer(Snake player){
        this.player = player;
    }

    public Food getFood(){
        return food;
    }

    public void setFood(Food food){
        this.food = food;
    }

    public JFrame getWindow(){
        return window;
    }

    public void setWindowFood (JFrame Window){
        this.window = window;
    }

}

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;//game should not play by itself
    private int score = 0;//starting score should be zero
    private int totalBricks = 21;

    private Timer timer;//for controlling time of the ball
    private int delay = 8;
    private int playerX = 310;//starting position of the slider
    private int ballposX = 120;//initial position of the ball
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    public Gameplay() //constructor
    {
        addKeyListener (this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer (delay, this);
        timer.start();

    }

    public void paint(Graphics g)//to draw things
    {
        //background
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);//left border
        g.fillRect(0,0,692,4);//top border
        g.fillRect(684,0,3,592);//right border
        //no border for down-side because want to end the game when ball moves down

        //the paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);

        g.dispose();

    }

    //no use of them
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void actionPerformed(ActionEvent e) {//method will be automatically called, we don't need to call it
        timer.start();
        repaint();//it will recall paint method and draw each and every thing again
    }


    @Override
    public void keyPressed(KeyEvent e) {
        //for left key to move left and vice versa
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerX >= 600)
            {
                //keep it to the border of the panel, it doesn't go out of it
                playerX = 600;
            }
            else
            {
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerX <10)
            {
                //keep it to the border of the panel, it doesn't go out of it
                playerX = 10;
            }
            else
            {
                moveLeft();
            }
        }
    }

    public void moveRight() {
        play = true;//it was set false on top
        playerX+=20;//if right move 20 pixels to right
    }
    public void moveLeft() {
        play = true;//it was set false on top
        playerX-=20;//if right move 20 pixels to left
    }


}

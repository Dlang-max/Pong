import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Class for the ball used in this Pong game
 */
public class Ball {

    private int x, y, xVelo, yVelo; 
    private BufferedImage mo; 

    private static final int BALL_SIZE = 20; 
    private static final int MAX_WIDTH = ( int )Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int MAX_HEIGHT = ( int )Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    /**
     * Constructs a new ball object
     * 
     * @param x the x coordinate of the ball
     * @param y the y coordiante of the ball
     * @param xVelo the x component of the velocity of the ball
     * @param yVelo the y component of the velocity of the ball
     */
    public Ball( int x, int y, int xVelo, int yVelo )
    {
        this.x = x; 
        this.y =y;
        this.xVelo = xVelo;
        this.yVelo = yVelo; 

        try
        {
            mo = ImageIO.read( new File( "Pong/Mo.png" ) );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

    }

    /**
     * Gets the x coordiante of the ball on the screen
     * 
     * @return the x coordinate of the ball
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Gets the y coordinate of the ball on the screen
     * 
     * @return the y coordinate of the ball 
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Gets the x component of the velocity of the ball
     * 
     * @return the x component of the velocity of the ball
     */
    public int getXVelo()
    {
        return this.xVelo;
    }

    /**
     * Gets the y component of the velocity of the ball
     * 
     * @return the y component of the velocity of the ball
     */
    public int getYVelo()
    {
        return this.yVelo;
    }

    /**
     * Sets the x coordinate of the ball
     * 
     * @param x the x coordinate that is being set
     */
    public void setX( int x )
    {
         this.x = x;
    }

    /**
     * Sets the y coordinate of the ball
     * 
     * @param y the y coordinate that is being set
     */
    public void setY( int y )
    {
         this.y = y;
    }

    /**
     * Sets the x component of the velocity of the ball
     * 
     * @param xVelo the x component of the ball that is being set
     */
    public void setXVelo( int xVelo )
    {
         this.xVelo = xVelo;
    }

    /**
     * Sets the y component of the velocity of the ball
     * 
     * @param yVelo the y component of the ball that is being set
     */
    public void setYVelo( int yVelo )
    {
         this.yVelo = yVelo;
    }

    /**
     * Moves the ball on the screen
     */
    public void move()
    {
        this.x += this.xVelo;
        this.y += this.yVelo; 

    }

    /**
     * Draws the ball on the screen
     * 
     * @param g the Graphics object drawing the ball
     */
    public void draw( Graphics g )
    {
        this.move();
        g.setColor( Color.WHITE );
        g.fillOval( this.x, this.y, BALL_SIZE, BALL_SIZE);
    }

    /**
     * Checks for collisions between the ball and top and bottom of the screen
     */
    public void checkCoords()
    {
        if( this.y < 0 || this. y > MAX_HEIGHT - ( BALL_SIZE + 30 ) )
        {
            this.setYVelo( -this.yVelo );
        }
    }

    /**
     * Checks to see if the ball has been scored
     * 
     * @param r the player controlling the right paddle
     * @param l the plaer controlling the left paddle
     */
    public void checkIfScored( Player r, Player l )
    {
        if( this.x < 0 )
        {
            r.setScore( r.getScore() + 10 );
            this.x = MAX_WIDTH / 2;
            this.y = MAX_HEIGHT / 2; 
            this.xVelo = -8;
            this.yVelo = -4; 
        }

        if( this.x + BALL_SIZE > MAX_WIDTH )
        {
            l.setScore( l.getScore() + 10 );
            this.x = MAX_WIDTH / 2;
            this.y = MAX_HEIGHT / 2; 
            this.xVelo = 8;
            this.yVelo = 4;
        }
    }

    /**
     * :)
     * 
     * @param g the Graphics object doing the drawing
     */
    public void drawMo( Graphics g )
    {
        g.drawImage( mo, this.x, this.y, BALL_SIZE, BALL_SIZE, null ); 
    }

    /**
     * Gets the size of the ball
     * 
     * @return the size of the ball
     */
    public int getSize()
    {
        return BALL_SIZE;
    }
    
}

import java.awt.*;

/**
 * Class for the Paddle in our game
 */
public class Paddle {

    private int x, y, yVelo; 
    private Color color; 

    private static final int PADDLE_WIDTH = 20; 
    private static final int PADDLE_HEIGHT = 100; 

    private static final int MAX_HEIGHT = ( int )Toolkit.getDefaultToolkit().getScreenSize().getHeight();


    /**
     * Constructs a new Paddle object
     * 
     * @param x the x coordinate of the paddle
     * @param y the y coordinate of the paddle
     * @param yVelo the y component of the paddle's velocity
     * @param color the color of the paddle
     */
    public Paddle( int x, int y, int yVelo, Color color )
    {
        this.x = x; 
        this.y =y;
        this.yVelo = yVelo; 
        this.color = color; 
    }

    /**
     * Gets the x coordinate of the paddle
     * 
     * @return the x coordinate of the paddle
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Gets the y coordinate of the paddle
     * 
     * @return the y coordinate of the paddle
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Gets the y component of the paddle's velocity
     * 
     * @return the y component of the paddle's velocity
     */
    public int getYVelo()
    {
        return this.yVelo;
    }

    /**
     * Sets the x coordinate of the paddle
     * 
     * @param x the x coordinate of the paddle being set
     */
    public void setX( int x )
    {
         this.x = x;
    }

    /**
     * Sets the y coordinate of the paddle
     * 
     * @param y the y coordinate of the paddle being set
     */
    public void setY( int y )
    {
         this.y = y;
    }

    /**
     * Sets the y component of the paddle's velocity
     * 
     * @param y the y component of the paddle's velocity being set
     */
    public void setYVelo( int yVelo )
    {
         this.yVelo = yVelo;
    }

    /**
     * Moves the paddle on the screen
     */
    public void move()
    {
        this.y += this.yVelo; 

    }

    /**
     * Draws the paddle on the screen
     * 
     * @param g the Grpahics object drawing the paddle
     */
    public void draw( Graphics g )
    {
        this.move();
        g.setColor( color );
        g.fillRect( this.x, this.y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    /**
     * Checks coordinate of paddle to see if it should wrap around screen
     */
    public void checkCoords()
    {

        if( this.y < 0 - PADDLE_HEIGHT )
        {
            this.y = MAX_HEIGHT; 
        }
        else if( this. y > MAX_HEIGHT )
        {
            this.y = 0; 
        }
        

    }

    /**
     * Checks to see if a ball object is colliding with this paddle
     * 
     * @param b the Ball object whose collision is being checked
     * @param left true if left paddle false for right paddle
     */
    public void checkCollisions( Ball b, boolean left )
    {
        if( left )
        {
        
            if( ( this.x + PADDLE_WIDTH ) - b.getX() >= 0 && ( b.getY() >= this.y && b.getY() <= this.y + PADDLE_HEIGHT ) )
            {
                b.setXVelo( -b.getXVelo() + 1 );
            }
        

        }
        else
        {
            if( ( this.x ) - ( b.getX() + b.getSize() ) <= 0 && ( b.getY() >= this.y && b.getY() <= this.y + PADDLE_HEIGHT ) )
            {
                b.setXVelo( -b.getXVelo() - 1 );
            }
        }
    }
}

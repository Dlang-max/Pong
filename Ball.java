import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Ball {

    int x, y, xVelo, yVelo; 
    BufferedImage mo; 

    private static final int BALL_SIZE = 20; 
    private static final int MAX_WIDTH = ( int )Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int MAX_HEIGHT = ( int )Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
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

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getXVelo()
    {
        return this.xVelo;
    }

    public int getYVelo()
    {
        return this.yVelo;
    }

    public void setX( int x )
    {
         this.x = x;
    }

    public void setY( int y )
    {
         this.y = y;
    }

    public void setXVelo( int xVelo )
    {
         this.xVelo = xVelo;
    }

    public void setYVelo( int yVelo )
    {
         this.yVelo = yVelo;
    }

    public void move()
    {
        this.x += this.xVelo;
        this.y += this.yVelo; 

    }

    public void draw( Graphics g )
    {
        this.move();
        g.setColor( Color.WHITE );
        g.fillOval( this.x, this.y, BALL_SIZE, BALL_SIZE);
    }

    public void checkCoords()
    {
        if( this.y < 0 || this. y > MAX_HEIGHT - ( BALL_SIZE + 30 ) )
        {
            this.setYVelo( -this.yVelo );
        }
    }

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

    public void drawMo( Graphics g )
    {
        g.drawImage( mo, this.x, this.y, BALL_SIZE, BALL_SIZE, null ); 
    }

    public int getSize()
    {
        return BALL_SIZE;
    }
    
}

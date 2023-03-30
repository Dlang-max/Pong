import java.awt.*;

public class Paddle {


    
    int x, y, yVelo; 
    Color color; 

    private static final int PADDLE_WIDTH = 20; 
    private static final int PADDLE_HEIGHT = 100; 

    private static final int MAX_HEIGHT = ( int )Toolkit.getDefaultToolkit().getScreenSize().getHeight();



    public Paddle( int x, int y, int yVelo, Color color )
    {
        this.x = x; 
        this.y =y;
        this.yVelo = yVelo; 
        this.color = color; 
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
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

    public void setYVelo( int yVelo )
    {
         this.yVelo = yVelo;
    }

    public void move()
    {
        this.y += this.yVelo; 

    }

    public void draw( Graphics g )
    {
        this.move();
        g.setColor( color );
        g.fillRect( this.x, this.y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

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

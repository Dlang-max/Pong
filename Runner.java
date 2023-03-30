import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.Timer;

/**
 * Runner class for our game. All coordinates done how Java does them. Meaning (0,0)
 *  is in the top left for the screen along with the objects being drawn
 */
public class Runner extends JPanel implements ActionListener, KeyListener, MouseListener
{
  
    private static final int MAX_WIDTH = ( int )Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int MAX_HEIGHT = ( int )Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final Rectangle SCREEN_DIMENSIONS =  new Rectangle( 0, 0, MAX_WIDTH, MAX_HEIGHT );
    private static final int PADDLE_SPEED = 15;

    private Player right, left; 
    private Paddle rightP, leftP; 
    private Ball ball; 

    private int rScore = 0;
    private int lScore = 0; 

    private boolean mo = false; 

    private Font font = new Font( "OCR", Font.PLAIN, 30 );



    private Timer clock;
   
    /**
     * Constructor for our game
     */
    public Runner()
    {
        clock = new Timer( 17, this ); 
        clock.start(); 

        right = new Player( 0 );
        left = new Player( 0 );

        rightP = new Paddle( MAX_WIDTH - 50, MAX_HEIGHT / 2, 0, Color.RED );
        leftP = new Paddle( 0 + 50, MAX_HEIGHT / 2, 0, Color.BLUE );

        ball = new Ball( MAX_WIDTH / 2, MAX_HEIGHT / 2, 5, 5 );
      

        addKeyListener( this );
        addMouseListener( this );

       

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
       
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
       
    }

    @Override
    public void keyPressed( KeyEvent e ) 
    {
        if( e.getKeyCode() == KeyEvent.VK_ESCAPE )
        {
            System.exit( 1 );
        }

        if( e.getKeyCode() == KeyEvent.VK_UP )
        {
            rightP.setYVelo( -PADDLE_SPEED );
        }

        if( e.getKeyCode() == KeyEvent.VK_DOWN )
        {
            rightP.setYVelo( PADDLE_SPEED );
        }

    }

    @Override
    public void keyReleased( KeyEvent e ) 
    {
        if( e.getKeyCode() == KeyEvent.VK_UP )
        {
            rightP.setYVelo( 0 );
        }

        if( e.getKeyCode() == KeyEvent.VK_DOWN )
        {
            rightP.setYVelo( 0 );
        }

        if( e.getKeyChar() == 'w' )
        {
            leftP.setYVelo( 0 );
        }

        if( e.getKeyChar() == 's' )
        {
            leftP.setYVelo( 0 );
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
        if( e.getKeyChar() == 'w' )
        {
            leftP.setYVelo( -PADDLE_SPEED );
        }

        if( e.getKeyChar() == 'm' || e.getKeyChar() == 'M' )
        {
            mo = !mo; 
        }

        if( e.getKeyChar() == 's' )
        {
            leftP.setYVelo( PADDLE_SPEED );
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if( e.getSource() == clock )
        {
            repaint();
        }
   }

    public void paintComponent( Graphics g )
    { 
        setBackground( new Color( 70, 70, 70 ) );
        super.paintComponent( g ); 

        rightP.draw(g);
        leftP.draw(g);
        ball.draw(g);

        rightP.checkCoords();
        leftP.checkCoords();
        ball.checkCoords();

        leftP.checkCollisions( ball, true );
        rightP.checkCollisions( ball, false );
        ball.checkIfScored( right, left );

        g.setFont( font );
        g.drawString( "Left: " + left.getScore(), 100, 30 );
        g.drawString( "Right: " + right.getScore(), 1000, 30 );

        if( mo )
        {
            ball.drawMo( g );
        }
    }

    /**
     * This method is run for our game to begin.
     * 
     * @param arg 
     */
    public static void main(String[] args) 
    {
        JFrame window = new JFrame( "Our Game" ); 
        Runner game = new Runner();    

        window.setBounds( SCREEN_DIMENSIONS );
        window.add( game ); 

        window.setVisible( true );  
        window.addKeyListener( game );
        
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    }    
}
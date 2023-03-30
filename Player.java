/**
 * Class for the players playing the game
 */
public class Player {

    private int score; 

    /**
     * Constructs a new Player obejct
     * 
     * @param score the score of the player
     */
    public Player( int score )
    {
        this.score = score; 
    }

    /**
     * Sets the score of the plaer
     * 
     * @param score the score of the player that is being set
     */
    public void setScore( int score )
    {
        this.score = score;
    }

    /**
     * Gets this player's score
     * 
     * @return the score of the player
     */
    public int getScore()
    {
        return this.score; 
    }
    
}

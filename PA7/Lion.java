/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors and the text book.
 * This file is used to update the behave of the Lion.
 * This file overrides the method of the main class critter to
 * update the movement behaviour of the Lion.
 */
import java.awt.Color;
public class Lion extends Feline{
    private int numoffightswon; // Number of fights won by Lion.
    private int moveCount; // How many times Lion has moved.
    private int eatenornot; // Keeps track of how many times Lion ate.
    private static final String SPECIES_NAME = "Lion";
/**
* Default constructor - creates critter with name Lion
*/
    public Lion() {
        super();
        displayName = SPECIES_NAME;
    } 

/**
* Returns the color of the Lion
* 
* @return Color pink
*/
    @Override 
    public Color getColor() {
        return Color.YELLOW;
    }
// Returns the direction Lion should move towards based on the number of
//movement Lion has done.
    @Override
    public Direction getMove() {
        moveCount += 1;
        if(moveCount < 6){
            return Direction.EAST;
        }
        else if( moveCount < 11){
            return Direction.SOUTH;
        }
        else if( moveCount < 16){
            return Direction.WEST;
        }
        else{
            if (moveCount == 20){
                moveCount = 0;
            }
            return Direction.NORTH;
        }
    }
/**
 * Returns if Lion should eat or not
 * @return true if Lion has won a fight and did not sleep.
 * @return false otherwise
 */
    @Override
    public boolean eat(){
        if(numoffightswon >= 1 && eatenornot == 0){
            eatenornot += 1;
            return true;
        }
        else{
            return false;
        }
    }
// Resets the number of fights won to zero and Lion name backwards.
    @Override
    public void sleep(){
        eatenornot = 1;
        numoffightswon = 0;
        displayName = "noiL";

    }

    @Override
    public void wakeup(){
        displayName = "Lion";
    }

    @Override
    public void win(){
        numoffightswon += 1;
        eatenornot = 0;
    }
}
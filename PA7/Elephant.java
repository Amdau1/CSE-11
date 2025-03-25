/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors and the text book.
 * This file is used to update the behave of the elephant.
 * This file overrides the method of the main class critter to
 * update the movement behaviour of the elephant.
 * Aditilnaly this file keeps track of where the elephant is and
 * where it should move to
 */
import java.awt.Color;
public class Elephant extends Critter{
    protected static int goalX;
    protected static int goalY;
    private static final String SPECIES_NAME = "El";

    /**
     * Default constructor - creates critter with name El
     */
    public Elephant() {
        super(SPECIES_NAME);
        goalX = 0;
        goalY = 0;
    } 

    /**
     * Returns the color of the Elephant
     * 
     * @return Color pink
     */
    @Override 
    public Color getColor() {
        return Color.GRAY;
    }
// Updates the movement of the elephants.
    @Override
    public Direction getMove() {
        if( goalX == info.getX() && goalY == info.getY()){
            goalX = (int) random.nextInt(info.getWidth());
            goalY = (int) random.nextInt(info.getHeight());
        }
        int sumofX = goalX - info.getX();
        int sumofY = goalY - info.getY();
        if (Math.abs(sumofX) == Math.abs(sumofY) && sumofX < 0){
            return Direction.WEST;
        }
        else if (Math.abs(sumofX) == Math.abs(sumofY) && sumofX > 0){
            return Direction.EAST;
        }
        else if(Math.abs(sumofX) > Math.abs(sumofY) && sumofX < 0){
            return Direction.WEST;
        }
        else if(Math.abs(sumofX) > Math.abs(sumofY)&& sumofX > 0){
            return Direction.EAST;
        }
        else if(Math.abs(sumofY) > Math.abs(sumofX) && sumofY < 0){
            return Direction.NORTH;
        }
        else{
            return Direction.SOUTH;
        }

    }
// Elephants always eat.
/**
 * @return true all the time
 */
    @Override
    public boolean eat(){
        return true;
    }

    @Override
    public void mate(){
        level += 2;
    }

    @Override
    public void reset(){
        goalX = 0;
        goalY = 0;
    }
}

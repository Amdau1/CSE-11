/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors and the text book.
 * This file is used to update the behave of the Turtle.
 * This file overrides the method of the main class critter to
 * update the movement behaviour of the Turtle.
 * Turtle looks likes to play it safe and only eats
 * so it will only eat when there are no other animals are near it.
 */
import java.awt.Color;
public class Turtle extends Critter{
    private static final String SPECIES_NAME = "Tu";
/**
* Default constructor - creates critter with name Tu
*/
    public Turtle() {
        super(SPECIES_NAME);
    } 
/**
* Returns the color of the Turtle
* 
* @return Color pink
*/
    @Override 
    public Color getColor() {
        return Color.GREEN;
    }
/**
 * Returns teh direction Tu will move
 * @return West
 */
    @Override
    public Direction getMove() {
        return Direction.WEST;
    }
/**
 * Returns if Tu will eat or not.
 * @return true all the time.
 */
    @Override
    public boolean eat(){
        if(info.getNeighbor(Critter.Direction.EAST).equals(" ")){
        return true;
        }
        else if(info.getNeighbor(Critter.Direction.EAST).equals(".")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.EAST).equals("Tu")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.WEST).equals(" ")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.WEST).equals(".")){
            return true;
        }
        else if (info.getNeighbor(Critter.Direction.WEST).equals("Tu")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.NORTH).equals(" ")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.NORTH).equals(".")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.NORTH).equals("Tu")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.SOUTH).equals(" ")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.SOUTH).equals(".")){
            return true;
        }
        else if(info.getNeighbor(Critter.Direction.SOUTH).equals("Tu")){
            return true;
        }
        else{
            return false;
        }
    }
// Returns the attack type Tu will do.
    @Override
    public Attack getAttack(String opponent){
        int attackornot = (int) random.nextInt(2);
        if (attackornot == 0){
            return Attack.FORFEIT;
        }
        else{
            return Attack.ROAR;
        }
    }
}

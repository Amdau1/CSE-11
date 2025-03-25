/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors and the text book.
 * This file is used to update the behave of the Startfish.
 * This file overrides the method of the main class critter to
 * update the movement behaviour of the elephant.
 * Starfish does not like to do much.
 * So it satyes in the center all the time.
 */
import java.awt.Color;
public class Starfish extends Critter {
    private static final String SPECIES_NAME = "Patrick";
/**
* Default constructor - creates critter with name Patrick
*/
    public Starfish() {
        super(SPECIES_NAME);
    }

    @Override
    public Direction getMove() {
        return Direction.CENTER;
    }

/**
* Returns the color of the Starfish
* 
* @return Color pink
*/
    @Override 
    public Color getColor() {
        return Color.PINK;
    }
}
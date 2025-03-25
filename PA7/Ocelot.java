/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors and the text book.
 * This file is used to update the behave of the Ocelot.
 * This file overrides the method of the main class critter to
 * update the movement behaviour of the Ocelot.
 * Ocelot is a extended class from Leopard so it will 
 * override method from Leopard insterad of Critter.
 */
import java.awt.Color;
// import javax.xml.catalog.GroupEntry.PreferType;
public class Ocelot extends Leopard{
    private static final String SPECIES_NAME = "Oce";
/**
* Default constructor - creates critter with name Oce
*/
    public Ocelot() {
        super();
        displayName = SPECIES_NAME;
    } 

/**
* Returns the color of the Lion
* @return Color pink
*/
    @Override 
    public Color getColor() {
        return Color.LIGHT_GRAY;
    }
// This method retirns the type of attack Oce will do against specific
// types of opponent.
    @Override
    protected Attack generateAttack(String opponent){
        if(opponent.equals("Tu") || (confidence > 5 && confidence <= 10)){
            return Attack.POUNCE;
        }
        else if(opponent.equals("Lion") || opponent.equals("Fe") || opponent.equals("Lpd") || opponent.equals("noiL")){
            return Attack.SCRATCH;
        }
        else{
            return Attack.POUNCE;
        }
    }
}

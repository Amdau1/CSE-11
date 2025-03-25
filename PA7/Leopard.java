/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors and the text book.
 * This file is used to update the behave of the Leopard.
 * This file overrides the method of the main class critter to
 * update the behaviour of the Leopard.
 */
import java.awt.Color;
public class Leopard extends Feline{
    protected static int confidence = 0;
    private static final String SPECIES_NAME = "Lpd";
    protected Attack generateAttack(String opponent){
        if(opponent.equals("Tu") || (confidence > 5 && confidence <= 10)){
            return Attack.POUNCE;
        }
        else{
            int attack = (int) random.nextInt(3);
            if( opponent.equals("Patrick")){
                return Attack.FORFEIT;
            }
            else if (attack == 0){
                return Attack.SCRATCH;
            }
             else if( attack == 1){
                return Attack.ROAR;
            }
            else {
                return Attack.POUNCE;
            }
            }
    }

/**
* Default constructor - creates critter with name Lpd
*/
    public Leopard() {
        super();
        displayName = SPECIES_NAME;
    } 
/**
* Returns the color of the Lion
* @return Color pink
*/
    @Override 
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public Direction getMove() {
        int didntTurn = 0;
        if(info.getNeighbor(Critter.Direction.NORTH).equals("Patrick") || info.getNeighbor(Critter.Direction.NORTH).equals(".")){
            return Direction.NORTH;
        }
        else if(info.getNeighbor(Critter.Direction.SOUTH).equals("Patrick") || info.getNeighbor(Critter.Direction.SOUTH).equals(".")){
            return Direction.SOUTH;
        }
        else if(info.getNeighbor(Critter.Direction.EAST).equals("Patrick") || info.getNeighbor(Critter.Direction.EAST).equals(".")){
            return Direction.EAST;
        }
        else if (info.getNeighbor(Critter.Direction.WEST).equals("Patrick") || info.getNeighbor(Critter.Direction.WEST).equals(".")){
            return Direction.WEST;
        }
        else {
            didntTurn = 1;
        }
        int dirr = (int) random.nextInt(4);
        if(dirr == 0 && didntTurn == 1){
            return Direction.NORTH;
        }
        else if(dirr == 1 && didntTurn == 1){
            return Direction.SOUTH;
        }
        else if(dirr == 2 && didntTurn == 1){
            return Direction.EAST;
        }
        else if(dirr == 3 && didntTurn == 1){
            return Direction.WEST;
        }
        return Direction.EAST;
    }

    @Override
    public boolean eat(){
        int idk = (int) random.nextInt(10);
        if(confidence > idk){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void win(){
        if(confidence <= 10){
            confidence += 1;
        }
    }

    @Override
    public void lose(){
        if( confidence >= 0){
            confidence -= 1;
        }
    }

    @Override
    public Attack getAttack(String opponent){
        return generateAttack(opponent);
    }
    
    @Override
    public void reset(){
        confidence = 0;
    }
}

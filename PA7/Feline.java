/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors and the text book.
 * This file is used to update the behave of the Feline.
 * This file overrides the method of the main class critter to
 * update the movement behaviour of the elephant.
 * This critter moves randomely.
 * Feline is not hungry all the time but it does 
 * get hungry after seeing food multiple times.
 */
public class Feline extends Critter {
    private int moveCount; //counter for getMove method before random direction
    private int noteatenCount; //counter for eating
    private Direction currentDirection; //current direction
    private static final String SPECIES_NAME = "Fe";

    public Feline() {
        super(SPECIES_NAME);
    }
// Returns a random diresction for the Feline to move.
    @Override
    public Direction getMove() {
        moveCount += 1;
        if( moveCount == 1){
            int attackornot = (int) random.nextInt(4);
            if( attackornot == 0){
                currentDirection = Direction.NORTH; 
            }
            else if( attackornot == 1){
                currentDirection = Direction.SOUTH;
            }
            else if(attackornot == 2){
                currentDirection = Direction.EAST;
            }
            else{
                currentDirection = Direction.WEST;
            }
        }
// Changes direction every 5 steps or every 5 times they move.
        else if( moveCount % 5 == 1){
            int attackornot = (int) random.nextInt(4);
            if( attackornot == 0){
                currentDirection = Direction.NORTH; 
            }
            else if( attackornot == 1){
                currentDirection = Direction.SOUTH;
            }
            else if(attackornot == 2){
                currentDirection = Direction.EAST;
            }
            else{
                currentDirection = Direction.WEST;
            }
        }
        return currentDirection;
    }    
// returns whether Fe should eat or not when this method is called.
    @Override
    public boolean eat() {
        noteatenCount += 1;
        if(noteatenCount % 3 == 0){
            return true;
        }
        else {
            return false;
        }
    }
/**
 * Returns the attack type that Fe wil do
 * @return pounch all the time.
 */
    @Override
    public Attack getAttack(String opponent){
       return Attack.POUNCE;
    }
}
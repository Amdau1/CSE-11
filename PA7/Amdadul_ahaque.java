public class Amdadul_ahaque extends Critter{
protected static int goalX;
protected static int goalY;
private static final String SPECIES_NAME = "Amdadul";
public Amdadul_ahaque() {
    super(SPECIES_NAME);
    goalX = 0;
    goalY = 0;
} 
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
@Override
public Attack getAttack(String opponent){
   return Attack.POUNCE;
}
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
}
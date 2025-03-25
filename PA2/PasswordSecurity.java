import java.util.*;
public class PasswordSecurity{
    public static void main (String[] args){
    Scanner input = new Scanner (System.in);
    System.out.print("Please enter a password: ");
    String password = input.nextLine();
    if (password.length()<8){
        System.out.println("Password is too short");
        return;
    }
    int uppercase = 0;
    int lowercase = 0;
    int number = 0;
    int symbols = 0;
    int up = 0;
    int low = 0;
    int strength = 0;
    int lengthChange = 0;
//checks for the amount of lowercase, uppercase, number and symbols there are in the program.
    for (int i = 0; i <= password.length() - 1; i++){
        char check = password.charAt(i);
    if (Character.isUpperCase(check)){
        uppercase++;
        up = 1;
    }
    else if(Character.isLowerCase(check)){
        lowercase++;
        low = 1;
    }
    else if(Character.isDigit(check)){
        number = 1;
    }
    else{
        symbols = 1;
    }
    }
    strength = up + low + number + symbols;
    //checks the strentgh of the password
    if (strength == 1){
            System.out.println("Password strength: very weak");
    }
        else if ( strength == 2){
            System.out.println("Password strength: weak"); 
    }
        else if (strength == 3){
            System.out.println("Password strength: medium");
    }
        else if ( strength == 4){
            System.out.println("Password strength: strong");
            return;
    }
    if( uppercase + lowercase < 2){
     password = "Cse" + password;
     lengthChange = 3;
    }
    else if (lowercase == 0){
        for( int i = 0; i < password.length(); i++){
        char change = password.charAt(i);
            if (Character.isUpperCase(change)){
            password = password.substring(0 , i) + Character.toLowerCase(change) + password.substring(i+1 , password.length());
             break;   
            }
    }
    }
    else if(uppercase == 0){
        String cll = "";
        int placeHolder = 0;
        for(int j= 0; j < password.length(); j++){
            char lowerCase = password.charAt(j);
            if (Character.isLowerCase(lowerCase)){
                cll= cll + lowerCase;
                placeHolder = j;
            }
        }
        char highestLowLetter = cll.charAt(0);
        for (int k = 0; k < cll.length(); k++){
            char checkforlowletters = cll.charAt(k);
            if (highestLowLetter < checkforlowletters){
            highestLowLetter = checkforlowletters;
            }
        }
        for (int m = 0; m < password.length(); m++){
            if (password.charAt(m) == highestLowLetter){
                password = password.substring(0 , m) + Character.toUpperCase(highestLowLetter) + password.substring(m + 1 , password.length());
                break;
            }
        }
        }
    if (number == 0){
        String lengthcheck= "";
    int k = (password.length()-lengthChange)% 10;
    for (int l = 0; l < password.length(); l++){
        if ((l % 4 == 0 && l >0)){
        lengthcheck = lengthcheck + password.substring(l-4,l) + k;
        }
    }

    if(password.length()%4 == 1){
        lengthcheck = lengthcheck + password.substring(password.length() - 1, password.length());
    }
    else if(password.length() %4 == 2){
        lengthcheck = lengthcheck + password.substring(password.length() - 2, password.length());
    }
    else if(password.length() %4 == 3){
        lengthcheck = lengthcheck + password.substring(password.length() - 3, password.length());
    }
    else{
        lengthcheck = lengthcheck + password.substring(password.length() - 4, password.length());
    }

    if (password.length() % 4 == 0){
        lengthcheck = lengthcheck + k;
    }
    password = lengthcheck;
}
    if(symbols == 0){
        password = password + "@!";
    }

    System.out.print("Here is a suggested stronger password: " + password);
    }
}
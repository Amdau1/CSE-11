/**
 * This program is about utilizing the methods that you have already created in other methods.
 * Name: Amdadul Haque
 * Email: ahauqe@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, textbook
 */
// This class is able to add/multiply any strings given. Aditionally this can add or remove zeros depending on the given value.
public class Calculator {
    public static void  main(String [] args){
        System.out.println(stripZeros(".001"));
    }
// This method gives only whole number part of the number.
public static String extractWholeNumber(String number){
    for (int i = 0; i < number.length(); i++){
        char check = number.charAt(i);
        char decimil ='.';
        String idk = "";
        if (check == decimil){
            idk = number.substring(0,i);
            number = idk;
            if (number == ""){
                number += "0";
            }
        }
   }
   return number;

}
// This method gives only the decimal part of the number.
public static String extractDecimal(String number){
    int decimal = 0;
    for (int j = 0; j < number.length() - 1; j++){
        char whatisit = number.charAt(j);
        char dot ='.';
        String newLine = "";
        if (whatisit == dot){
            newLine = number.substring(j+1, number.length());
            number = newLine;
            decimal = 1;
            }
        }
        if(decimal == 0){
            number = "0";
        }
        System.out.println(number);
   return number;
}
// This mthod adds zeros using numZero at front of given number.
public static String prependZeros(String number, int numZeros){
    String newNumber1 ="";
    for (int j = 0; j < numZeros; j++){
        newNumber1 += "0";
    }
    newNumber1 = newNumber1 + number;
    return newNumber1;
}
// This method adds zeros using numZero after the given jumber.
public static String appendZeros(String number, int numZeros){
    String newNumber2 ="";
    for (int k = 0; k < numZeros; k++){
        newNumber2 += "0";
    }
    newNumber2 = number + newNumber2;
    return newNumber2;
}
// This method removes all leading & trailing zeros from number unless it is the only zero before or after the decimal.
public static String stripZeros(String number){
    String wholenumber = extractWholeNumber(number);
    if(wholenumber.equals("0")){
        wholenumber = "";
    }
    String decimalPart = extractDecimal(number);
    if(decimalPart.equals("0")){
        decimalPart = "";
    }
    int nodecimal = 0;
    int nowhole = 0;
    if( wholenumber != ""){
    for ( int i = 0; i < wholenumber.length(); i++){
        if(wholenumber.charAt(i) != '0'){
            wholenumber =wholenumber.substring(i, wholenumber.length());
            nowhole = 0;
            break;
        }
        else{
            nowhole = 1;
        }
    }
}
if( decimalPart != ""){
    for(int i = decimalPart.length() - 1; i > 0; i--){
         if(decimalPart.charAt(i) != '0'){
            decimalPart = "." + decimalPart.substring(0 , i + 1);
            nodecimal = 0;
            break;
         }
         else{
            nodecimal = 1;
         }
    }
}
    if(nodecimal == 1 && decimalPart != ""){
        decimalPart = decimalPart.substring(0 , 1);
    }

    if (nowhole == 1 && wholenumber != ""){
        wholenumber = wholenumber.substring( 0 , 1);
        }
    String finalNumber = wholenumber + decimalPart;
   return finalNumber;
}
// This method adds firstDigit and secondDigit & gives the last number of ther result.
public static char addDigits(char firstDigit, char secondDigit, boolean carryIn){
    int sum1 = firstDigit  - '0';
    int sum2 = secondDigit - '0';
    int sum3 = 0 - '0';
    if (carryIn == true){
        sum3 = 1;
    }
    else{
        sum3 = 0;
    }
    int finalSum = sum1 + sum2 + sum3;
    int result = finalSum % 10;
    result = result + '0';
    char convert = (char) result;
    return convert;
}
// This method tells you if carryIn is true or false.
public static boolean carryOut(char firstDigit, char secondDigit, boolean carryIn){
    int sum4 = (int) firstDigit - '0';
    int sum5 = (int) secondDigit - '0';
    int sum6 = 0;
    if (carryIn == true){
        sum6 = 1;
    }
    else{
        sum6 = 0;
    }
    int finalSum = sum4 + sum5 + sum6;
    int result = finalSum;
    if (result >= 10){
        carryIn = true;
    }
    else{
        carryIn = false;
    }
    return carryIn;
}
// This method adds firstNumber and secondNumber
public static String add(String firstNumber, String secondNumber){
    String decimalOfFirst = extractDecimal(firstNumber);
    String decimalOfSecond = extractDecimal(secondNumber);
    String wholeOfFirst = extractWholeNumber (firstNumber);
    String wholeOfSecond = extractWholeNumber (secondNumber);
    int balanceOfDecimal = 0;
    int balanceOfWhole = 0;
    String AOFN = "";
    String AOSN = "";
    String result = "";
    if( decimalOfFirst.length() < decimalOfSecond.length()){
        balanceOfDecimal = decimalOfSecond.length() - decimalOfFirst.length();
        for (int o = 0; o < balanceOfDecimal; o++){
            decimalOfFirst += "0";
        }
    }
    else if (decimalOfSecond.length() < decimalOfFirst.length()){
        balanceOfDecimal = decimalOfFirst.length() - decimalOfSecond.length();
        for (int p = 0; p < balanceOfDecimal; p++){
            decimalOfSecond += "0";
        }
    }
    if (wholeOfFirst.length() < wholeOfSecond.length()){
        balanceOfWhole = wholeOfSecond.length() - wholeOfFirst.length();
        for (int  q = 0; q < balanceOfWhole; q++){
            wholeOfFirst = "0" + wholeOfFirst;
        }
    }
    else if(wholeOfSecond.length() < wholeOfFirst.length()){
        balanceOfWhole = wholeOfFirst.length() - wholeOfSecond.length();
        for (int  r = 0; r < balanceOfWhole; r++){
            wholeOfSecond = "0" + wholeOfSecond;
        }
    }
    AOFN = wholeOfFirst + "." + decimalOfFirst;
    AOSN = wholeOfSecond + "." + decimalOfSecond;
    String number = "";
    boolean trueorfalse = false;
    for (int s = AOFN.length() - 1; s >= 0; s--){
        if (AOFN.charAt(s) == '.'){
            number = "." + number;
            continue;
        }
     char idk = addDigits(AOFN.charAt(s), AOSN.charAt(s), trueorfalse);
     number = idk + number;
     trueorfalse = carryOut(AOFN.charAt(s), AOSN.charAt(s), trueorfalse);
    }
    if(trueorfalse){
        number = '1' + number;
    }

    return number;
}
// This methos multiplies number with numTimes.
public static String multiply(String number, int numTimes){
    if(numTimes == 0){
        return "0.0";
    }
    String newNum = "0";
    for( int t = 0; t < numTimes; t++){
        newNum = add(newNum, number); 
    }
    return newNum;
}
}

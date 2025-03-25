/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, Textbook.
 * This file is used to put characters in certain orders
 * Aditionally this fikle is used to create strings from characters.
 * This file acomplishes these goals by creating new objects and list.
 * Which later on they are assigned a value.
 */
public class MyStringBuilder {
    private static final String EMPHTY_STRING= "";
// Instance variables for this class.
    private CharNode start;
    private CharNode end;
    private int length;
// Creates a MyStringbuilder object with a single char
// And initializes the instance variable accordingly.
    public MyStringBuilder(char ch) {
        start = new CharNode(ch);
        end = start;
        length = 1;
    }
/**
 * Creates a MyStringBuilder object with a string
 * Utilizess the apped method created later on to create a string
 * @return NullPointerException() if the string passes on is nul.
 */
    public MyStringBuilder(String str) {
        if(str == null){
            throw new NullPointerException();
        }
        else{
            append(str);
        }
    }
// Deep copys the conent of the original MyStringBuilder
// Also initialzes the instance variable
    public MyStringBuilder(MyStringBuilder other) {
        this.start = new CharNode(other.start.getData());
        this.length = other.length;
        CharNode list = other.start.getNext();
        CharNode adding = start;
        while(list != null){
            CharNode newNode = new CharNode(list.getData());
            adding.setNext(newNode);
            list = list.getNext();
            adding = adding.getNext();
        }
        end = adding;  
    }
/**
 * @return length of the current MyStringBuilder.
 */
    public int length() { 
        return this.length;
    }
// This method adds char.
    public MyStringBuilder append(char ch) {
        length += 1;
        if(start == null){
            start = new CharNode(ch);
            end = start;
        }
        else{
            CharNode newChar = new CharNode(ch);
            end.setNext(newChar);
            end = end.getNext();
        }
        return this;
    }
// This method adds the given string.
    public MyStringBuilder append(String str) {
        for(int i = 0; i < str.length(); i++){
            char strtochar = str.charAt(i);
            append(strtochar);
        }
        return this;
    }
// Return a actual char from chars
    public String toString() {
        String convert = EMPHTY_STRING;
        CharNode gettingInfo = this.start;
        if(length == 0){
            return convert;
        }
        else{
            for(int i = 0; i < length; i++){
                convert += gettingInfo.getData();
                gettingInfo = gettingInfo.getNext();
            }
        }
        return convert;
    }
// returns a string from the given starting endex to the end.
    public String subString(int startIdx) {
        if(startIdx < 0){
            throw new IndexOutOfBoundsException();
        }
        else if(startIdx >= length){
            throw new IndexOutOfBoundsException(); 
        }
        else{
        String newString = EMPHTY_STRING;
        CharNode gettingStart = this.start;
        for(int i = 0; i < length; i++){
            if(i >= startIdx){
              newString += gettingStart.getData();  
            }
            gettingStart = gettingStart.getNext();
        }
        return newString;
    }
    }
// Returns the string starting from StartIdx to endIdx.
    public String subString(int startIdx, int endIdx) {
        String wantedString = EMPHTY_STRING;
        if(startIdx == endIdx){
            return wantedString;
        }
        else if(startIdx < 0 || startIdx > length){
            throw new IndexOutOfBoundsException();
        }
        else if(endIdx > length || endIdx < startIdx){
            throw new IndexOutOfBoundsException();
        }
        else{
            CharNode Start = this.start;
            for(int i = 0; i < length; i++){
                if(i >= startIdx && i < endIdx){
                    wantedString += Start.getData();  
                }
            Start = Start.getNext();
            }
        return wantedString;
        }
    }   
}
import java.util.*;
public class GradeCalculator {
    public static void main(String[] args) {
    Scanner input = new Scanner (System.in);
    int n = input.nextInt();
    double grade = 0;
    double ProgramAssignmentScore = 0;
    double score = 0;
    double s = 0;
    double MidtermScore = 0;
    double FinalScore = 0;
    for(int i = 0; i < n; i++){
        ProgramAssignmentScore = input.nextDouble();
        score += ProgramAssignmentScore;
        if ( ProgramAssignmentScore < 0 || ProgramAssignmentScore > 100){ 
            s = 1;}
    }
    if (n >= 1){
        MidtermScore = input.nextDouble();
        FinalScore = input.nextDouble();
    }
    input.close();
    if(n < 1){
        System.out.print("invalid input");
        return;
    }
    else if ( s > 0){
        System.out.print("invalid input");
        return;
    }
    else if (MidtermScore > 100 || MidtermScore < 0){
        System.out.print("invalid input");
        return;
    }
    else if(FinalScore < 0 || FinalScore > 100) {
        System.out.print("invalid input");
        return;
    }
    else{
        grade = (score/n) * 0.5 + MidtermScore * 0.125 + FinalScore * 0.375;
        System.out.println(grade);
 
    }
    
    if(grade >= 0 && grade < 60 ){
        System.out.print("F");
    }
    else if( grade >= 60 && grade < 70){
        System.out.print("D");
    }
    else if( grade >= 70 && grade < 80){
        System.out.print("C");
    }
    else if( grade >= 80 && grade < 90){
        System.out.print("B");
    }
    else if( grade >= 90 && grade <= 100){
        System.out.print("A");
    }
    else {
    System.out.print("");
    }
}
}
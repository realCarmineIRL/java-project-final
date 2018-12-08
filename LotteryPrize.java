/*
LotteryPrize.java
C. Calicchio D. Ivusic S. Rodriguez
20181114
*/
import java.util.*;

public class LotteryPrize{

    //Declare
    private int guessedNumbers;
    private String prize;

    //Constructor
    public LotteryPrize(){
        guessedNumbers = 0;
        prize = "";
    }

    //Setter
    public void setGuessedNumbers(int guessedNumbers){
        this.guessedNumbers = guessedNumbers;
    }

    //Compute
    public void checkPrize() {
        switch(guessedNumbers) {
            case 3: 
                prize = "EUR100";
                break;
            case 4: 
                prize = "EUR250";
                break;
            case 5:
                prize = "EUR1000";
                break;
            case 6:
                prize = "Won the Lottery";
                break;
            default:
                prize = "0";
        }
    }

    //Getter
    public String getPrize(){
        return prize;
    }

}
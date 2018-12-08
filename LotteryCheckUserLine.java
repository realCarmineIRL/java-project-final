/*
LotteryCheckUserLine.java
C. Calicchio D. Ivusic S. Rodriguez
20181114
*/
import java.util.*;

public class LotteryCheckUserLine{

    //Declare Variables
    private String line;
    private String[] numbers;
    private List<Integer> userLine;
    private boolean isValid;
    private String errorMsg;

    //Constructor
    public LotteryCheckUserLine(){
       this.line = "";
       this.isValid = true;
       this.errorMsg = "";
    }

    //Setter
    public void setUserLine(String line){
        this.line = line;
    }

    //Compute
    public void compute() {
        //Split User Line
        numbers = line.split(",");

        userLine = new ArrayList<>();

        //Assing numbers in line into ArrayList
        for (int i=0; i<numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            //Validate if number is in range
            if(number <= 0 || number > 40) {
                isValid = false;
                errorMsg = "Number " + number + " in line out of range.";
            }
            userLine.add(number);
        }

        //Validate if line has the correct number of numbers
        if(userLine.size() <= 5 || userLine.size() > 6) {
            isValid = false;
            errorMsg = "You have introduced invalid numbers, please make sure 6 numbers are introduced";
        }
    }

    //Getters
    public List<Integer> getUserLine(){
        return userLine;
    }

    public boolean getIsValid(){
        return isValid;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
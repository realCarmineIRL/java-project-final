/*
LotteryApp.java
C. Calicchio D. Ivusic S. Rodriguez
20181114
*/
import java.util.*;
import javax.swing.*;

public class LotteryApp{
    public static void main(String[] args) {
        
        //Declare Variables
        List<Integer> lotteryLine;
        LotteryGenLine myLotteryGenLine;
        LotteryCheckUserLine myLotteryCheckUserLine;
        LotteryPrize myLotteryPrize;
        List<String> gameHistory;
        String gameResult;
        String prize;
        String option;
        String[] userLines = new String[3];
        boolean isValid;
        String errorMsg;
        String showGameHistory;
        
        //Loop
        do {

            gameHistory = new ArrayList<>();
            showGameHistory = "";

            myLotteryGenLine = new LotteryGenLine();
            myLotteryPrize = new LotteryPrize();

            myLotteryGenLine.genLotteryLine();
            lotteryLine = myLotteryGenLine.getLotteryLine();

            //System.out.println(lotteryLine);
            //Check line introduced by user
            for (int i=0; i<userLines.length; i++) {
                isValid = false;
                errorMsg = "";
                do {
                    myLotteryCheckUserLine = new LotteryCheckUserLine();

                    userLines[i] = JOptionPane.showInputDialog(null,"Please enter your line number " + (i+1) +" separated by ',' :");

                    myLotteryCheckUserLine.setUserLine(userLines[i]);

                    myLotteryCheckUserLine.compute();

                    isValid = myLotteryCheckUserLine.getIsValid();

                    if(!isValid) {
                        errorMsg = myLotteryCheckUserLine.getErrorMsg();
                        JOptionPane.showMessageDialog(null,errorMsg);
                    } 
                    
                } while (!isValid);

                List<Integer> matchedNumbers = myLotteryCheckUserLine.getUserLine();
                //get match numbers between user line and lottery line
                matchedNumbers.retainAll(lotteryLine);

                //Checking number of matched numbers
                myLotteryPrize.setGuessedNumbers(matchedNumbers.size());
                myLotteryPrize.checkPrize();
                prize = myLotteryPrize.getPrize();

                //get result of game
                gameResult = "Lottery Line = " + lotteryLine + 
                             " your line was = " + userLines[i] + 
                             " you have guessed " + matchedNumbers.size() + " numbers " +
                             " and your prize is " + prize +
                             "\n\n";

                gameHistory.add(gameResult);
                
            }

            for (int i = 0; i<gameHistory.size(); i++) {
                showGameHistory += gameHistory.get(i);
            }
            //Print result in popup message
            JOptionPane.showMessageDialog(null,showGameHistory);

            //Play Again
            option = JOptionPane.showInputDialog(null,"Would you like to continue Y or N:");
            
        } while (option.equals("Y"));

    }
}
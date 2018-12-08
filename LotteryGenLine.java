/*
LotteryGenLine.java
C. Calicchio D. Ivusic S. Rodriguez
20181114
*/
import java.util.*;

public class LotteryGenLine{
    // Declare
    private ArrayList<Integer> line;
    private List<Integer> lotteryLine;

    //Constructor
    public LotteryGenLine(){
        line = new ArrayList<>(40);
    }

    //Compute
    public void genLotteryLine() {
        //get numbers from 1 to 40
        for(int i = 1; i <= 40; i++){
            line.add(i);
        }
        //Shuffle elememnts in ArrayList
        Collections.shuffle(line);

        //get first un ordered elements from array
        lotteryLine = line.subList(0, 6);
        //Order line
        Collections.sort(lotteryLine);
    }
    //Getter
    public List<Integer> getLotteryLine(){
        return lotteryLine;
    }

}
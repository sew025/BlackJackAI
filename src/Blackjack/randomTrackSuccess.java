package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class randomTrackSuccess {
    private static double[] successes;
    private static double success;
    private static double count;



    public static double[] trackSuccess(int numHands) {
        successes = new double[numHands];
        count = 0;
        success = 0;
        for(int i = 0; i < numHands;i++){
            RandomPlayGame rando = new RandomPlayGame();
            rando.blackjack();
            if (rando.isWon()) {
                success+=1;
                count+=1;
                double rate = (success/count) * 100;
                successes[i] = rate;
            }
            else{
                count+=1;
                double rate = (success/count) * 100;
                successes[i] = rate;
            }
        }
        return successes;
    }
}

package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class randomTrackSuccess {
    private static ArrayList<Double> successes;
    private static double success;
    private static double count;
    private static int numHands;


    public static void main(String[] args) {
        successes = new ArrayList<Double>();
        getNumHands();
        count = 0;
        success = 0;
        trackSuccess();
        outcome();
    }


    private static int getNumHands() {
        System.out.println("How many hands would you like to play?");
        Scanner in = new Scanner(System.in);
        numHands = in.nextInt();
        return numHands;
    }

    public static void trackSuccess() {
        System.out.println(numHands);
        for(int i = 0; i < numHands;i++){
            RandomPlayGame rando = new RandomPlayGame();
            rando.blackjack();
            if (rando.isWon()) {
                success+=1;
                count+=1;
                double rate = success/count;
                successes.add(rate);
            }
            else{
                count+=1;
                double rate = success/count;
                successes.add(rate);
            }
        }
    }

    public static ArrayList<Double> outcome(){
        System.out.println(successes);
        return successes;
    }
}

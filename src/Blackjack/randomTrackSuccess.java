package Blackjack;

import Blackjack.Dealer;
import Blackjack.Player;
import Blackjack.randomPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class randomTrackSuccess {
        private Dealer dealer;
        private ArrayList<Integer> dealerHand;
        private int dealerScore;
        private ArrayList<Integer> playerHand;
        private int playerScore;
        private randomPlayer player;
        private ArrayList<String> successes;
        private int count;


        public randomTrackSuccess(Dealer dealer, ArrayList<Integer> dealerHand, int dealerScore, ArrayList<Integer> playerHand,
                            int playerScore, Player player) {
            this.dealerHand = dealerHand;
            this.dealerScore = dealerScore;
            this.playerHand = playerHand;
            this.playerScore = playerScore;
            this.dealer = new Dealer(dealerHand, dealerScore);
            this.player = new randomPlayer(playerHand, playerScore);
            getNumHands();
        }

    private void getNumHands() {
        System.out.println("How many hands would you like to play?");
        Scanner in = new Scanner(System.in);
        int numHands = in.nextInt();
        this.successes = new ArrayList<String>(numHands);
    }

    public boolean dealerWin() {
            if (dealer.getScore() > player.getScore() && dealer.getScore() <= 21){
                return true;
            } else {
                return false;
            }
        }

        public void trackSuccess() {
            while(count < this.successes.size()){
                if (!dealerWin()) {
                    this.successes.add("win");
                    count+=1;
                }
                else{
                    this.successes.add("loss");
                    count+=1;
                }
            }
            return;
        }
}

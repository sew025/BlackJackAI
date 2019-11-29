package Blackjack;

import Blackjack.Dealer;
import Blackjack.Player;
import Blackjack.randomPlayer;
import LandingPageGUI.AIGrahpicsView;

import java.util.ArrayList;
import java.util.Scanner;

public class randomTrackSuccess {
        private Dealer dealer;
        private ArrayList<Integer> dealerHand;
        private int dealerScore;
        private ArrayList<Integer> playerHand;
        private int playerScore;
        private randomPlayer player;
        private ArrayList<Integer> successes;
        private int success;
        private int count;
        private AIGrahpicsView theView;


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
        int numHands = Integer.parseInt(theView.getnTurns().getText());
        this.successes = new ArrayList<Integer>(numHands);
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
                    success+=1;
                    count+=1;
                    this.successes.add(success/count);
                }
                else{
                    count+=1;
                    this.successes.add(success/count);
                }
            }
            outcome();
        }

        public ArrayList<Integer> outcome(){
            return this.successes;
        }
}

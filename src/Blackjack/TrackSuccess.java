     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/12/19
      * Time: 8:52 PM
      *
      * Project: csci205FinalProject
      * Package: Blackjack
      * Class: TrackSuccess
      *
      * Description:
      *
      * **************************************** */
     package Blackjack;

     import java.util.ArrayList;

     public class TrackSuccess {
          private Dealer dealer;
          private ArrayList<Integer> dealerHand;
          private int dealerScore;
          private int success;
          private ArrayList<Integer> playerHand;
          private int playerScore;
          private Player player;


          public TrackSuccess(Dealer dealer, ArrayList<Integer> dealerHand, int dealerScore, ArrayList<Integer> playerHand,
                              int playerScore, Player player) {
               this.dealerHand = dealerHand;
               this.dealerScore = dealerScore;
               this.playerHand = playerHand;
               this.playerScore = playerScore;
               this.dealer = new Dealer(dealerHand, dealerScore);
               this.player = new Player(playerHand, playerScore);
          }

          public boolean dealerWin() {
               if (dealer.getScore() > player.getScore() && dealer.getScore() <= 21){
                    return true;
               } else {
                    return false;
               }
          }

          public void trackSuccess() {
               if (!dealerWin()) {
                    success+=1;
               }
          }
     }

     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/29/19
      * Time: 12:07 AM
      *
      * Project: csci205FinalProject
      * Package: NeuralNetPlay
      * Class: NNPlayGame
      *
      * Description:
      *
      * **************************************** */
     package NeuralNetPlay;

     import Blackjack.Dealer;
     import Blackjack.Deck;
     import Blackjack.PlayGame;
     import Blackjack.Player;
     import NeuralNet.network;

     import java.util.ArrayList;

     /**
      * sets up the game with the neural network
      */

     public class NNPlayGame {
          private Deck deck = new Deck();
          private ArrayList<Integer> dealerHand = new ArrayList<>();
          private Dealer dealer;

          private ArrayList<Integer> playerHand = new ArrayList<>();
          private Player player;
          private int winloss;
          private int winTotal = 0;

          private NeuralNet.network network = new network(null, null);

          /**
           * sets up dealer and player. the network decides to hit or stand once the player and dealer both stand, it checks
           * who won or lost. This data is then added to the network for its future decisions.
           *
           * @param n the current network that os playing the game
           */

          public NNPlayGame(network n) {
               Deck deck = new Deck();
               deck.shuffle();

               //make the first two hands
               ArrayList<Integer> pHand = new ArrayList<>();
               ArrayList<Integer> dHand = new ArrayList<>();

               pHand.add(deck.getDeck().get(0));
               dHand.add(deck.getDeck().get(1));
               pHand.add(deck.getDeck().get(2));
               dHand.add(deck.getDeck().get(3));

               int startPScore = deck.getDeck().get(0) + deck.getDeck().get(2);
               ;
               int startDScore = deck.getDeck().get(1) + deck.getDeck().get(3);


               deck.getDeck().remove(0);
               deck.getDeck().remove(1);
               deck.getDeck().remove(2);
               deck.getDeck().remove(3);

               this.player = new Player(pHand, startPScore);
               this.dealer = new Dealer(dHand, startDScore);

               while (decide(player, n) == 0) {
                    player.getPlayerHand().add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
               }

               while (dealer.getScore() < 17) {
                    dealer.getDealerHand().add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
               }

               winloss = checkWin(dealer.getScore(), player.getScore());
               trackWin();
               n.addWin(winloss);

          }

          /**
           * this function is what makes the decision to hit (0) or stand (1). It first checks baseline cases i.e. busted or
           * blackjack and if neither of those are true, it asks the network if it should hit or stand. Based on its
           * current standing, the number of aces it has (if it's possible to switch the aces) and what the player can
           * see that the dealer has, it decides to hit or stand. This is based on the networks previous inputs/data stored.
           * @param p current player
           * @param n the network it is running on
           * @return 0 (hit) or 1 (stand)
           */

          private int decide(Player p, network n) {

               if (p.getScore() == 21) {
                    // System.out.println("Blackjack!");
                    return 1;
               }
               if (p.getScore() > 21) {
                    //System.out.println("Busted!");
                    return 1;
               }
               if (n.askNet(p.getPlayerHand(), p.getNumAces(), dealer.getDealerHand().get(0))) {
                    //System.out.println("Passed");
                    return 1;
               }
               return 0;
          }

          /**
           * compares the dealer and player hands to figure out who won. Returns a number based on the result, which (check NNPlayGame())
           * is added to the neural net/
           * @param dealerVal
           * @param playerVal
           * @return 0 (loss) 1 (tie) 2 (win)
           */

          public int checkWin(int dealerVal, int playerVal) {
               if (playerVal > 21) {
                    return 0;
               } else if (playerVal == 21) {
                    return 2;
               } else if (playerVal == dealerVal) {
                    return 1;
               } else if (playerVal > dealerVal) {
                    return 2;
               } else if (dealerVal > 21) {
                    return 2;
               }
               return 0;
          }

          /**
           * checks if this round is a win or not
           * @return boolean
           */

          public boolean trackWin() {
               if (winloss == 2) {
                    return true;
               }
               else {
                    return false;
               }

          }
     }





     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/29/19
      * Time: 11:20 AM
      *
      * Project: csci205FinalProject
      * Package: NeuralNetPlay
      * Class: NNTrackSuccess
      *
      * Description:
      *
      * **************************************** */
     package NeuralNetPlay;

     import LandingPageGUI.AIGrahpicsView;

     public class NNTrackSuccess {

          public NNTrackSuccess() {
          }

          private NNPlayGame game;
          private NNBlackjack blackjack;

          private int total = 0;
          private double winRate = 0;

          /**
           * starts a new game of blackjack. iterates through the networks playing and initialises a game with the
           * specified network at the list. finds if the game was on and adds one to the total if it was. It then
           * finds the win rate and adds this rate to the list of successes.
           * @return
           */

          public double[] getTotal(int size) {
               double[] NNSuccess = new double[size];
               blackjack = new NNBlackjack();
               for (int j = 0; j < size; j++) {
                    for (int i = 0; i < NNBlackjack.getNetworks().size(); i++) {
                         game = new NNPlayGame(NNBlackjack.getNetworks().get(i));
                         if (game.trackWin()) {
                              total += 1;
                         }
                    }
                    winRate = (double) total / (j + 1);
                    System.out.println(winRate);
                    NNSuccess[j] = winRate;
               }
               return NNSuccess;
          }
     }



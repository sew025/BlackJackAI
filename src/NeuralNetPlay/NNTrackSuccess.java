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

          private AIGrahpicsView theView;
          private int size = 1000;
                  //Integer.parseInt(theView.getnTurns().getText());

          private NNPlayGame game;
          private NNBlackjack blackjack;

          private int[] NNSuccess = new int[size];
          private int total = 0;
          private int winRate = 0;

          /**
           * starts a new game of blackjack. iterates through the networks playing and initialises a game with the
           * specified network at the list. finds if the game was on and adds one to the total if it was. It then
           * finds the win rate and adds this rate to the list of successes.
           * @return
           */

          public int[] getTotal() {
               blackjack = new NNBlackjack();
               for (int i = 0; i < blackjack.getNetworks().size(); i++) {
                    game = new NNPlayGame(blackjack.getNetworks().get(i));
                    for (int j = 0; i < size; i++) {
                         if (game.trackWin()) {
                              total += 1;
                         }
                         winRate = total / (j+1);
                         NNSuccess[j] = winRate;
                    }

               }
               System.out.println(NNSuccess);

               return NNSuccess;
          }


     }



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
          private int size = Integer.parseInt(theView.getnTurns().getText());

          private NNPlayGame game;

          private int[] NNSuccess = new int[size];
          private int total = 0;
          private int winRate = 0;

          public int[] getTotal() {
               for (int i = 0; i < size; i++) {
                    if (game.trackWin()) {
                         total += 1;
                    }
                    winRate = total / (i+1);
                    NNSuccess[i] = winRate;
               }
               return NNSuccess;
          }


     }



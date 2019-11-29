     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/29/19
      * Time: 12:27 AM
      *
      * Project: csci205FinalProject
      * Package: NeuralNetPlay
      * Class: NNBlackjack
      *
      * Description:
      *
      * **************************************** */
     package NeuralNetPlay;

     import LandingPageGUI.AIGrahpicsView;
     import NeuralNet.network;

     import java.util.ArrayList;
     import java.util.Collections;
     import java.util.Scanner;

     import static java.util.Comparator.comparingInt;

     public class NNBlackjack {

          private static int numTurns;

          public NNBlackjack(int numTurns) {
               this.numTurns = numTurns;
          }

          private static NNPlayGame newGame;
          private static AIGrahpicsView theView;
          private static int generations = 1000;

          private static ArrayList<network> networks= new ArrayList<>();

          private static int total = 0;
          private static double winRate = 0;

          public static double[] NNSuccess = new double[1000];


          /**
           * runs the game. First creates 100 random networks. for each network, it simulates the game 100 times, then sorts the
           * networks based on their success then removes the 50 worst ones. It then creates 50 new networks and resets the score
           * It does this as many times as the user wants to simulate. It plays the game again with the new networks, sorts them
           * and then finds the trained win %
           * @param args
           */


          public static void main(String[] args) {

               //create 100 randomly weighted neural networks
               for (int i = 0; i < 100; i++) {
                    networks.add(new network(null, null));
               }

               for (int i = 0; i < generations; i++) {

                    //simulate 100 games in each network
                    for (int j = 0; j < 100; j++) {
                         for(int k=0;k<100;k++)
                              newGame = new NNPlayGame(networks.get(j));
                              if (newGame.trackWin()) {
                                   total += 1;
                              }
                    }

                    winRate = (double) total / (i + 1);
                    System.out.println(winRate);
                    NNSuccess[i] = winRate;


                    //sort by success
                    Collections.sort(networks, comparingInt(network::getScore));

                    for (int j = 0; j < 50; j++) {
                         networks.remove(0);
                    }

                    //give each remaining network a child
                    for (int j = 0; j < 50; j++) {
                         networks.get(j).resetScore();
                         networks.add(networks.get(j).reproduce());
                    }
                    if (i % 100 == 0)
                         System.out.println("Generation " + i + " complete");
               }

               //simulate each new network
               for(int j=0;j<100;j++){
                    for(int k=0;k<100;k++)
                         newGame = new NNPlayGame(networks.get(j));
                         if (newGame.trackWin()) {
                              //getTotal();
                         }
               }

               //sort more new networks
             Collections.sort(networks, comparingInt(network::getScore));


          //calculate win%
               double avg = 0;
               int temp;
               for(int i=0;i<100;i++){
                    temp = networks.get(i).getScore();
                    avg+=temp;
               }
               avg/=(double) generations;
               System.out.println("Trained win % : " + avg);


          }

         public static ArrayList<network> getNetworks() {
             return networks;
         }

          public static double[] getTotal() {

               return NNSuccess;
          }
     }

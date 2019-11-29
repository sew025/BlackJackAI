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

     import NeuralNet.network;

     import java.util.ArrayList;
     import java.util.Collections;
     import java.util.Scanner;

     import static java.util.Comparator.comparingInt;

     public class NNBlackjack {

          private static NNPlayGame newGame;
          private static int generations = 1000;

          private static ArrayList<network> networks= new ArrayList<>();


          public static void main(String[] args) {

               //create 100 randomly weighted neural networks
               for (int i = 0; i < 100; i++) {
                    networks.add(new network(null, null));
               }

               for (int i = 0; i < generations; i++) {

                    //simulate 100 games in each network
                    for (int j = 0; j < 100; j++) {
                         for (int k = 0; k < 100; k++)
                              newGame = new NNPlayGame(networks.get(j));
                    }


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
               avg/=(double) 1000;
               System.out.println("Trained win % : " + avg);


          }


     }

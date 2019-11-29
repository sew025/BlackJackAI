     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/28/19
      * Time: 11:53 PM
      *
      * Project: csci205FinalProject
      * Package: NeuralNet
      * Class: network
      *
      * Description:
      *
      * **************************************** */
     package NeuralNet;

     import Blackjack.Cards;

     import java.util.ArrayList;

     /**
      *
      * @author ZekeR
      */
     public class network {

          private int score;
          private ArrayList<layer> layers;

          public network(layer layer1, layer layer2){

               this.score = 0;
               this.layers = new ArrayList<layer>();

               if(layer1 == null){
                    this.layers.add(new layer(12, 9, null));
                    this.layers.add(new layer(1, 12, null));
               }

               else{
                    this.layers.add(layer1);
                    this.layers.add(layer2);
               }
          }

          public boolean askNet(ArrayList<Integer> hand, int numAces, int dealerCard){

               double[] in = new double[9];
               double[] out;
               for(int i=0;i<7;i++){
                    if(i<hand.size()){
                         in[i] = hand.get(i);
                    } else {
                         in[i] = -1;
                    }
               }

               in[7] = numAces;
               in[8] = dealerCard;

               out = this.layers.get(0).fireNeurons(in);
               out = this.layers.get(1).fireNeurons(out);
               return out[0]>.5;
          }

          public void addWin(int amount){
               this.score += amount;
          }

          public int getScore(){
               return this.score;
          }

          public network reproduce(){
               layer layer1 = this.layers.get(0).reproduce();
               layer layer2 = this.layers.get(1).reproduce();

               network child = new network(layer1, layer2);

               return child;
          }

          public void resetScore(){
               this.score = 0;
          }

     }
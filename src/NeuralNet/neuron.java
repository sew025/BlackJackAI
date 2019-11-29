     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/28/19
      * Time: 11:52 PM
      *
      * Project: csci205FinalProject
      * Package: NeuralNet
      * Class: neuron
      *
      * Description:
      *
      * **************************************** */
     package NeuralNet;

     /**
      *
      * @author ZekeR
      */
     public class neuron {


          private final double[] weight;
          private final int inCount;

          /**
           * creates the individual neurons and initially gives them random weights.
           */

          public neuron(int inCount, double[] seed){
               this.inCount = inCount;
               this.weight = new double[inCount];
               if(seed == null){
                    for(int i=0;i<inCount;i++){
                         this.weight[i] = (Math.random()-.5)*10;
                    }
               }
               else {
                    for(int i=0;i<inCount;i++){
                         this.weight[i] = seed[i] + ((Math.random())-.5);
                    }
               }
          }

          public double[] getWeights(){
               return this.weight;
          }

          /**
           * fires the neuron and finds the outputs corresponding to the weight of the neurons and inputs.
           * (If im not mistaken this acts as the activation function)
           * @param in
           * @return out, the
           */

          public double fire(double[] in){
               double out = 0;
               for(int i=0;i<this.inCount;i++){
                    out += this.weight[i] * in[i];
               }

               out = 1/(1+Math.exp(0-out)); //1/(1+e^(0-out)) eg probably very close to 1

               return out;
          }
     }
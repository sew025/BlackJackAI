     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/28/19
      * Time: 11:54 PM
      *
      * Project: csci205FinalProject
      * Package: NeuralNet
      * Class: layer
      *
      * Description:
      *
      * **************************************** */
     package NeuralNet;

     import java.util.ArrayList;

     /**
      *
      * @author ZekeR
      */
     public class layer {
          private ArrayList<neuron> neurons;
          private int size;
          private int inCount;

          public layer(int size, int inCount, ArrayList<neuron> children){
               this.neurons = new ArrayList<>();
               this.size = size;
               this.inCount = inCount;
               if(children == null){
                    for(int i=0;i<size;i++){
                         neurons.add(new neuron(inCount, null));
                    }
               } else {
                    this.neurons = children;
               }
          }

          public double[] fireNeurons(double[] in){
               double[] out = new double[this.size];

               for(int i=0;i<this.size;i++){
                    out[i] = this.neurons.get(i).fire(in);
               }

               return out;
          }

          public layer reproduce(){
               ArrayList neuronChildren;
               neuronChildren = new ArrayList<>();
               for(int i=0;i<this.size;i++){
                    neuronChildren.add(new neuron(this.inCount,
                            this.neurons.get(i).getWeights()));
               }
               layer child = new layer(this.size, this.inCount,neuronChildren);

               return child;
          }
     }
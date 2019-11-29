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

          /**
           * creates layers of neurons. if the list of neurons (param children) is empty, then it adds new neurons to the
           * list/layer. if the list of neurons (param children) is not empty, then it sets the list of neurons to that
           * list.
           * @param size
           * @param inCount
           * @param children
           */

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

          /**
           * fires an entire row of neurons to get the output for that layer.
           * @param in
           * @return
           */

          public double[] fireNeurons(double[] in){
               double[] out = new double[this.size];

               for(int i=0;i<this.size;i++){
                    out[i] = this.neurons.get(i).fire(in);
               }

               return out;
          }

          /**
           * creates a new layer of neurons. eg replicates the exisiting layers.
           * @return
           */

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
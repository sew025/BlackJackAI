     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/17/19
      * Time: 4:13 PM
      *
      * Project: csci205FinalProject
      * Package: NeuralNet
      * Class: NeuralNetPractice
      *
      * Description:
      *
      * **************************************** */
     package NeuralNet;

     import java.util.Random;
     import java.util.Scanner;

     import static java.lang.Integer.parseInt;

     public class NeuralNetPractice {
          private static int learningRate = 0;
          private static int bias = 1;
          private static Random random = new Random();
          private static int[] weights = {random.nextInt(1), random.nextInt(1), random.nextInt(1)};

          public static void Perceptron(int input1, int input2, int expectedOutput) {
               int actualOutput = input1 * weights[0] + input2 * weights[1] + bias * weights[2];

               if (actualOutput > 0) {
                    actualOutput = 1;
               }
               else {
                    actualOutput = 0;
               }

               int error = expectedOutput - actualOutput; //in this case, error would only be 1 or 0
               weights[0] += error * input1 * learningRate;
               weights[1] += error * input2 * learningRate;
               weights[2] += error * bias * learningRate;

          }

          public static void learningPhase() {
               //number of iterations chosen according to desired precision. too many can case over-fitting
               //meaning that it'll only know how to handle the chosen examples so it won't get the right
               //output when it sees a case it didn't see during training.
               for (int i = 0; i < 50; i++) {
                    Perceptron(1,1,1); //True or True
                    Perceptron(1,0,1); //True or False
                    Perceptron(0,1,1); //False or True
                    Perceptron(0,0,0); //False or False
               }

          }

          public static void testingPhase() {
               Scanner in = new Scanner(System.in);
               System.out.println("Enter input1: ");
               int input1 = parseInt(in.nextLine());

               Scanner in2 = new Scanner(System.in);
               System.out.println("Enter input2: ");
               int input2 = parseInt(in2.nextLine());

               int actualOutput = input1 * weights[0] + input2 * weights[1] + bias * weights[2];

               if (actualOutput > 0) { //activation function
                    actualOutput = 1;
               }
               else {
                    actualOutput = 0;
               }
               System.out.println(input1 + " or " + input2 + " is: " + actualOutput);


          }

          public static void main(String[] args) {
               learningPhase();
               testingPhase();
          }


     }

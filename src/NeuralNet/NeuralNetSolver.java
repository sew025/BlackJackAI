     /* ***************************************** * CSCI205 - Software Engineering and Design * Fall 2019
      * Instructor: Prof. Brian King
      *
      * Name: Bea Casey
      * Section: 11am * Date: 11/19/19
      * Time: 4:19 PM
      *
      * Project: csci205FinalProject
      * Package: NeuralNet
      * Class: NeuralNetSolver
      *
      * Description:
      *
      * **************************************** */
     package NeuralNet;

     import java.io.IOException;
     import java.util.Scanner;

     public class NeuralNetSolver {

          public static Process runFile() throws IOException {
               Process process = Runtime.getRuntime().exec("python neural_net.py");
               return process;

          }


          public static void main(String[] args) throws IOException {

               Scanner in = new Scanner(System.in);
               System.out.println("Would you like to run the neural net?");
               String response = in.nextLine();
               if (response.equalsIgnoreCase("yes")) {
                    runFile();
               }
               else {
                    ;
               }

          }


     }
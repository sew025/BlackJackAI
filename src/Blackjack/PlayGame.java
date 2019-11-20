/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 11/12/19
 * Time: 3:22 PM
 *
 * Project: csci205finalproject
 * Package: Blackjack
 * Class: PlayGame
 *
 * Description:
 *
 * ****************************************
 */
package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * the running program to create a single consul version game of blackjack
 */
public class PlayGame {
    public static void main(String[] args) {
        blackjack();
    }

    /**
     * the function to play one singular turn of blackjack
     * @author Jack Otto
     */
    public static void blackjack(){
        //make and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        //make the first two hands
        ArrayList<Integer> pHand = new ArrayList<>();
        ArrayList<Integer> dHand = new ArrayList<>();

        pHand.add(deck.getDeck().get(0));
        dHand.add(deck.getDeck().get(1));
        pHand.add(deck.getDeck().get(2));
        dHand.add(deck.getDeck().get(3));

        int startPScore = deck.getDeck().get(0) + deck.getDeck().get(2);;
        int startDScore = deck.getDeck().get(1) + deck.getDeck().get(3);


        deck.getDeck().remove(0);
        deck.getDeck().remove(1);
        deck.getDeck().remove(2);
        deck.getDeck().remove(3);

        //make the player and dealer passing their hands to them and showing their hand and score
        Player player = new Player(pHand,startPScore);
        Dealer dealer = new Dealer(dHand,startDScore);

        System.out.println(player);

        //run a turn
        while(player.makeMove()){
            player.getPlayerHand().add(deck.getDeck().get(0));
            deck.getDeck().remove(0);
            System.out.println(player);
        }
        if (player.getScore()>21){
            System.out.println("You busted, you lose");
            playAgain();
        }
        else{
            System.out.println(dealer);
            while(dealer.makeMove()){
                dealer.getDealerHand().add(deck.getDeck().get(0));
                deck.getDeck().remove(0);
                System.out.println(dealer);
            }

            if(dealer.getScore()>21){
                System.out.println("Dealer busted, you win");
                playAgain();
            }
            else{
                if(player.getScore()>dealer.getScore()){
                    System.out.println("You win, you scored higher");
                    playAgain();
                }
                else if(dealer.getScore()>player.getScore()){
                    System.out.println("You lose, the dealer scored higher");
                    playAgain();
                }
                else{
                    System.out.println("It's a tie, you each scored the same");
                    playAgain();
                }
            }
        }
    }

    /**
     * function the allow the user to play again
     * @author Matt McGauley
     */
    private static void playAgain() {
        System.out.println("Would you like to play again? [Y/N]: ");
        Scanner playAgain = new Scanner(System.in);
        String decision = playAgain.nextLine();
        if (decision.equalsIgnoreCase("y")) {
            blackjack();
            System.out.println("Would you like to play again? [Y/N]: ");
            decision = playAgain.nextLine();
        }
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
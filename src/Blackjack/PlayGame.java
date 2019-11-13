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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayGame {
    public static void main(String[] args) {
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
        System.out.println(dealer);

        //run a turn
        while(player.makeMove()){
            player.getPlayerHand().add(deck.getDeck().get(0));
            deck.getDeck().remove(0);
            System.out.println(player);
        }

        if (player.getScore()>21){
            System.out.println("You busted, you lose");
        }
        else{
            while(dealer.makeMove()){
                dealer.getDealerHand().add(deck.getDeck().get(0));
                deck.getDeck().remove(0);
                System.out.println(dealer);
            }

            if(dealer.getScore()>21){
                System.out.println("Dealer busted, you win");
            }
            else{
                if(player.getScore()>dealer.getScore()){
                    System.out.println("You win, you scored higher");
                }
                else if(dealer.getScore()>player.getScore()){
                    System.out.println("You lose, the dealer scored higher");
                }
                else{
                    System.out.println("It's a tie, you each scored the same");
                }
            }
        }
    }
}
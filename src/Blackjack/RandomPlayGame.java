package Blackjack;

import java.util.ArrayList;

/**
 * class that plays our blackjack function for the user buts makes ever decision randomly between hit or stand
 */
public class RandomPlayGame {

    /**
     * boolean value that is used for when the random wins or loses
     */
    private static boolean won;

    /**
     * the running program to create a single consul version game of randomized blackjack
     */
    public static void main(String[] args) {
            blackjack();
        }

    /**
     * function to play the blackjack game with random decisions
     */
    public static void blackjack(){
            //make and shuffle the deck
            won = false;
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
            randomPlayer randomPlayer = new randomPlayer(pHand,startPScore);
            Dealer dealer = new Dealer(dHand,startDScore);


            //run a turn
            while(randomPlayer.makeMove()){
                randomPlayer.getPlayerHand().add(deck.getDeck().get(0));
                deck.getDeck().remove(0);
            }
            if (randomPlayer.getScore()>21){
                won = false;
            }
            else{
                while(dealer.makeMove()){
                    dealer.getDealerHand().add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                }

                if(dealer.getScore()>21){
                    won = true;
                }
                else{
                    if(randomPlayer.getScore()>dealer.getScore()){
                        won = true;
                    }
                    else if(dealer.getScore()>randomPlayer.getScore()){
                        won = false;
                    }
                    else{
                        won = false;
                    }
                }
            }
        }

    /**
     * returns the value of won boolean
     * @return - true or false
     */
    public static boolean isWon() {
        return won;
    }

}


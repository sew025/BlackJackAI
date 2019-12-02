/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 11/27/19
 * Time: 6:56 PM
 *
 * Project: csci205finalproject
 * Package: Blackjack
 * Class: Money
 *
 * Description:
 *
 * ****************************************
 */
package Blackjack;

/**
 * Class to make a money amount for the player to have, makes the game more functional to allow the user to play with money
 */
public class Money {
    /**
     * the total amount of money being played with
     */
    private double amount;

    /**
     * the constructor setting the money amount
     * @author Jack Otto
     */
    public Money() {
        this.amount = 100.00;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * remove a value of money from the total
     * @param number - the amount to decrease
     * @author Jack Otto
     */
    public void removeFunds(double number){
        setAmount(getAmount()-number);
    }

    /**
     * add a value of money into the total
     * @param number - the amount of money to increase
     * @author Jack Otto
     */
    public void addFunds(double number){
        setAmount(getAmount()+number);
    }

    /**
     * show the amount of money the user has
     * @return  a string showing the total with a dollar amount
     * @author Jack Otto
     */
    @Override
    public String toString() {
        return "Total: $" + getAmount();
    }
}
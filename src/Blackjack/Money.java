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

public class Money {
    private double amount;

    public Money() {
        this.amount = 100.00;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void removeFunds(double number){
        setAmount(getAmount()-number);
    }

    public void addFunds(double number){
        setAmount(getAmount()+number);
    }

    @Override
    public String toString() {
        return "Total: $" + getAmount();
    }
}
/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Matt McGauley
 * Section: 11am
 * Date: 11/24/19
 * Time: 20:00
 *
 * Project: csci205FinalProject
 * Package: DeckOfCards
 * Class: GetCard
 *
 * Description:
 *
 * ****************************************
 */
package DeckOfCards;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.Random;

/**
 * When a card is drawn in the game, get the necessary image, put it on a shape,
 * and then return the shape so that it can be displayed on the scene.
 */
public class GetCard {
    /**
     * Creates a rectangle object with the picture of your card placed on the fill.
     * Chooses the suit for the card at random. Uses the Card Enum (in Blackjack)
     * to determine which card needs to be displayed.
     * @param   cardValue   The card that was drawn and needs to be displayed
     * @return  newCard     A rectangle with a picture of the card on it
     */
    public static Rectangle getAppropriateCard(Blackjack.Cards cardValue) {
        Rectangle newCard = createRectangle();
        switch (cardValue) {
            case ACE:
                Image aceFace = getFace("Aces");
                newCard.setFill(new ImagePattern(aceFace));
                break;
            case TWO:
                Image twoFace = getFace("Twos");
                newCard.setFill(new ImagePattern(twoFace));
                break;
            case THREE:
                Image threeFace = getFace("Threes");
                newCard.setFill(new ImagePattern(threeFace));
                break;
            case FOUR:
                Image fourFace = getFace("Fours");
                newCard.setFill(new ImagePattern(fourFace));
                break;
            case FIVE:
                Image fiveFace = getFace("Fives");
                newCard.setFill(new ImagePattern(fiveFace));
                break;
            case SIX:
                Image sixFace = getFace("Sixes");
                newCard.setFill(new ImagePattern(sixFace));
                break;
            case SEVEN:
                Image sevenFace = getFace("Sevens");
                newCard.setFill(new ImagePattern(sevenFace));
                break;
            case EIGHT:
                Image eightFace = getFace("Eights");
                newCard.setFill(new ImagePattern(eightFace));
                break;
            case NINE:
                Image nineFace = getFace("Nines");
                newCard.setFill(new ImagePattern(nineFace));
                break;
            case TEN:
                Image tenFace = getFace("Tens");
                newCard.setFill(new ImagePattern(tenFace));
                break;
            case JACK:
                Image jackFace = getFace("Jacks");
                newCard.setFill(new ImagePattern(jackFace));
                break;
            case QUEEN:
                Image queenFace = getFace("Queens");
                newCard.setFill(new ImagePattern(queenFace));
                break;
            case KING:
                Image kingFace = getFace("Kings");
                newCard.setFill(new ImagePattern(kingFace));
                break;
        }
        return newCard;
    }

    /**
     * Create the rectangle object that we are going to put the face of the card
     * on
     * @return  newCard The blank card
     */
    public static Rectangle createRectangle() {
        Rectangle newCard = new Rectangle(72, 96);
        newCard.setStroke(Color.RED);
        newCard.setStrokeWidth(5);
        return newCard;
    }

    /**
     * Gets the appropriate card image. Chooses from one of the four possible suits
     * at random, by random choosing an image from the directory that has that card's
     * stock images.
     * @param cardType      The card's value (i.e. one, ace, king...)
     * @return cardPicture  The picture of the card to be put on a rectangle
     */
    public static Image getFace(String cardType) {
        File cardDirectory = new File("src/DeckOfCards/" + cardType);
        File[] cardFiles = cardDirectory.listFiles();
        Random randomSuit = new Random();
        File chosenSuit = cardFiles[randomSuit.nextInt(cardFiles.length)];
        final Image cardImage = new Image(chosenSuit.toURI().toString());
        return cardImage;
    }

    /**
     * Creates a rectangle with a face-down card on it. This will be used for the
     * images of the deck of cards and the dealer's hand.
     * @return  newCard The face-down card on a rectangle
     */
    public static Rectangle createFaceDownCard() {
        Rectangle newCard = createRectangle();
        File cardBack = new File("src/DeckOfCards/CardBack/CardBack.png");
        final Image cardPicture = new Image(cardBack.toURI().toString());
        newCard.setFill(new ImagePattern(cardPicture));
        return newCard;
    }
}
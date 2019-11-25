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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.Random;

/**
 * When a card is drawn in the game, get the necessary image, put it on a shape,
 * and then return the shape so that it can be displayed on the scene.
 */
public class GetCard {
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

    public static Rectangle createRectangle() {
        Rectangle newCard = new Rectangle(72, 96);
        return newCard;
    }

    public static Image getFace(String cardType) {
        File cardDirectory = new File("src/DeckOfCards/" + cardType);
        File[] cardFiles = cardDirectory.listFiles();
        Random randomSuit = new Random();
        File chosenSuit = cardFiles[randomSuit.nextInt(cardFiles.length)];
        final Image cardPicture = new Image(chosenSuit.toURI().toString());
        return cardPicture;
    }

    public static Rectangle createFaceDownCard() {
        Rectangle newCard = createRectangle();
        File cardBack = new File("src/DeckOfCards/CardBack/CardBack.png");
        final Image cardPicture = new Image(cardBack.toURI().toString());
        newCard.setFill(new ImagePattern(cardPicture));
        return newCard;
    }
}
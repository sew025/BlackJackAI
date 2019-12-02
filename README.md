# CSCI205 — Software Engineering and Design
Bucknell University
Lewisburg, PA

## Course Info
Instructor: Dr. Brian King
Semester: Fall 2019
Section: 11am

## Student Info
Beatrice Casey,
Matt McGauley,
Jack Otto,
Samantha Wurm

## Overview
This repository contains our work for the final project

## Resources
The following resources were used to develop this project:

ENTER RESOURCES HERE

##Project Explanation
For our final project, we have made the casino game, Blackjack. Within our project we have created
a single player consul version of the game. This allows a player to play the game quickly without having to open a GUI.
The consul version is a simplified version of the game that does not allow for any betting, and only focuses on the 
game. We have also created a GUI for Blackjack, the GUI allows the user to play a full version of the game
of Blackjack. The GUI includes the use of a real deck of cards with images that the player can see, along with
the ability to play with fake money to show the user how they are doing while playing the game. The game begins
every time with $100 and from there the amount depends on how the user plays. Lastly within our project,
we have taught an AI how to play the game of Blackjack and then tracked its success rate as it plays a 
specified number of games. In order to show how the AI compares to another type of player, we have also encoded a random
player, that makes all of its decisions via a random number generator to determine whether to hit or stand.
And on another graph we track the success rate of the random solver in order to compare its results to the AI.
In the end when we compare the two graphs, it can easily be seen that the AI outperforms the random player by a wide 
margin, usually somewhere between 20-25% better.

##Third Party Libraries
JavaFX - version: javafx-sdk-13.0.1

JUnit Testing - version: org.junit.jupiter:junit-jupiter:5.5.2

##Project Build and Run Instructions for the Jar File

ENTER THE INSTRUCTIONS HERE ONCE WE HAVE THE JAR FILE 

##Class Descriptions
###Blackjack Package
This package contains the code needed to create a consul version of the game blackjack.
####Cards
Creates an enumeration that holds all of the cards titles and the value of each individual card.
####Dealer
Dealer class which is designed to simulate the actions of a dealer for the game blackjack.
####Deck
Creates a deck of cards in numerical order, that can later be shuffled for use in blackjack.
####Money
Class to make a money amount for the player to have, makes the game more functional to allow the user to play with money.
####Player
The player class, allows the user to determine what to do on their turn in blackjack.
####PlayGame
The running program to create a single consul version game of blackjack, contains the main function
to run the game in one spot.
####RandomPlayer
Makes a random type of user than makes all of its decisions on whether to hit or stand based on a random number generator.
####RandomPlayGame
Class that plays our blackjack function for the user buts makes ever decision randomly between hit or stand.
####RandomTrackSuccess
Track the success of the random player when it is playing the game.

###DeckOfCards Package
This package contains the images to all the pictures needed create every card so that the game 
is being played with real images of cards.
####GetCard
When a card is drawn in the game, get the necessary image, put it on a shape, 
and then return the shape so that it can be displayed on the scene.

###LandingPageGUI Package
This package contains all three MVC's for the three different scenes in our project.

The LandingPage is the opening scene of the game and allows the user to pick which scene it should open up next.

The AIGraphics is the scene that shows the graphing of both the smart ai and the random ai.

The SinglePlayer is the scene that allows the user to play games of blackjack against a dealer.
####AIGraphicsView
The view of the ai page.
####AIGraphicsController
The controller for the ai page, makes the functionality for the page.
####AIGraphicsModel
The model for the ai page.
####LandingPageController
The controller for the starting page of the gui.
####LandingPageMain
The class to run the actual game, including all three scene roots.
####LandingPageModel
The model for the opening scene.
####LandingPageView
Creates the landing page. It will have a cool background image and it will have
some buttons for the user to choose whether they want to play against a computer or
have the AI play for them.
####SinglePlayerController
Controlling portion of the GUI, this is the part that reacts to what happens when the player hits controls on the screen.
####SinglePlayerModel
This is the functional part of the GUI, in the model we will be doing everything that requires the game to run and perform the game of blackjack.
####SinglePlayerView
This is the part of the GUI that shows what is going on, we will show how the game progresses and how the game begins.

###NeuralNet Package
This package contains the classes and functions to build a neural net that will play the game of blackjack.
####Layer
Creates layers of neurons. If the list of neurons (param children) is empty, then it adds new neurons to the
list/layer. If the list of neurons (param children) is not empty, then it sets the list of neurons to that
list.
####Network
Builds the network with the layers provided. If there are no layers provided (eg param is null), then it
creates a new random layer. Otherwise, it stores the layers param in a list.
####NeuralNetSolver
Main class for the neural net, this builds the actual net that is used to play the game.
####Neuron
Creates the individual neurons and initially gives them random weights.

###NeuralNetPlay Package
This package contains the code to attach the neural net to the game of blackjack and have the
neural net make decisions that are based on what happens in the game of blackjack.
####NNBlackJack
This class builds the neural net for blackjack. And then runs the game. 
First creates 100 random networks. for each network, it simulates the game 100 times, then sorts the
networks based on their success then removes the 50 worst ones. It then creates 50 new networks and resets the score
It does this as many times as the user wants to simulate. It plays the game again with the new networks, sorts them
and then finds the trained win %.
####NNPlayGame
Sets up the game with the neural network. 
Sets up dealer and player. The network decides to hit or stand once the player and dealer both stand, it checks
who won or lost. This data is then added to the network for its future decisions.

## Honor Code for CSCI 205
All of my work in CSCI 205 is completed in Java. It represents my own work, and nobody else. I am committed to upholding the integrity of learning for myself, and for everyone around me. I understand that when I cheat, it misrepresents what I've actually learned. When I cheat, it takes credit for the work that other people have completed. It misrepresents what I actually know to prospective employers. I acknowledge that cheating will have negative consequences on not only my own learning, but it also minimizes the value of the honest work of others who took the same course.
**Therefore, I will not cheat.**
Work in this course can present complex, challenging problems at times. I am encouraged to research solutions and hold discussions with my classmates. However, all work that culminated from ideas I obtained elsewhere is clearly cited in my code. URLs of web sites that gave me ideas are acceptable citations, but copying code from those sites is strictly forbidden. Conversations with other classmates are acceptable, and even encouraged when presented with challenging problems. However, code exchange is also strictly forbidden. Some labs are designed to be collaborative with another classmate, and are clearly indicated in the instructions for the lab. In these cases, those people on my team are clearly indicated in every source file, but each member of the team commits the collaborative work in their labs. Reiterating, all code I have written is my own, and only my own. I understand that all examples of plagiarism of any kind will be sent to the Board of Review, risking my failure of the course, a permanent mark on my Bucknell record, and possible expulsion from the university.

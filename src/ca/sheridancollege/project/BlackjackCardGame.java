package ca.sheridancollege.project;

/**
 * @author Devanshi Sharma, Sukhpreet Ghuman, Khushbu Khushbu, Muskan Muskan and Tejas Chahal
 * @date 21 June 2023
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackCardGame extends Game {

    private GroupOfCards deck;
    private ArrayList<Card> dealerHand;
    private ArrayList<Card> playerHand;

    public BlackjackCardGame() {
        super("Blackjack");
    }

    
    @Override
    public void play() {
        initializeGame();

        // Deal initial cards
        dealInitialCards();

        // Play player's turn
        playPlayerTurn();

        // Play dealer's turn
        playDealerTurn();

        // Declare the winner
        declareWinner();
    }

    private void initializeGame() {
        deck = new GroupOfCards();
        dealerHand = new ArrayList<>();
        playerHand = new ArrayList<>();
        deck.shuffle();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            dealerHand.add(deck.dealCard());
            playerHand.add(deck.dealCard());
        }
    }

    private void playPlayerTurn() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            displayHands();

            System.out.print("Do you want to hit (H) or stand (S)? ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("H")) {
                playerHand.add(deck.dealCard());
            }

        } while (choice.equalsIgnoreCase("H") && calculateHandValue(playerHand) <= 21);
    }

    private void playDealerTurn() {
        while (calculateHandValue(dealerHand) < 17) {
            dealerHand.add(deck.dealCard());
        }
    }

    private void displayHands() {
        System.out.println("Dealer's hand: ");
        for (int i = 0; i < dealerHand.size(); i++) {
            if (i == 0) {
                System.out.println("Hidden Card");
            } else {
                System.out.println(dealerHand.get(i));
            }
        }

        System.out.println("Player's hand: ");
        for (Card card : playerHand) {
            System.out.println(card);
        }
    }

    private int calculateHandValue(ArrayList<Card> hand) {
        int value = 0;
        int numAces = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 11) {
                numAces++;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    
    @Override
    public void declareWinner() {
        int playerValue = calculateHandValue(playerHand);
        int dealerValue = calculateHandValue(dealerHand);

        System.out.println("Dealer's hand: ");
        for (Card card : dealerHand) {
            System.out.println(card);
        }

        System.out.println("Player's hand: ");
        for (Card card : playerHand) {
            System.out.println(card);
        }

        if (playerValue > 21) {
            System.out.println("Player busts! Dealer wins.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts! Player wins.");
        } else if (playerValue == dealerValue) {
            System.out.println("It's a tie!");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
    }
}

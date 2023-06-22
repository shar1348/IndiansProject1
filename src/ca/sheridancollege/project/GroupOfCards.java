package ca.sheridancollege.project;

/**
 * @author Devanshi Sharma, Sukhpreet Ghuman, Khushbu Khushbu, Muskan Muskan and Tejas Chahal
 * @date 21 June 2023
 */

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        return cards.remove(0);
    }
}


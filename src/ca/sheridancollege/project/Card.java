package ca.sheridancollege.project;

/**
 * @author Devanshi Sharma, Sukhpreet Ghuman, Khushbu Khushbu, Muskan Muskan and Tejas Chahal
 * @date 21 June 2023
 */

public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public int getValue() {
        if (rank.equals("Ace")) {
            return 11;
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }
}


package org.Blackjack;

public class Card {
    public enum Suit { Hearts, Diamonds, Spades, Clubs }
    private int rank; // 1 (Ace) - 13 (King)
    private Suit suit;

    public Card(int rank, Suit suit) {
        this.setRank(rank);
        this.setSuit(suit);
    }

    public int getRank() { return this.rank; }
    public Suit getSuit() { return this.suit; }

    private void setRank(int rank) {
        if (!(1 <= rank &&  rank <= 13)) { throw new IllegalArgumentException("Card rank must be 1-13."); }
        this.rank = rank;
    }
    private void setSuit(Suit suit) { this.suit = suit; }
    public String toString() {
        String rank = "";
        switch (this.rank) {
            case 1 -> rank = "Ace";
            case 11 -> rank = "Jack";
            case 12 -> rank = "Queen";
            case 13 -> rank = "King";
            default -> rank += this.rank;
        }
        return rank + " of " + this.suit;
    }
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (that == null) { return false; }
        if (!(that instanceof Card thatCard)) { return false; }
        return thatCard.rank == this.rank && thatCard.suit == this.suit;
    }
    public Card clone() { return new Card(this.rank, this.suit); }
}

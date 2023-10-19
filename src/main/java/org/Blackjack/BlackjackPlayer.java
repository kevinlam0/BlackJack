package org.Blackjack;

public abstract class BlackjackPlayer {
    private int chips = 1000;
    protected Card[] cards = new Card[22];
    protected int numCards = 0;
    public BlackjackDealer dealer;
    public abstract int getBet();
    public abstract Move getMove();
    public abstract void handOver(Card[] dealerHand);
    public int getChips() {
        return chips;
    }
    /* reduce number of chips when player loses a hand */
    protected void takeChips(int amount) {
        this.chips -= amount;
    }

    /* add to the number of chips when player loses a hand */
    protected void giveChips(int amount) {
        this.chips += amount;
    }

    /* calculate the score of the player's hand according to blackjack rules */
    public int handScore() {
        int tot = 0;
        int numAces = 0;
        Card c;
        for (int i = 0; i < numCards; ++i) {
            c = cards[i];
            int rank = c.getRank();
            if (rank > 10)
                rank = 10;
            if (rank == 1) {
                numAces++;
                rank = 11;
            }
            tot += rank;
        }
        while (tot > 21 && numAces > 0) {
            tot -= 10;
            numAces--;
        }
        return tot;
    }

    /* associate this player with a given dealer */
    public void setDealer(BlackjackDealer dealer) {
        this.dealer = dealer;
        dealer.setPlayerChips(chips); // tell dealer how many chips player starts with
    }
}

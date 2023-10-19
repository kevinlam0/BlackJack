package org.Blackjack;

public class MyBlackjackPlayer extends BlackjackPlayer{
    private int cardCounting = 0;

    // Reads the card to know to add, subtract, or do nothing to cardCounting
    @Override
    public Move getMove() {
        Card c;
        for(int i=0; i<numCards; ++i){
            c = cards[i];
            int rank = c.getRank();
            if (2 <= rank && rank <= 6 ){
                cardCounting ++;
            }
            else if (1 == rank || rank>=10) {
                cardCounting --;

            }

        }
        /* Hits until we get a score of 16 or better
         * Calls getBet to determine how much to bet after seeing the cardCounting value */
        if (this.handScore()<= 16){
            getBet();
            return Move.HIT;
        }
        return Move.STAY;
    }
    // Chooses different amounts to bet to minimalize losses or maximize gain
    public int getBet() {
        int amountToBet = 0;
        if (cardCounting>=2){
            amountToBet = 2;
        }
        else {
            amountToBet = 10;
        }
        return amountToBet; //always bet 10
    }

    @Override
    public void handOver(Card[] dealerHand) {
        /**
         * If you care about looking at the dealer's hand once
         * the hand is over, then you can do it here. This method
         * is called automatically after every hand and a copy of the dealer's
         * final hand is given to you to process. The dealer's hand will be
         * found in the array of Cards that you pass when the method returns.
         */

    }
}

package org.Blackjack;

public class DeckShoe {
    private Deck[] decks;
    private int counter = 0;

    public DeckShoe(int numDecks) {
        decks = new Deck[numDecks];
        for (int i=0; i<decks.length; i++){
            decks[i] = new Deck();
        }
    }
    public Card dealTopCard() {
        if(decks[counter].cardsLeft() <= 0){
            counter ++;
        }
        if(counter>= decks.length){
            restoreDecks();
            counter = 0;
        }
        Deck topDeck = this.decks[counter];
        Card topCard = topDeck.dealTopCard();
        return topCard;
    }
    protected void restoreDecks() {
        for(int i=0; i<decks.length;i++){
            decks[i].shuffle();
        }
    }
    public int cardsLeft() {
        int numCardsLeft = 0;
        for(int i=0; i<decks.length; i++){
            numCardsLeft += decks[i].cardsLeft();
        }
        return numCardsLeft;
    }
}

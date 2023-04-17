package aufgabe04;

public abstract class Card {
    Suit suit;
    Rank rank;
    public Card(Suit s, Rank r){
        this.rank = r;
        this.suit = s;

    }

    public Card(){
    }

    public enum Rank {
        SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE
    }

    public enum Suit {DIAMONDS, HEARTS, SPADES, CLUBS}

    public String toString(){


        return this.suit + " : " + this.rank;
    }


}

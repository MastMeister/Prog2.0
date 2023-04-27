package aufgabe04;

public abstract class Card {
    Suit suit;
    Rank rank;
    protected Card(Suit s, Rank r){
        this.rank = r;
        this.suit = s;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return rank == card.rank;
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
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

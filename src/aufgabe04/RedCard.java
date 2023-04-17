package aufgabe04;

public class RedCard extends Card{

    public RedCard(Suit s, Rank r) {
        super(s,r);
        if (s == Suit.CLUBS || s == Suit.SPADES)
            throw new RuntimeException("Falsche Farbe");
    }
    public RedCard(){
        this.rank = Rank.values()[(int) (Math.random() * Rank.values().length)];
        this.suit = Suit.values()[(int) (Math.random()*2) ];
    }
}

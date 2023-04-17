package aufgabe04;

public class BlackCard extends Card{

    public BlackCard(Suit s,Rank r){
        super(s,r);
        if (s == Suit.HEARTS || s == Suit.DIAMONDS)
            throw new RuntimeException("Falsche Farbe");
    }
    public BlackCard(){
        this.rank = Rank.values()[(int) (Math.random() * Rank.values().length)];
        this.suit = Suit.values()[(int) ((Math.random()*2)+2)];
    }

}

package cardsWithPower;

public class Card {
    private int power;

    public Card(String rank, String suit) {
        this.power = Ranks.valueOf(rank).getPower()
                + Suits.valueOf(suit).getPower();
    }

    public int getPower() {
        return power;
    }
}

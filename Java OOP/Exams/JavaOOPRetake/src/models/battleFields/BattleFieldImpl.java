package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }
        if (attackPlayer instanceof Beginner) {
            attackPlayer.setHealth(attackPlayer.getHealth() + 40);
            for (Card card : attackPlayer.getCardRepository().getCards()) {
                card.setDamagePoints(card.getDamagePoints() + 30);
            }
        }
        for (Card card : attackPlayer.getCardRepository().getCards()) {
            attackPlayer.setHealth(attackPlayer.getHealth() + card.getHealthPoints());
        }

        if (enemyPlayer instanceof Beginner) {
            enemyPlayer.setHealth(enemyPlayer.getHealth() + 40);
            for (Card card : enemyPlayer.getCardRepository().getCards()) {
                card.setDamagePoints(card.getDamagePoints() + 30);
            }
        }
        for (Card card : enemyPlayer.getCardRepository().getCards()) {
            enemyPlayer.setHealth(enemyPlayer.getHealth() + card.getHealthPoints());
        }
        while (true) {
            int attackerDeck = attackPlayer.getCardRepository().getCards()
                    .stream().mapToInt(Card::getDamagePoints).sum();
            int enemyDeck = enemyPlayer.getCardRepository().getCards()
                    .stream().mapToInt(Card::getDamagePoints).sum();

                enemyPlayer.takeDamage(attackerDeck);

            if (enemyPlayer.isDead()) {
                return;
            }
            attackPlayer.takeDamage(enemyDeck);

            if (attackPlayer.isDead()) {
                return;
            }
        }

    }
}

package models.players;

import models.cards.interfaces.Card;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

import static common.ConstantMessages.DEFAULT_REPORT_SEPARATOR;
import static common.ConstantMessages.PLAYER_REPORT_INFO;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.setUsername(username);
        this.setHealth(health);
        this.cardRepository = cardRepository;
        isDead = false;
    }

    @Override
    public CardRepository getCardRepository() {
        return cardRepository;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        this.username = username;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }
        health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        this.health -= damagePoints;
        if (health < 0) {
            health = 0;
            isDead = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format(PLAYER_REPORT_INFO,
                username, health, cardRepository.getCount())).append(System.lineSeparator());
        for (Card card : cardRepository.getCards()) {
            result.append(card.toString()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}

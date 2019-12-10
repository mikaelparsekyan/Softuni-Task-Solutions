package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import static common.ConstantMessages.*;


public class ManagerControllerImpl implements ManagerController {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        playerRepository = new PlayerRepositoryImpl();
        cardRepository = new CardRepositoryImpl();
        battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player playerToAdd = null;
        switch (type) {
            case "Beginner":
                playerToAdd = new Beginner(new CardRepositoryImpl(), username);
                break;

            case "Advanced":
                playerToAdd = new Advanced(new CardRepositoryImpl(), username);
                break;
        }
        if (playerToAdd != null) {
            if (playerRepository.find(username) == null) {
                playerRepository.add(playerToAdd);
            } else {
                throw new IllegalArgumentException(String.format("Player %s already exists!",
                        username));
            }
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card cardToAdd = null;

        switch (type) {
            case "Trap":
                cardToAdd = new TrapCard(name);
                break;

            case "Magic":
                cardToAdd = new MagicCard(name);
                break;
        }
        if (cardToAdd != null) {
            if (cardRepository.find(name) == null) {
                cardRepository.add(cardToAdd);
            } else {
                throw new IllegalArgumentException(String.format("Card %s already exists!", name));
            }
        }
        return String.format(SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = playerRepository.find(username);
        Card card = cardRepository.find(cardName);


            player.getCardRepository().add(card);

        return String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = playerRepository.find(attackUser);
        Player enemy = playerRepository.find(enemyUser);

        battlefield.fight(attacker, enemy);


        return String.format(FIGHT_INFO,
                attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {
        StringBuilder res = new StringBuilder();
        for (Player player : playerRepository.getPlayers()) {
            res.append(player.toString()).append(System.lineSeparator());
            res.append(DEFAULT_REPORT_SEPARATOR).append(System.lineSeparator());
        }
        return res.toString().trim();
    }
}

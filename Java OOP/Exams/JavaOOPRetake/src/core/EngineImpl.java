package core;

import core.interfaces.Engine;
import core.interfaces.ManagerController;

import java.util.Scanner;

public class EngineImpl implements Engine {
    private ManagerController controller;
    private Scanner scanner;

    public EngineImpl(ManagerController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    private String[] readLine() {
        return scanner.nextLine().split("\\s+");
    }

    @Override
    public void run() {
        String[] input = readLine();
        String result = "";
        while (!input[0].equals(Command.Exit.name())) {
            try {
                switch (Command.valueOf(input[0])) {
                    case AddPlayer:
                        result = controller.addPlayer(input[1], input[2]);
                        break;
                    case AddCard:
                        result = controller.addCard(input[1], input[2]);
                        break;
                    case AddPlayerCard:
                        result = controller.addPlayerCard(input[1], input[2]);
                        break;
                    case Fight:
                        result = controller.fight(input[1], input[2]);
                        break;
                    case Report:
                        result = controller.report();
                        break;
                }
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            input = readLine();
        }
    }


}

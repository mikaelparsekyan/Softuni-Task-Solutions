package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.io.interfaces.InputReader;
import motocrossWorldChampionship.io.interfaces.OutputWriter;

import java.util.Scanner;

public class EngineImpl implements Engine, InputReader, OutputWriter {
    private Scanner scanner;
    private ChampionshipController controller;

    public EngineImpl(ChampionshipController controller) {
        this.scanner = new Scanner(System.in);
        this.controller = controller;
    }

    @Override
    public void run() {
        switchCommand();
    }

    public String readLine() {
        return scanner.nextLine();
    }

    private void switchCommand() {
        String[] input = readLine().split("\\s+");
        String result = null;
        while (!input[0].equals(Commands.End.name())) {
            try {
                switch (Commands.valueOf(input[0])) {
                    case CreateRider:
                        result = controller.createRider(input[1]);
                        break;

                    case CreateMotorcycle:
                        result = controller.createMotorcycle(input[1], input[2], Integer.parseInt(input[3]));
                        break;

                    case AddMotorcycleToRider:
                        result = controller.addMotorcycleToRider(input[1], input[2]);
                        break;

                    case AddRiderToRace:
                        result = controller.addRiderToRace(input[1], input[2]);
                        break;

                    case CreateRace:
                        result = controller.createRace(input[1], Integer.parseInt(input[2]));
                        break;

                    case StartRace:
                        result = controller.startRace(input[1]);
                        break;
                }
                writeLine(result);
            } catch (Exception e) {
                writeLine(e.getMessage());
            }
            input = readLine().split("\\s+");
        }
    }

    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}

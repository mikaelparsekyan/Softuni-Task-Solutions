package military_elite;

import military_elite.classes.*;
import military_elite.enums.Corps;
import military_elite.enums.State;
import military_elite.interfaces.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Soldier> soldiers = new LinkedList<>();
        Map<Integer, PrivateImpl> privateMap = new LinkedHashMap<>();
        while (!"End".equals(input)) {
            String[] elements = input.split("\\s+");

            switch (elements[0]) {
                case "Private":
                    PrivateImpl p = new PrivateImpl(Integer.parseInt(elements[1]),
                            elements[2],
                            elements[3],
                            Double.parseDouble(elements[4]));
                    privateMap.put(Integer.parseInt(elements[1]), p);
                    soldiers.add(p);
                    break;

                case "LeutenantGeneral":
                    LieutenantGeneral lieutenant = new LieutenantGeneralImpl(
                            Integer.parseInt(elements[1]),
                            elements[2],
                            elements[3],
                            Double.parseDouble(elements[4]));

                    for (int i = 5; i < elements.length; i++) {
                        int privateId = Integer.parseInt(elements[i]);
                        if (privateMap.containsKey(privateId)) {
                            lieutenant.addPrivate(privateMap.get(privateId));
                        }
                    }
                    soldiers.add(lieutenant);
                    break;

                case "Engineer":
                    if (elements[5].equals("Airforces") || elements[5].equals("Marines")) {
                        Engineer engineer = new EngineerImpl(Integer.parseInt(elements[1]),
                                elements[2],
                                elements[3],
                                Double.parseDouble(elements[4]),
                                Corps.valueOf(elements[5]));

                        for (int i = 6; i < elements.length; i += 2) {
                            String partName = elements[i];
                            int hours = Integer.parseInt(elements[i + 1]);
                            engineer.addRepair(new Repair(partName, hours));
                        }
                        soldiers.add(engineer);
                    }
                    break;

                case "Commando":
                    if (elements[5].equals("Airforces") || elements[5].equals("Marines")) {
                        Commando commando = new CommandoImpl(Integer.parseInt(elements[1]),
                                elements[2],
                                elements[3],
                                Double.parseDouble(elements[4]),
                                Corps.valueOf(elements[5]));

                        for (int i = 6; i < elements.length; i += 2) {
                            String missionCodeName = elements[i];
                            if (State.finished.name().equals(elements[i + 1]) ||
                                    State.inProgress.name().equals(elements[i + 1])) {
                                State missionState = State.valueOf(elements[i + 1]);
                                commando.addMission(new Mission(missionCodeName, missionState));
                            }
                        }
                        soldiers.add(commando);
                    }
                    break;

                case "Spy":
                    Spy spy = new SpyImpl(Integer.parseInt(elements[1]),
                            elements[2],
                            elements[3],
                            elements[4]);
                    soldiers.add(spy);
                    break;
            }

            input = scanner.nextLine();
        }
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }

    }
}

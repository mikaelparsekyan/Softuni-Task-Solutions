package military_elite.classes;

import military_elite.Mission;
import military_elite.enums.Corps;
import military_elite.interfaces.Commando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;
    private Corps corps;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
        this.corps = corps;
    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(System.lineSeparator()).append(String.format("Corps: %s", this.getCorps()))
                .append(System.lineSeparator()).append("Missions:");
        for (Mission mission : this.missions) {
            if(!mission.getState().name().equals("finished")) {
                result.append(System.lineSeparator()).append("  ").append(mission.toString());
            }

        }
        return result.toString();
    }
}

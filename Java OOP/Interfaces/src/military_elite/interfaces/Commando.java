package military_elite.interfaces;

import military_elite.Mission;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier{
    void addMission(Mission mission);

    Collection<Mission> getMissions();
}

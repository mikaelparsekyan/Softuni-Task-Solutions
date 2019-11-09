package military_elite.interfaces;

import military_elite.Repair;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier{
    void addRepair(Repair repair);

    Collection<Repair> getRepairs();
}

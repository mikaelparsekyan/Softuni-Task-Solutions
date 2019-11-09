package military_elite.classes;

import military_elite.Repair;
import military_elite.enums.Corps;
import military_elite.interfaces.Engineer;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;
    private Corps corps;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
        this.corps = corps;
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(System.lineSeparator()).append(String.format("Corps: %s", this.getCorps()))
                .append(System.lineSeparator()).append("Repairs:");
        for (Repair repair : this.getRepairs()) {
            result.append(System.lineSeparator()).append("  ").append(repair.toString());
        }
        return result.toString();
    }
}

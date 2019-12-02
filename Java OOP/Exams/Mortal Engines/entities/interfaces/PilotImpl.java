package entities.interfaces;

import common.OutputMessages;
import core.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private Collection<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        machines = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name, OutputMessages.PILOT_NAME_EMPTY);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addMachine(Machine machine) {
        machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return new ArrayList<>(machines);
    }

    @Override
    public String report() {
        return null;
    }
}

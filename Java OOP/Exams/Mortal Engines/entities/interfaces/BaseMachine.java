package entities.interfaces;

import common.OutputMessages;
import core.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private Collection<String> targets;

    BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.setHealthPoints(healthPoints);
        targets = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        Validator.validateName(name, OutputMessages.MACHINE_NAME_EMPTY);
        this.name = name;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public void setPilot(Pilot pilot) {
        Validator.validatePilot(pilot, OutputMessages.PILOT_NULL);
        this.pilot = pilot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Pilot getPilot() {
        return pilot;
    }

    @Override
    public double getHealthPoints() {
        return healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return new ArrayList<>(targets);
    }

    @Override
    public void attack(String target) {
        Validator.validateName(target, OutputMessages.ATTACK_TARGET_EMPTY);
        targets.add(target);
    }
}

package entities.interfaces;

public class TankImpl extends BaseMachine implements Tank {
    private static final int INITIAL_HEALTH_POINTS = 100;

    private boolean defenseMode = true;
    private static final double attackPointsModifier = 40.0;
    private static final double defensePointsModifier = 30.0;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
    }


    @Override
    public boolean getDefenseMode() {
        return defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        defenseMode = !defenseMode;
    }
}

package entities.interfaces;


public class FighterImpl extends BaseMachine implements Fighter {
    private static final int INITIAL_HEALTH_POINTS = 200;

    private boolean aggressiveMode = true;
    private static final double attackPointsModifier = 50.0;
    private static final double defensePointsModifier = 25.0;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
    }

    @Override
    public boolean getAggressiveMode() {
        return aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        aggressiveMode = !aggressiveMode;
    }
}

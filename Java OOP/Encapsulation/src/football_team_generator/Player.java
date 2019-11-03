package football_team_generator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    private static final String STAT_ERROR_MESSAGE = "%s should be between 0 and 100.";

    public Player(String name, int endurance,
                  int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (!checkIfStatsValid(endurance)) {
            throwStatError("Endurance");
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (!checkIfStatsValid(sprint)) {
            throwStatError("Spirit");
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (!checkIfStatsValid(dribble)) {
            throwStatError("Dribble");
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (!checkIfStatsValid(passing)) {
            throwStatError("Passing");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (!checkIfStatsValid(shooting)) {
            throwStatError("Shooting");
        }
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    private boolean checkIfStatsValid(int stat) {
        if (stat >= 0 && stat <= 100) {
            return true;
        }
        return false;
    }

    private void throwStatError(String statName) {
        throw new IllegalArgumentException(
                String.format(STAT_ERROR_MESSAGE, statName));

    }

    public double overallSkillLevel() {
        return (this.dribble + this.endurance +
                this.passing + this.shooting + this.sprint) / 5.00;
    }
}

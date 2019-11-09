package military_elite;

import military_elite.enums.State;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public void completeMission() {
        this.state = State.valueOf("finished");
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.codeName,this.state.name());
    }
}

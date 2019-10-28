package trafficLights;

public class TrafficLights {
    private Signal signal;

    public TrafficLights(Signal signal) {
        this.signal = signal;
    }

    public void changeLight() {
        switch (this.signal) {
            case RED:
                this.signal = Signal.GREEN;
                break;

            case GREEN:
                this.signal = Signal.YELLOW;
                break;

            case YELLOW:
                this.signal = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}

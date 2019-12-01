package clock;

public class AlarmClock {
    private Time time;

    public AlarmClock(Time time) {
        this.time = time;
    }

    public boolean ring() {
        if (time.checkIfIsMorning()) {
            return true;
        }
        return false;
    }
}

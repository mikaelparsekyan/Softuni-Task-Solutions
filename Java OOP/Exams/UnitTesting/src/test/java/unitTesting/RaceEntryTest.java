package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

public class RaceEntryTest {
    private UnitRider unitRider;
    private RaceEntry raceEntry;
    private UnitMotorcycle unitMotorcycle;
    private UnitMotorcycle unitMotorcycle2;
    private UnitMotorcycle unitMotorcycle3;

    @Before
    public void init() {
        unitMotorcycle = new UnitMotorcycle("yamaha", 100, 15);
        unitMotorcycle2 = new UnitMotorcycle("hondaaa", 100, 15);
        unitMotorcycle3 = new UnitMotorcycle("opel", 100, 115);
        unitRider = new UnitRider("kiro", unitMotorcycle);
        raceEntry = new RaceEntry();
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullRider() {
        raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingRider() {
        raceEntry.addRider(unitRider);
        raceEntry.addRider(unitRider);
    }

    @Test
    public void testIncreaseCountRiders() {
        raceEntry.addRider(unitRider);
        raceEntry.addRider(new UnitRider("Stefan", unitMotorcycle2));
        raceEntry.addRider(new UnitRider("asssSAS", unitMotorcycle3));
        assertEquals(3, raceEntry.getRiders().size());
    }

    @Test
    public void testAvgCalc() {
        raceEntry.addRider(unitRider);
        raceEntry.addRider(new UnitRider("Stefan", unitMotorcycle2));
        raceEntry.addRider(new UnitRider("Stefaasassasn", unitMotorcycle3));
        raceEntry.addRider(new UnitRider("asdddsad", unitMotorcycle3));
        assertEquals(100.0, raceEntry.calculateAverageHorsePower());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAvgCalcMinParticipates() {
        raceEntry.addRider(unitRider);
        double avg = raceEntry.calculateAverageHorsePower();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testGetRiders() {
        Collection<UnitRider> riders = raceEntry.getRiders();
        riders.add(new UnitRider("asd", new UnitMotorcycle("12", 123, 123)));
    }
    @Test()
    public void shouldReturnUnmodifiableCollection(){
        Collection<UnitRider> riders = raceEntry.getRiders();

        Assert.assertTrue(riders.getClass().getSimpleName().equals("UnmodifiableCollection"));
    }

}

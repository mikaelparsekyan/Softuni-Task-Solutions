package blueOrigin;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.*;

public class SpaceshipTests {
    private Spaceship spaceship;
    private String spaceshipName = "asd";
    private int spaceshipCapacity = 2;
    private Astronaut astronaut;

    @Before
    public void initialize() {
        spaceship = new Spaceship(spaceshipName, spaceshipCapacity);
        astronaut = new Astronaut("Gosho", 120);
    }

    @Test
    public void testCountIncrementation() {
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("asd",12322));
        assertEquals(2,spaceship.getCount());
    }

    @Test
    public void testGetName() {
        assertEquals(spaceship.getName(), spaceshipName);
    }

    @Test
    public void testGetCapacity() {
        assertEquals(spaceship.getCapacity(), spaceshipCapacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFullSpaceshipException() {
        spaceship.add(new Astronaut("asdsd", 123));
        spaceship.add(new Astronaut("as11sd", 13223));
        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEqualAstronaut() {
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("Gosho",12));
    }

    @Test
    public void testRemoveAstronaut() {
        spaceship.add(astronaut);
        assertTrue(spaceship.remove(astronaut.getName()));
    }
    @Test
    public void testRemoveInvalidAstronaut() {
        spaceship.add(astronaut);
        assertFalse(spaceship.remove("kiro"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCapacity() {
        Spaceship spaceship = new Spaceship("asdsdddsd", -123);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyName() {
        Spaceship spaceship = new Spaceship("", 123);
    }

    @Test(expected = NullPointerException.class)
    public void testNullName() {
        Spaceship spaceship = new Spaceship(null, 123);
    }
}

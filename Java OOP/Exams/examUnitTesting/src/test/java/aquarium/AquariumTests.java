package aquarium;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class AquariumTests {
    private Aquarium aquarium;
    private  Fish fish1;
    private  Fish fish2;
    private  Fish fish3;

    @Before
    public void init(){
        aquarium = new Aquarium("Aqua",2);

        fish1 = new Fish("fish1");
        fish2 = new Fish("fish2");
        fish3 = new Fish("fish3");
    }

    @Test
    public void testGetName(){
        assertEquals("Aqua",aquarium.getName());
    }
    @Test
    public void testGetCapacity(){
        assertEquals(2,aquarium.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull(){
        aquarium = new Aquarium(null,2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmpty(){
        aquarium = new Aquarium("",2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidCapacity(){
        aquarium = new Aquarium("asd",-2);
    }

    @Test
    public void testSetGetCount(){
        aquarium.add(fish1);
        assertEquals(1,aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFishBiggerThanCount(){
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeInvalidFish(){
        aquarium.remove("assdssss");

    }
    @Test(expected = IllegalArgumentException.class)
    public void sellInvalidFish(){
        aquarium.sellFish("assdssss");
    }
    @Test
    public void sellFish(){
        aquarium.add(fish1);
        aquarium.sellFish(fish1.getName());
        assertFalse(fish1.isAvailable());
    }
    @Test
    public void testReport(){
        String output = "Fish available at %s: %s";
        String expected = String.format("Fish available at %s: %s",
                aquarium.getName(),fish1.getName());

        aquarium.add(fish1);

        assertEquals(expected,String.format(output,aquarium.getName(),fish1.getName()));
    }
}


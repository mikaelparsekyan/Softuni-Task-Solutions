package rpg_tests;

import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static junit.framework.TestCase.assertTrue;

public class AxeTests {

    @Test
    public void shouldLoseDurability() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(100, 10);
        int durabilityBeforeAttack = axe.getDurabilityPoints();
        axe.attack(dummy);
        int durabilityAfterAttack = axe.getDurabilityPoints();
        assertTrue(durabilityBeforeAttack > durabilityAfterAttack);
    }
}

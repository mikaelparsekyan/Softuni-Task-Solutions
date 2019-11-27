package rpg_tests;

import org.junit.jupiter.api.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AxeTests {

    @Test
    void shouldLoseDurability() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(100, 10);
        int durabilityBeforeAttack = axe.getDurabilityPoints();
        axe.attack(dummy);
        int durabilityAfterAttack = axe.getDurabilityPoints();
        assertTrue(durabilityBeforeAttack > durabilityAfterAttack);
    }
}

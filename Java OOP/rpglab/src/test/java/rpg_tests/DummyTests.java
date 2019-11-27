package rpg_tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.jupiter.api.Assertions.*;

public class DummyTests {
    private static Axe axe;
    private static Dummy dummy;

    @BeforeAll
    static void initialize() {
        axe = new Axe(1, 2);
        dummy = new Dummy(10, 10);
    }

    @Test
    void shouldLoseHealthWhenAttacked() {
        int healthBeforeAttack = dummy.getHealth();

        this.attackDummy();

        int healthAfterAttack = dummy.getHealth();

        assertTrue(healthBeforeAttack > healthAfterAttack);
    }

    @Test
    void canGiveXPWhenIsDead() {
        assertFalse(dummy.isDead());
    }

    @Test
    void canNotGiveXPWhenIsAlive() {
        assertFalse(dummy.isDead());
    }

    @Test
    void shouldThrownExceptionWhenAttacked() {
        attackDummy();
        assertThrows(IllegalStateException.class, this::attackDummy);
    }

    private void attackDummy() {
        axe.attack(dummy);
    }
}

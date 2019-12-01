package rpg_tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class DummyTests {
    private static Axe axe;
    private static Dummy dummy;

    @Before
    public void initialize() {
        axe = new Axe(1, 2);
        dummy = new Dummy(10, 10);
    }

    @Test
    public void shouldLoseHealthWhenAttacked() {
        int healthBeforeAttack = dummy.getHealth();

        this.attackDummy();

        int healthAfterAttack = dummy.getHealth();

        assertTrue(healthBeforeAttack > healthAfterAttack);
    }

    @Test
    public void canGiveXPWhenIsDead() {
        assertFalse(dummy.isDead());
    }

    @Test
    public void canNotGiveXPWhenIsAlive() {
        assertFalse(dummy.isDead());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrownExceptionWhenAttacked() {
        attackDummy();
        attackDummy();
        attackDummy();
    }
    @Test
    public void simpleTest(){
        Mockito.mock(Axe.class);
    }
    private void attackDummy() {
        axe.attack(dummy);
    }
}

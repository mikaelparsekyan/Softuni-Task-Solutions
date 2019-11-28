package heroRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

public class HeroRepositoryTests {
    private HeroRepository repository;
    private Hero hero;
    private String heroName = "baba qga";
    private int heroLevel = 100;

    @Before
    public void initialize() {
        repository = new HeroRepository();
        hero = new Hero(heroName, heroLevel);
        repository.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenCreateNullObject() {
        repository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEqualNames() {
        repository.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenNameIsEmpty() {
        repository.remove("");
    }

    @Test
    public void testIfCountIsValid() {
        assertEquals(repository.getCount(), 1);
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        repository.create(new Hero("asd",1));
        assertEquals(repository.getHeroWithHighestLevel(), hero);
    }

    @Test
    public void testGetHero() {
        assertEquals(repository.getHero(heroName), hero);
    }


}

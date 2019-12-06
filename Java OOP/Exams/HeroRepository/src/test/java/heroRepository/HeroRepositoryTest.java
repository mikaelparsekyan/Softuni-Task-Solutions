package heroRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private HeroRepository repository;
    private Hero hero;
    private String HERO_NAME1 = "kiro";
    private int HERO_LEVEL1 = 15;
    private Item heroItem;
    private String HERO_NAME2 = "kiro";

    @Before
    public void init() {
        repository = new HeroRepository();
        heroItem = new Item(100, 100, 100);
        hero = new Hero(HERO_NAME1, HERO_LEVEL1, heroItem);
    }

    @Test
    public void shouldIncreaseSizeWhenAddNewHero() {
        int size = repository.getCount();
        repository.add(hero);
        assertEquals(size + 1, repository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenAddEqualHero() {
        repository.add(hero);
        repository.add(hero);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowErrorWhenRemoveNullHero() {
        repository.remove(null);
    }

    @Test
    public void shouldDecreaseSizeWhenAddNewHero() {
        repository.add(hero);
        repository.add(new Hero("Sd", 123, new Item(123, 12, 3)));
        repository.remove(HERO_NAME1);

        assertEquals(1, repository.getCount());
    }

    @Test
    public void shouldGetHeroWithHighestStrength() {
        Hero hero2 = new Hero("Sd", 123, new Item(9999, 12, 3));
        repository.add(hero);
        repository.add(hero2);
        assertEquals(hero2, repository.getHeroWithHighestStrength());
    }

    @Test
    public void shouldGetHeroWithHighestAgility() {
        Hero hero2 = new Hero("Sd", 123, new Item(1, 9999, 3));
        repository.add(hero);
        repository.add(hero2);
        assertEquals(hero2, repository.getHeroWithHighestAgility());
    }

    @Test
    public void shouldGetHeroWithHighestIntelligence() {
        Hero hero2 = new Hero("Sd", 123, new Item(1, 1, 9999));
        repository.add(hero);
        repository.add(hero2);
        assertEquals(hero2, repository.getHeroWithHighestIntelligence());
    }

    @Test(expected = NullPointerException.class)
    public void getNullHeroesHighestWithAgility() {
        repository.getHeroWithHighestAgility();
    }

    @Test(expected = NullPointerException.class)
    public void getNullHeroesHighestWithStrength() {
        repository.getHeroWithHighestStrength() ;
    }

    @Test(expected = NullPointerException.class)
    public void getNullHeroesHighestWithIntelligence() {
        repository.getHeroWithHighestIntelligence();
    }

}
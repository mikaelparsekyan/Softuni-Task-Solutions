package viceCity.models.guns;

public class Rifle extends BaseGun {
    protected Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        return 5;
    }
}

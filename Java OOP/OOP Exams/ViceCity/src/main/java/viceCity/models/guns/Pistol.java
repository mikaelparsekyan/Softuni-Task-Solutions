package viceCity.models.guns;

public class Pistol extends BaseGun {

    protected Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {
        return 1;
    }
}

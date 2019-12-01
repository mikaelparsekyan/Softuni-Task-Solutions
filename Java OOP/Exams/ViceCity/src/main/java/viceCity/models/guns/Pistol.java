package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int NUMBER_OF_BULLETS_WHEN_FIRING = 1;

    private int currentBullets = BULLETS_PER_BARREL;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        this.currentBullets -= NUMBER_OF_BULLETS_WHEN_FIRING;
        if (this.currentBullets == 0) {
            this.setTotalBullets(this.getTotalBullets() - BULLETS_PER_BARREL);
            this.currentBullets = BULLETS_PER_BARREL;
        }
        return NUMBER_OF_BULLETS_WHEN_FIRING;
    }
}

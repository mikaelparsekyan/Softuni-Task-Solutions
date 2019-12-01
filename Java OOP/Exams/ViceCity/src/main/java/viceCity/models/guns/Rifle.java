package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int NUMBER_OF_BULLETS_WHEN_FIRING = 5;

    private int currentBullets = BULLETS_PER_BARREL;

    public Rifle(String name) {
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

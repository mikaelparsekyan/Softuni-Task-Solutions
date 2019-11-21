package viceCity.models.guns;

import viceCity.common.ExceptionMessages;
import viceCity.core.validator.Validator;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.name = name;
        this.bulletsPerBarrel = bulletsPerBarrel;
        this.totalBullets = totalBullets;
    }

    private void setName(String name) {
        Validator.validateName(name, ExceptionMessages.NAME_NULL);
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        Validator.validateNumber(bulletsPerBarrel, ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        Validator.validateNumber(totalBullets, ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return totalBullets > 0;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

    @Override
    public int fire() {
        return 0;
    }
}

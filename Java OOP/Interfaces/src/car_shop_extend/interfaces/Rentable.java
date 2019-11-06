package car_shop_extend.interfaces;

public interface Rentable extends Car {
    int getMinRentDay();

    Double getPricePerDay();
}

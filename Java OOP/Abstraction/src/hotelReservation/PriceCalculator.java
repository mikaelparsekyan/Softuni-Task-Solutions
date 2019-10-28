package hotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private String discountType;
    private double totalPrice;

    public PriceCalculator(double pricePerDay, int days,
                           Season season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discountType = discountType;
        this.calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        double discount = getDiscount(this.discountType);

        switch (this.season) {
            case Spring:
                this.pricePerDay *= 2;
                break;
            case Summer:
                this.pricePerDay *= 4;
                break;
            case Winter:
                this.pricePerDay *= 3;
                break;
        }

        this.totalPrice = (this.pricePerDay * this.days) * discount;
    }

    private double getDiscount(String type) {
        if (type.equals("VIP")) {
            return 0.80;
        } else if (type.equals("SecondVisit")) {
            return 0.90;
        }
        return 1;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

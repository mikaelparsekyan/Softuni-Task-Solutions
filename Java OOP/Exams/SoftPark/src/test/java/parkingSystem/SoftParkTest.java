package parkingSystem;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class SoftParkTest {
    private SoftPark parking;
    private Car car;

    private static final String INVALID_SPOT = "F12";
    private static final String VALID_SPOT = "A1";
    private static final String CAR_PLATE = "XXXX";
    private static final String CAR_MAKE = "LADA";

    @Before
    public void initialize() {
        parking = new SoftPark();
        car = new Car(CAR_MAKE, CAR_PLATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownExceptionWhenParkingSpotIsInvalid() {
        parking.parkCar(INVALID_SPOT, car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownExceptionWhenParkingSpotIsTaken() {
        parking.parkCar(VALID_SPOT, car);
        parking.parkCar(VALID_SPOT, car);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrownExceptionWhenCarIsAlreadyParked() {
        parking.parkCar(VALID_SPOT, car);
        parking.parkCar("A4", car);
    }

    @Test
    public void shouldParkCar() {
        assertEquals(String.format("Car:%s parked successfully!", CAR_PLATE),
                parking.parkCar(VALID_SPOT, car));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownExceptionWhenRemoveACarFromInvalidSpot() {
        parking.removeCar(INVALID_SPOT, car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownExceptionWhenRemoveANotExistingCar() {
        parking.parkCar(VALID_SPOT, car);
        parking.removeCar(VALID_SPOT, new Car("Bla bla", "2321"));
    }

    @Test
    public void shouldRemoveACar() {
        parking.parkCar(VALID_SPOT, car);
        assertEquals(String.format("Remove car:%s successfully!", CAR_PLATE),
                parking.removeCar(VALID_SPOT, car));
    }

    @Test
    public void testGetParking() {
        Map<String, Car> parking = this.parking.getParking();
        assertEquals(12,parking.size());
    }
}
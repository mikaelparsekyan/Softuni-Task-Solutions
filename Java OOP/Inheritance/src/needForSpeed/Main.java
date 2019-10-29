package needForSpeed;

public class Main {
    public static void main(String[] args) {
        SportCar car = new SportCar(10.0,200);
        car.drive(1);
        System.out.println(car.getHorsePower());
    }
}

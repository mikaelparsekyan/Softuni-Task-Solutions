package generic_box_of_integer;

public class Box<T> {
    private T value;

    Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "java.lang.Integer: " + this.value;
    }
}

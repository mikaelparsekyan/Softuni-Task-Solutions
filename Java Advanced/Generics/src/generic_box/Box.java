package generic_box;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public java.lang.String toString() {
        return "java.lang.String: " + value;
    }
}

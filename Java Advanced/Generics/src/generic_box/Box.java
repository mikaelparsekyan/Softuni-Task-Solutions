package generic_box;

public class Box<String> {
    private String value;

    public Box(String value) {
        this.value = value;
    }

    @Override
    public java.lang.String toString() {
        return "java.lang.String: " + value;
    }
}

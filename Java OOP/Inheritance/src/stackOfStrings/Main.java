package stackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        sos.push("test1");
        sos.push("test2");
        sos.push("test3");
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.isEmpty());
    }
}

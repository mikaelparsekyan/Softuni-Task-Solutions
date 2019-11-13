package reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class reflectionClass = Reflection.class;
        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());
        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i);
        }
        Object instance = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(instance);

    }
}

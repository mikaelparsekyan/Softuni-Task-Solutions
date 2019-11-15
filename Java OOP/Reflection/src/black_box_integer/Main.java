package black_box_integer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);


        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt obj = (BlackBoxInt) constructor.newInstance();

        Field innerValue = obj.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] arguments = command.split("_");
            String commandName = arguments[0];

            Method currentCommand = Arrays.stream(obj.getClass().getDeclaredMethods())
                    .filter(m->m.getName().equalsIgnoreCase(commandName))
                    .findFirst()
                    .get();
            currentCommand.setAccessible(true);
            currentCommand.invoke(obj,Integer.parseInt(arguments[1]));

            System.out.println(innerValue.get(obj));
            command = scanner.nextLine();
        }
    }
}

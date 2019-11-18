package getters_and_setters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class reflectionClass = Reflection.class;

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        Method[] methods = reflectionClass.getDeclaredMethods();
        for (Method method : methods) {
            //method.setAccessible(true);
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }

        getters.stream().sorted(Comparator.comparing(Method::getName))
                .forEach(e -> {
                    System.out.printf("%s will return class %s%n",
                            e.getName(), e.getReturnType().getSimpleName());
                });

        setters.stream().sorted(Comparator.comparing(Method::getName))
                .forEach(e -> {
                    StringBuilder parametersString = new StringBuilder();
                    Class<?>[] parameterTypes = e.getParameterTypes();
                    for (Class<?> parameter : parameterTypes) {
                        parametersString.append(parameter.getSimpleName());
                    }

                    System.out.printf("%s and will set field of class %s%n",
                            e.getName(), parametersString.toString());
                });
    }
}

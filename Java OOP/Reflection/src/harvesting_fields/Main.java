package harvesting_fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Input reader = new Input();

        String modifier = reader.readLine();
        while (!modifier.equals("HARVEST")) {
            Field[] fields = RichSoilLand.class.getDeclaredFields();
            for (Field f : fields) {
                if (Modifier.toString(f.getModifiers()).equals(modifier)) {
                    printField(f,modifier);
                } else if (modifier.equals("all")) {
                    printField(f,Modifier.toString(f.getModifiers()));
                }

            }
            modifier = reader.readLine();
        }
    }

    private static void printField(Field f,String modifier) {
        System.out.printf("%s %s %s%n", modifier, f.getType().getSimpleName(), f.getName());
    }
}
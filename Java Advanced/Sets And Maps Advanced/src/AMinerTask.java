import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String material = scanner.nextLine();
        Map<String, Integer> materials = new LinkedHashMap<>();
        while (!"stop".equals(material)) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (materials.containsKey(material)) {
                materials.put(material,materials.get(material) + quantity);
            } else {
                materials.put(material, quantity);
            }
            material = scanner.nextLine();
        }
        materials.entrySet().stream().forEach(e -> {
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        });
    }
}

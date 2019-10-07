import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> materials = new HashMap<>();
        materials.put("motes", 0);
        materials.put("fragments", 0);
        materials.put("shards", 0);

        Map<String, Integer> junk = new HashMap<>();

        int shards = 0;
        int fragments = 0;
        int motes = 0;

        String obtained = "";
        boolean isShadowmoureObtained = false;
        boolean isValanyrObtained = false;
        boolean isDragonwrathObtained = false;

        while (!isShadowmoureObtained && !isValanyrObtained
                && !isDragonwrathObtained) {
            int quantity = scanner.nextInt();
            String material = scanner.next().toLowerCase();
            if (!isMaterialJunk(material)) {
                switch (material) {
                    case "shards":
                        shards += quantity;
                        obtained = "Shadowmourne";
                        break;
                    case "fragments":
                        fragments += quantity;
                        obtained = "Valanyr";
                        break;
                    case "motes":
                        motes += quantity;
                        obtained = "Dragonwrath";
                        break;
                }
                if(materials.containsKey(material)) {
                    materials.put(material, materials.get(material) + quantity);
                } else {
                    materials.put(material, quantity);
                }
            } else {
                if (junk.containsKey(material)) {
                    junk.put(material, junk.get(material) + quantity);
                } else {
                    junk.put(material, quantity);
                }
            }

            if (motes >= 250) {
                isDragonwrathObtained = true;
                materials.put("motes", motes -= 250);
            } else if (fragments >= 250) {
                isValanyrObtained = true;
                materials.put("fragments", fragments -= 250);
            } else if (shards >= 250) {
                isShadowmoureObtained = true;
                materials.put("shards", shards -= 250);
            }
        }

        printResult(materials, junk, obtained);
    }

    private static boolean isMaterialJunk(String material) {
        return !(material.equals("motes") || material.equals("fragments")
                || material.equals("shards"));
    }

    private static void printResult(Map<String, Integer> materials, Map<String, Integer> junk, String obtained) {
        System.out.printf("%s obtained!%n", obtained);
        materials.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
        junk.entrySet().stream().sorted((a, b) -> {
            return a.getKey().compareTo(b.getKey());
        }).forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
    }
}

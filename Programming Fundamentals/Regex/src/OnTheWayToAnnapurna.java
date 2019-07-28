import java.util.*;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> storesMap = new HashMap<>();
        while (!"END".equals(input)) {
            String[] commandElements = input.split("->");
            String commandType = commandElements[0];
            String storeName = commandElements[1];
            if ("Add".equals(commandType)) {
                String[] storeArray = commandElements[2].split(",");
                List<String> currentItems = storesMap.get(storeName);
                if (currentItems == null) {
                    currentItems = new ArrayList<>(Arrays.asList(storeArray));
                } else {
                    currentItems.addAll(Arrays.asList(storeArray));
                }
                storesMap.put(storeName, currentItems);
            } else if ("Remove".equals(commandType)) {
                storesMap.remove(storeName);
            }

            input = scanner.nextLine();
        }
        System.out.println("Stores list:");
        storesMap.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().size(), a.getValue().size());
            if (result == 0) {
                result = b.getKey().compareTo(a.getKey());
            }
            return result;
        }).forEach(entry -> {
            System.out.println(entry.getKey());
            for (String s : entry.getValue()) {
                System.out.printf("<<%s>>%n",s);
            }

        });
    }
}

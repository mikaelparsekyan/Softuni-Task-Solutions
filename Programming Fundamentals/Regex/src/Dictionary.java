import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" \\| ");
        Map<String, List<String>> dictionaryMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            String[] elements = input[i].split(": ");
            String word = elements[0];
            List<String> wordDescription = dictionaryMap.get(word);
            if (wordDescription == null) {
                wordDescription = new ArrayList<>(Arrays.asList(elements[1]));
            } else {
                wordDescription.addAll(Arrays.asList(elements[1].split(", ")));
            }
            dictionaryMap.put(word, wordDescription);
        }
        List<String> findElements = Arrays.asList(scanner.nextLine().split(" \\| "));
        String endCommand = scanner.nextLine();
        if(endCommand.equals("End")) {
            printDictionary(dictionaryMap, findElements);
        } else if(endCommand.equals("List")){
            printWords(dictionaryMap);
        }
    }

    private static void printWords(Map<String, List<String>> dictionaryMap) {
        dictionaryMap.entrySet().stream().sorted((a,b)->{
            return a.getKey().compareTo(b.getKey());
        }).forEach(entry -> {
            System.out.print(entry.getKey() + " ");
        });
    }

    private static void printDictionary(Map<String, List<String>> dictionaryMap, List<String> findElements) {
        dictionaryMap.entrySet().stream().sorted((a,b)->{
            return a.getKey().compareTo(b.getKey());
        }).forEach((a) -> {
            a.getValue().sort(Comparator.comparing(String::length).reversed());
            if(findElements.contains(a.getKey())){
                System.out.println(a.getKey());
                for (String s : a.getValue()) {
                    System.out.printf("-%s%n",s);
                }
            }
        });
    }

}

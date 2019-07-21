import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> healthMap = new TreeMap<>();
        Map<String, Double> damageMap = new TreeMap<>();

        String[] demonNames = scanner.nextLine().trim().split(",");
        String regex = "-?\\d+\\.?\\d*";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < demonNames.length; i++) {
            char[] demonNameArray = demonNames[i].trim().toCharArray();
            int health = 0;

            double damage = 0;
            Matcher matcher = pattern.matcher(demonNames[i].trim());
            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group());
            }

            for (int j = 0; j < demonNameArray.length; j++) {
                char currentCharacter = demonNameArray[j];
                if (!(Character.isDigit(demonNameArray[j]))
                        && currentCharacter != '-' && currentCharacter != '+'
                        && currentCharacter != '/' && currentCharacter != '*'
                        && currentCharacter != '.') {
                    health += currentCharacter;
                }
                if (currentCharacter == '*') {
                    damage *=2;
                }
                if(currentCharacter == '/'){
                    damage /= 2;
                }
            }
            damageMap.put(demonNames[i].trim(),damage);
            healthMap.put(demonNames[i].trim(), health);
        }
        healthMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry->{
            System.out.printf("%s - %d health, %.2f damage\n",entry.getKey(),entry.getValue(),damageMap.get(entry.getKey()));
        });
    }
}

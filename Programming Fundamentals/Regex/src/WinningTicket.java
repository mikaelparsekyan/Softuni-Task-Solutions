import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().split("[\\s+,\\s]+");
        Pattern pattern = Pattern.compile("(?<value>(?<symbol>[\\$\\@\\^\\#])\\2{5,})");
        for (int i = 0; i < tickets.length; i++) {
            String currentTicket = tickets[i];
            if(currentTicket.length()==20){
                String firstPart = currentTicket.substring(0,10);
                String secondPart = currentTicket.substring(10);

                Matcher firstPartMatcher = pattern.matcher(firstPart);
                Matcher secondPartMatcher = pattern.matcher(secondPart);

                if(firstPartMatcher.find() && secondPartMatcher.find()){
                    String firstMatch = firstPartMatcher.group("value");
                    String secondMatch = secondPartMatcher.group("value");
                    char firstPartSymbol = firstPartMatcher.group("symbol").charAt(0);
                    char secondPartSymbol = firstPartMatcher.group("symbol").charAt(0);
                    if(firstPartSymbol==secondPartSymbol && firstMatch.length()>=6 && secondMatch.length()>=6){

                        int length = Math.min(firstMatch.length(),secondMatch.length());
                        if(length==10){
                            System.out.printf("ticket \"%s\" - %d%c Jackpot!\n",
                                    currentTicket, length, firstPartSymbol);
                        } else {
                            System.out.printf("ticket \"%s\" - %d%c\n",
                                    currentTicket, length, firstPartSymbol);
                        }
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match\n",currentTicket);
                }

            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}

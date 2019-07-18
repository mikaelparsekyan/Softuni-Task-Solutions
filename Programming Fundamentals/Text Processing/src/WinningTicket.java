import java.util.Scanner;

public class WinningTicket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().split("\\s+,\\s+");
        for (int i = 0; i < tickets.length; i++) {
            String ticket = tickets[i];
            if (ticket.length() == 20) {
                String firstPart = ticket.substring(0, 10);
                String secondPart = ticket.substring(10);
                char firstPartSymbol = getSymbol(firstPart);
                char secondPartSymbol = getSymbol(secondPart);
                int firstMaxSequence = returnMaxSequenceLength(firstPart);
                int secondMaxSequence = returnMaxSequenceLength(secondPart);
                //Cash@@@@@@Cash$$$$$$
                if (firstMaxSequence == secondMaxSequence && secondMaxSequence >= 6 && firstMaxSequence != 0
                        && firstPartSymbol == secondPartSymbol && firstPartSymbol != ' ') {
                    if (firstMaxSequence == 10) {
                        System.out.printf("ticket \"%s\" - %d& Jackpot!\n",
                                ticket, returnMaxSequenceLength(firstPart));
                    } else {
                        System.out.printf("ticket \"%s\" - %d&\n",
                                ticket, returnMaxSequenceLength(firstPart));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match", ticket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }

    }

    static int returnMaxSequenceLength(String ticket) {
        StringBuilder firstSymbolBuilder = new StringBuilder();
        StringBuilder secondSymbolBuilder = new StringBuilder();
        StringBuilder thirdSymbolBuilder = new StringBuilder();
        boolean isSequence = false;
        char lastChar = ' ';
        for (int i = 0; i < ticket.length(); i++) {
            char currentChar = ticket.charAt(i);
            if (currentChar == '$' || currentChar == '@' || currentChar == '&') {
                isSequence = true;
                if (isSequence) {
                    if (currentChar == '$') {
                        firstSymbolBuilder.append(currentChar);
                    } else if (currentChar == '@') {
                        secondSymbolBuilder.append(currentChar);
                    } else if (currentChar == '&') {
                        thirdSymbolBuilder.append(currentChar);
                    }
                }
            } else {
                isSequence = false;
            }

        }

        int maxSequenceLength = Math.max(Math.max(firstSymbolBuilder.toString().length(),
                secondSymbolBuilder.toString().length()),
                thirdSymbolBuilder.toString().length());

        return maxSequenceLength;
    }

    static char getSymbol(String ticket) {
        StringBuilder symbols = new StringBuilder();
        for (int i = 0; i < ticket.length(); i++) {
            char currentChar = ticket.charAt(i);
            if ((currentChar == '$' || currentChar == '@' || currentChar == '&')) {
                symbols.append(currentChar + "");
            }
        }
        if (symbols.toString().length() == 0) {
            return ' ';
        } else {
            return symbols.toString().charAt(0);
        }
    }
}


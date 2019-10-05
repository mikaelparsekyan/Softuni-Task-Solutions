import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pairs = Integer.parseInt(scanner.nextLine());
        Map<String,Double> studentAndGrade = new TreeMap<>();
        for (int i = 0; i < pairs; i++) {
            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            studentAndGrade.put(studentName,getAverageGrade(grades));
        }
        for (Map.Entry<String, Double> entry : studentAndGrade.entrySet()) {
            BigDecimal avgGrade = new BigDecimal(entry.getValue() + "");
            System.out.printf("%s is graduated with %s%n",entry.getKey(),
                    avgGrade.stripTrailingZeros().toPlainString());
        }

    }

    private static double getAverageGrade(List<Double> grades) {
        double averageGrade = 0;
        for (Double grade : grades) {
            averageGrade += grade;
        }
        averageGrade /= grades.size();
        return averageGrade;
    }
}

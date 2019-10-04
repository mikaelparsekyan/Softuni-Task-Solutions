import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < lines; i++) {
            String[] elements = scanner.nextLine().split("\\s+");

            String studentName = elements[0];
            double currentGrade = Double.parseDouble(elements[1]);

            List<Double> grades = new ArrayList<>();
            if (students.containsKey(studentName)) {
                grades = students.get(studentName);
                grades.add(currentGrade);
            } else {
                grades.add(currentGrade);
            }
            students.put(studentName, grades);
        }
        printStudentGrades(students);
    }

    private static void printStudentGrades(Map<String, List<Double>> students) {
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            System.out.printf("%s -> ",
                    entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("%.2f ",entry.getValue().get(i));
            }
            System.out.printf("(avg: %.2f)%n",getAverageGrade(entry.getValue()));
        }
    }

    private static double getAverageGrade(List<Double> grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}

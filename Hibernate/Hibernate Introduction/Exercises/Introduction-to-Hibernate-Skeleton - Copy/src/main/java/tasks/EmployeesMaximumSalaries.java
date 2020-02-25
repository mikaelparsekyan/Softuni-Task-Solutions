package tasks;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

import static tasks.Queries.GET_DEPARTMENT_WITH_MAX_SALARY;

public class EmployeesMaximumSalaries extends Task {
    public EmployeesMaximumSalaries(EntityManager manager) {
        super(manager);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        List<Object[]> columns = getManager()
                .createQuery(GET_DEPARTMENT_WITH_MAX_SALARY)
                .getResultList();


        printResult(columns);
    }

    private void printResult(List<Object[]> columns) {
        for (Object[] column : columns) {
            String departmentName = (String) column[0];
            BigDecimal departmentMaxSalary = (BigDecimal) column[1];
            System.out.printf("%s %.2f%n", departmentName,
                    departmentMaxSalary.floatValue());
        }
    }
}

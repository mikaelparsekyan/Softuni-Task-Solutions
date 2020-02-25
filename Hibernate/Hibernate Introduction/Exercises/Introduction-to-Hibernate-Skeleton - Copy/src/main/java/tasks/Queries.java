package tasks;

public abstract class Queries {
    //ALL TASKS QUERIES

    //2. Remove Objects //TODO CHECK
    static final String PERSIST_ALL_TOWNS =
            "SELECT t FROM Town AS t WHERE LENGTH(t.name) > 5";

    //3. Contains Employee
    static final String GET_EMPLOYEE_NAME =
            "SELECT e FROM Employee AS e WHERE CONCAT(e.firstName, ' ', e.lastName) =: name";

    //4. Employees with Salary Over 50 000

    static final String GET_EMPLOYEES_WITH_SALARY_MORE_THAN =
            "SELECT e FROM Employee AS e WHERE salary >=: min_salary";

    //5. Employees from Department

    static final String GET_EMPLOYEES_FROM_DEPARTMENT =
            "SELECT e " +
                    "FROM Employee e " +
                    "LEFT JOIN e.department d " +
                    "WHERE d.id = 6 " +
                    "ORDER BY e.salary ASC, " +
                    "e.id ASC";

    //6. Adding a New Address and Updating Employee

    static final String GET_ADDRESS_BY_NAME =
            "SELECT a FROM Address a WHERE a.text =: text";

    static final String GET_EMPLOYEE_BY_LAST_NAME =
            "SELECT e FROM Employee e WHERE e.lastName =: last_name";

    //7. Addresses with Employee Count//TODO

    static final String FIND_ADDRESSES =
            "SELECT a FROM Address a ORDER BY (" +
                    "" +
                    ")";

    //8. Get Employee with Project
    static final String GET_PROJECTS =
            "SELECT p FROM Employee e\n" +
                    "JOIN e.projects p " +
                    "WHERE e.id =: id " +
                    "ORDER BY p.name ASC";

    //9. Find Latest 10 Projects


    //10. Increase Salaries
}

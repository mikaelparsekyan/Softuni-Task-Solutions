package tasks;

public abstract class Queries {
    //ALL TASKS QUERIES

    //2. Remove Objects
    static final String PERSIST_ALL_TOWNS =
            "SELECT t FROM Town AS t WHERE LENGTH(t.name) > 5";

    static final String GET_ALL_TOWNS =
            "SELECT t FROM Town t";


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


    //7. Addresses with Employee Count
    static final String FIND_ADDRESSES =
            "SELECT a.text,a.town.name, COUNT(e.id) FROM Address a JOIN a.employees e GROUP BY a.text ORDER BY COUNT(e.id) DESC";


    //8. Get Employee with Project
    static final String GET_PROJECTS =
            "SELECT p FROM Employee e\n" +
                    "JOIN e.projects p " +
                    "WHERE e.id =: id " +
                    "ORDER BY p.name ASC";


    //9. Find Latest 10 Projects
    static final String GET_LAST_PROJECTS =
            "SELECT p FROM Project p ORDER BY p.name ASC, p.startDate DESC";


    //10. Increase Salaries
    static final String GET_EMPLOYEES =
            "SELECT e FROM Employee e WHERE e.department.id = 1" +
                    "OR e.department.id = 2 " +
                    "OR e.department.id = 4 " +
                    "OR e.department.id = 11";


    //11. Remove Towns
    static final String GET_TOWN_BY_NAME =
            "SELECT t FROM Town t WHERE t.name = : name";

    static final String GET_ADDRESSES =
            "SELECT a FROM Address a WHERE a.town.id =: id";

    static final String GET_COUNT_OF_DELETED_ADDRESSES =
            "SELECT COUNT(a.id) FROM Address a WHERE a.town.id =: id";


    //12. Find Employees by First Name
    static final String FIND_EMPLOYEE_BY_PATTERN =
            "SELECT e FROM Employee e WHERE e.firstName LIKE :pattern " +
                    "";


    //13. Employees Maximum Salaries
    static final String GET_DEPARTMENT_WITH_MAX_SALARY =
            "SELECT d.name, MAX(e.salary) AS max\n" +
                    "FROM Department d JOIN d.employees e\n" +
                    "GROUP BY d.id\n" +
                    "HAVING MAX(e.salary) NOT BETWEEN :start AND :end";

}

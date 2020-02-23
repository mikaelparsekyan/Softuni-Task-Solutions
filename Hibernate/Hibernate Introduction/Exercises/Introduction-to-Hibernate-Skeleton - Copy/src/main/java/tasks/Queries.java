package tasks;

abstract class Queries {
    //ALL TASKS QUERIES

    //2. Remove Objects
    static final String PERSIST_ALL_TOWNS =
            "SELECT t FROM Town AS t WHERE LENGTH(t.name) > 5";

    //3. Contains Employee
    static final String GET_EMPLOYEE_NAME =
            "SELECT e FROM Employee AS e WHERE CONCAT(e.firstName, ' ', e.lastName) =: name";


}

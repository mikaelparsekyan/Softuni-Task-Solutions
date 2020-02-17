import tasks.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class Main {
    /*
       @Warning: FOR PROPER RESULTS, PLEASE USE A CLEAR DATABASE!!! :)
     */
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        try {
            Properties properties = getProperties();

            Connection connection = DriverManager
                    .getConnection(Constants.CONNECTION_LINK, properties);


            runAllTasks(connection);


        } catch (SQLException e) {
            System.out.println("Unexpected mysql error!");
        }
    }

    private static void runAllTasks(Connection connection) {
        //THIS METHOD RUNS ALL TASKS USING DELIMITER, SO YOU DON'T NEED TO RUN EVERY TASK SEPARATELY :)
        for (Task task : getAllTasks(connection)) {
            task.run();
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println();
        }
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("user", Constants.USERNAME);
        properties.setProperty("password", Constants.PASSWORD);
        return properties;
    }

    private static List<Task> getAllTasks(Connection connection){
        List<Task> allTasks = new LinkedList<>();
        allTasks.add(new GetVillainsNames(connection));
        allTasks.add(new GetMinionNames(connection));
        allTasks.add(new AddMinion(connection));
        allTasks.add(new ChangeTownNamesCasing(connection));
        allTasks.add(new RemoveVillain(connection));
        allTasks.add(new PrintAllMinionNames(connection));
        allTasks.add(new IncreaseMinionsAge(connection));
        allTasks.add(new IncreaseAgeStoredProcedure(connection));
        return allTasks;
    }

}

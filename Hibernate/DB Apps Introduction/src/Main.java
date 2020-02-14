import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        try {
            Properties properties = getProperties();

            Connection connection = DriverManager
                    .getConnection(Constants.CONNECTION_LINK, properties);

            TaskManager tasks = new TaskManager(connection);

            /* Uncomment to see the tasks. :)

            tasks.getVillainsNames();

            tasks.getMinionsNames();

            tasks.changeTownNamesCasing();
            */




        } catch (SQLException e) {
            System.out.println("Mysql error!");
        }
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("user", Constants.USERNAME);
        properties.setProperty("password", Constants.PASSWORD);
        return properties;
    }

}

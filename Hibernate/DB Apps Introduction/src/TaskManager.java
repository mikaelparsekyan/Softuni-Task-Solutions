import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TaskManager {
    private Scanner scanner;

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    TaskManager(Connection connection) {
        this.connection = connection;
    }

    // 2. Get Villains’ Names
    void getVillainsNames(Connection connection) throws SQLException {
        this.statement = connection.prepareStatement(Constants.GET_VILLAINS_NAMES_QUERY);

        this.resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %s%n", resultSet.getString("name"), resultSet.getString("m_count"));
        }
    }

    // 3. Get Minion Names
    void getMinionsNames(Connection connection) {
        this.scanner = new Scanner(System.in);
        int villain_id = Integer.parseInt(scanner.nextLine());
        try {

            this.statement = connection.prepareStatement(Constants.GET_VILLAIN_NAME_BY_ID);
            this.statement.setInt(1, villain_id);
            this.resultSet = statement.executeQuery();
            this.resultSet.next();
            String villainName = resultSet.getString("name");
            System.out.println("Villain: " + villainName);
            this.statement = connection.prepareStatement(Constants.GET_MINIONS_BY_VILLAIN_NAME);
            this.statement.setString(1, villainName);
            this.resultSet = statement.executeQuery();
            int row = 1;
            while (resultSet.next()) {
                System.out.printf("%d. %s %d%n", row++, resultSet.getString("name"),
                        resultSet.getInt("age"));

            }
        } catch (SQLException e) {
            System.out.printf(Constants.VILLAIN_NAME_NOT_FOUND, villain_id);
        }
    }
}

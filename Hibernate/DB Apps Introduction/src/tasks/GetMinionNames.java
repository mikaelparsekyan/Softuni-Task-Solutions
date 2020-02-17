package tasks;

import java.sql.Connection;
import java.sql.SQLException;

public class GetMinionNames extends Task {

    public GetMinionNames(Connection connection) {
        super(connection);
    }

    @Override
    public void run() {
        int villain_id = Integer.parseInt(getScanner().nextLine());
        try {

            setPreparedStatement(getConnection().prepareStatement(Queries.GET_VILLAIN_NAME_BY_ID));
            getPreparedStatement().setInt(1, villain_id);

            setResultSet(getPreparedStatement().executeQuery());

            getResultSet().next();
            String villainName = getResultSet().getString("name");

            System.out.println("Villain: " + villainName);

            setPreparedStatement(getConnection().prepareStatement(Queries.GET_MINIONS_BY_VILLAIN_NAME));

            getPreparedStatement().setString(1, villainName);
            setResultSet(getPreparedStatement().executeQuery());

            this.printResult();
        } catch (SQLException e) {
            System.out.printf(Queries.VILLAIN_NAME_NOT_FOUND, villain_id);
        }
    }

    @Override
    public void printResult() {
        try {
            int row = 1;
            while (getResultSet().next()) {
                System.out.printf("%d. %s %d%n", row++, getResultSet().getString("name"),
                        getResultSet().getInt("age"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

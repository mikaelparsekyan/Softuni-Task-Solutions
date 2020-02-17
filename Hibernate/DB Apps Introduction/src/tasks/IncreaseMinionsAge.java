package tasks;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class IncreaseMinionsAge extends Task {
    public IncreaseMinionsAge(Connection connection) {
        super(connection);
    }

    @Override
    public void run() {
        int[] ids = Arrays.stream(getScanner().nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        try {
            setPreparedStatement(getConnection().prepareStatement(Queries.INCREASE_MINION_AGE));

            for (int id : ids) {
                getPreparedStatement().setInt(1, id);
                getPreparedStatement().executeUpdate();
            }

            this.getAllMinions();
            this.printResult();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getAllMinions() throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.GET_ALL_MINIONS));

        setResultSet(getPreparedStatement().executeQuery());
    }

    @Override
    public void printResult() {
        try {
            while (getResultSet().next()) {
                System.out.printf("%s %s%n", getResultSet().getString("name"),
                        getResultSet().getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

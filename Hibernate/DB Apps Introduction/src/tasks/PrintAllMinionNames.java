package tasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintAllMinionNames extends Task {
    public PrintAllMinionNames(Connection connection) {
        super(connection);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= getMinionsCount() / 2; i++) {
                System.out.println(getMinionName(i));
                System.out.println(getMinionName(getMinionsCount() - i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getMinionName(int id) throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.GET_MINION_NAME_BY_ID));
        getPreparedStatement().setInt(1, id);
        ResultSet resultSet = getPreparedStatement().executeQuery();
        resultSet.next();
        return resultSet.getString("name");
    }

    private int getMinionsCount() throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.GET_ALL_MINIONS_COUNT));
        ResultSet resultSet = getPreparedStatement().executeQuery();
        resultSet.next();
        return Integer.parseInt(resultSet.getString("c"));
    }

    @Override
    public void printResult() {

    }
}

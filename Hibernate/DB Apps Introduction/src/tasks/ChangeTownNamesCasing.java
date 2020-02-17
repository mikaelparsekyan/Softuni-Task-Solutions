package tasks;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ChangeTownNamesCasing extends Task {
    public ChangeTownNamesCasing(Connection connection) {
        super(connection);
    }

    @Override
    public void run() {
        String townName = getScanner().nextLine();
        try {
            setPreparedStatement(getConnection().prepareStatement(Queries.UPDATE_TOWN_NAME_QUERY));

            getPreparedStatement().setString(1, townName);
            getPreparedStatement().executeUpdate();

            setPreparedStatement(getConnection().prepareStatement(Queries.SELECT_COUNT_UPDATED_TOWNS));
            getPreparedStatement().setString(1, townName);

            setResultSet(this.getPreparedStatement().executeQuery());
            getResultSet().next();

            int count = getResultSet().getInt("count");

            if (count == 0) {
                System.out.println(Queries.NO_TOWNS_AFFECTED);
                return;
            }
            setPreparedStatement(getConnection().prepareStatement(Queries.SELECT_NAME_UPDATED_TOWNS));
            getPreparedStatement().setString(1, townName);
            setResultSet(this.getPreparedStatement().executeQuery());

            System.out.println(count + " town names were affected.");
            this.printResult();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printResult() {
        try {
            List<String> towns = new LinkedList<>();
            while (getResultSet().next()) {
                towns.add(getResultSet().getString("name"));
            }
            System.out.println(towns);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

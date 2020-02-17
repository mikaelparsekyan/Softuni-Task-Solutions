package tasks;

import java.sql.Connection;
import java.sql.SQLException;

public class GetVillainsNames extends Task {
    public GetVillainsNames(Connection connection) {
        super(connection);
    }

    @Override
    public void run() {
        try {
            super.setPreparedStatement(getConnection().prepareStatement(Queries.GET_VILLAINS_NAMES));

            setResultSet(getPreparedStatement().executeQuery());

            this.printResult();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printResult() {
        try {
            while (getResultSet().next()) {
                System.out.printf("%s %s%n", getResultSet().getString("name"),
                        getResultSet().getString("m_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

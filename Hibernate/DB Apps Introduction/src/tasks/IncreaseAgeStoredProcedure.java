package tasks;

import java.sql.Connection;
import java.sql.SQLException;

public class IncreaseAgeStoredProcedure extends Task {
    private String minionName;
    private int minionAge;

    public IncreaseAgeStoredProcedure(Connection connection) {
        super(connection);
    }

    @Override
    public void run() {
        int minionId = Integer.parseInt(getScanner().nextLine());

        try {
            this.dropProcedureIfExists();
            this.createStoredProcedure();
            this.increaseMinionAge(minionId);

            this.minionName = getRemovedMinionColumn(minionId, "name");
            String ageStr = getRemovedMinionColumn(minionId, "age");

            if (ageStr != null) {
                this.minionAge = Integer.parseInt(ageStr);
            }

            printResult();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropProcedureIfExists() throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.DROP_STORED_PROCEDURE));
        getPreparedStatement().executeUpdate();
    }

    private void createStoredProcedure() throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.INCREASE_MINION_AGE_PROCEDURE));
        getPreparedStatement().executeUpdate();
    }

    private void increaseMinionAge(int minionId) throws SQLException {
        setCallableStatement(getConnection().prepareCall(Queries.CALL_PROCEDURE));
        getCallableStatement().setInt(1, minionId);

        getCallableStatement().executeUpdate();
    }

    private String getRemovedMinionColumn(int minionId, String columnName) throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.GET_REMOVED_MINION_NAME_AND_AGE));
        getPreparedStatement().setInt(1, minionId);
        setResultSet(getPreparedStatement().executeQuery());
        if (getResultSet().next()) {
            return getResultSet().getString(columnName);
        }
        return null;
    }

    @Override
    public void printResult() {
        System.out.printf("%s %s%n", minionName, minionAge);
    }
}

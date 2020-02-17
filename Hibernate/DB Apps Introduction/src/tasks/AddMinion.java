package tasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMinion extends Task {
    private String minionName;
    private String villainName;

    public AddMinion(Connection connection) {
        super(connection);
    }

    @Override
    public void run() {
        String[] minionInfo = getScanner().nextLine()
                .split("\\s+");

        minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String townName = minionInfo[3];

        String[] villainInfo = getScanner().nextLine()
                .split("\\s+");

        villainName = villainInfo[1];

        try {
            addTownIfNotExists(townName);
            addVillainIfNotExists(villainName);

            int townId = getIdFromTableByName("towns", townName);

            addMinion(minionName, minionAge, townId);

            int minionId = getIdFromTableByName("minions", minionName);
            int villainId = getIdFromTableByName("villains", villainName);

            addMinionToVillain(minionId, villainId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getIdFromTableByName(String tableName, String name) throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(String.format(Queries.GET_ID_BY_NAME, tableName)));
        getPreparedStatement().setString(1, name);

        ResultSet resultSet = getPreparedStatement().executeQuery();

        resultSet.next();

        int res = resultSet.getInt("id");
        if (res > 0) {
            return res;
        }

        return -1;
    }

    private boolean checkIfRecordExists(String tableName, String name) throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(
                String.format(Queries.SELECT_NAME_BY_ID, tableName)));
        getPreparedStatement().setString(1, name);

        ResultSet resultSet = getPreparedStatement().executeQuery();

        return resultSet.next();

    }

    private void addMinion(String minionName, int age, int townId) throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.INSERT_INTO_MINIONS));
        getPreparedStatement().setString(1, minionName);
        getPreparedStatement().setInt(2, age);
        getPreparedStatement().setInt(3, townId);

        getPreparedStatement().executeUpdate();
    }

    private void addMinionToVillain(int minionId, int villainId) throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.ADD_MINION_TO_VILLAIN));
        getPreparedStatement().setInt(1, minionId);
        getPreparedStatement().setInt(2, villainId);

        getPreparedStatement().executeUpdate();
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    private void addTownIfNotExists(String townName) throws SQLException {
        if (!checkIfRecordExists("towns", townName)) {
            setPreparedStatement(getConnection().prepareStatement(Queries.ADD_TOWN));
            getPreparedStatement().setString(1, townName);

            getPreparedStatement().executeUpdate();
            System.out.printf("Town %s was added to the database.%n", townName);
        }
    }

    private void addVillainIfNotExists(String villainName) throws SQLException {
        if (!checkIfRecordExists("villains", villainName)) {
            setPreparedStatement(getConnection().prepareStatement(Queries.ADD_VILLAIN));
            getPreparedStatement().setString(1, villainName);

            getPreparedStatement().executeUpdate();
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }
    }

    @Override
    public void printResult() {

    }
}

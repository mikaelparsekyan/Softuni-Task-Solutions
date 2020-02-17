package tasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveVillain extends Task {
    private String villainName;
    private int removedMinionsCount = 0;
    private int villainId = 0;

    public RemoveVillain(Connection connection) {
        super(connection);
    }

    @Override
    public void run() {
        this.villainId = Integer.parseInt(getScanner().nextLine());

        try {
            this.villainName = getRemovedVillainName();

            this.removeVillain();

            this.removedMinionsCount = getRemovedMinionsCount();

            this.removeServingMinions();

            if(villainName == null && removedMinionsCount == 0){
                System.out.println("No such villain was found");
            } else {
                this.printResult();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printResult() {
        System.out.printf("%s was deleted%n", villainName);
        System.out.printf("%s minions released", removedMinionsCount);
    }

    private String getRemovedVillainName() throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.GET_REMOVED_VILLAIN_NAME));
        getPreparedStatement().setInt(1, villainId);
        setResultSet(getPreparedStatement().executeQuery());
        if (getResultSet().next()) {
            return getResultSet().getString("name");
        }
        return null;
    }

    private void removeVillain() throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.REMOVE_VILLAIN));
        getPreparedStatement().setInt(1, villainId);

        getPreparedStatement().executeUpdate();
    }

    private int getRemovedMinionsCount() throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.GET_REMOVED_MINIONS_COUNT));
        getPreparedStatement().setInt(1, villainId);
        ResultSet resultSet = getPreparedStatement().executeQuery();

        resultSet.next();
        return resultSet.getInt("count");
    }

    private void removeServingMinions() throws SQLException {
        setPreparedStatement(getConnection().prepareStatement(Queries.REMOVE_SERVING_MINIONS));

        getPreparedStatement().setInt(1, villainId);

        getPreparedStatement().executeUpdate();
    }
}

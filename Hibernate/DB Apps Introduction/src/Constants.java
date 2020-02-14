class Constants {
    private static final String DB_NAME = "minions_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    static final String CONNECTION_LINK = "jdbc:mysql://localhost:3306/" + DB_NAME;

    static final String GET_VILLAINS_NAMES_QUERY = "SELECT v.name AS name, COUNT(mv.minion_id) AS m_count FROM villains AS v\n" +
            "JOIN minions_villains AS mv ON mv.villain_id = v.id\n" +
            "GROUP BY v.id\n" +
            "HAVING m_count > 15\n" +
            "ORDER BY m_count DESC;";

    static final String GET_VILLAIN_NAME_BY_ID = "SELECT v.name AS name\n" +
            "FROM villains AS v\n" +
            "WHERE  v.id = ?";

    static final String GET_MINIONS_BY_VILLAIN_NAME = "SELECT m.name AS name, m.age AS age\n" +
            "FROM villains AS v\n" +
            "         RIGHT JOIN minions_villains AS mv ON mv.villain_id = v.id\n" +
            "         RIGHT JOIN minions AS m ON m.id = mv.minion_id\n" +
            "WHERE  v.name = ?\n";

    static final String VILLAIN_NAME_NOT_FOUND = "No villain with ID %d exists in the database.";
}

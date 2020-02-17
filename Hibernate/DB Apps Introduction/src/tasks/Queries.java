package tasks;

class Queries {
    static final String GET_VILLAINS_NAMES = "SELECT v.name AS name, COUNT(mv.minion_id) AS m_count FROM villains AS v\n" +
            "JOIN minions_villains AS mv ON mv.villain_id = v.id\n" +
            "GROUP BY v.id\n" +
            "HAVING m_count > 15\n" +
            "ORDER BY m_count DESC";

    static final String GET_VILLAIN_NAME_BY_ID = "SELECT v.name AS name\n" +
            "FROM villains AS v\n" +
            "WHERE  v.id = ?";

    static final String GET_MINIONS_BY_VILLAIN_NAME = "SELECT m.name AS name, m.age AS age\n" +
            "FROM villains AS v\n" +
            "         RIGHT JOIN minions_villains AS mv ON mv.villain_id = v.id\n" +
            "         RIGHT JOIN minions AS m ON m.id = mv.minion_id\n" +
            "WHERE  v.name = ?\n";

    static final String VILLAIN_NAME_NOT_FOUND = "No villain with ID %d exists in the database.";

    static final String UPDATE_TOWN_NAME_QUERY = "UPDATE towns AS t\n" +
            "SET name = (\n" +
            "    UPPER(name)\n" +
            "    )\n" +
            "WHERE t.country = ?";

    static final String SELECT_NAME_UPDATED_TOWNS = "SELECT name FROM towns WHERE country = ?";

    static final String SELECT_COUNT_UPDATED_TOWNS = "SELECT COUNT(id) AS count FROM towns WHERE country = ?";

    static final String NO_TOWNS_AFFECTED = "No town names were affected.";

    static final String INSERT_INTO_MINIONS = "INSERT INTO MINIONS VALUES (NULL, ?, ?, ?)";

    static final String GET_ID_BY_NAME = "SELECT id FROM %s WHERE name = ?";

    static final String SELECT_NAME_BY_ID = "SELECT name FROM %s WHERE name = ?";

    static final String ADD_MINION_TO_VILLAIN = "INSERT INTO minions_villains VALUES(?,?)";

    static final String ADD_VILLAIN = "INSERT INTO villains VALUES (NULL, ?, 'evil')";

    static final String ADD_TOWN = "INSERT INTO towns VALUES (NULL, ?, NULL)";

    static final String INCREASE_MINION_AGE = "UPDATE minions SET age = age + 1, name = LOWER(name)\n" +
            "WHERE id = ?";

    static final String GET_ALL_MINIONS = "SELECT name, age FROM minions";


    static final String REMOVE_VILLAIN = "DELETE FROM villains WHERE id = ?";

    static final String GET_REMOVED_VILLAIN_NAME = "SELECT name FROM villains WHERE id = ?";

    static final String REMOVE_SERVING_MINIONS = "DELETE FROM minions_villains WHERE villain_id = ?";

    static final String GET_REMOVED_MINIONS_COUNT = "SELECT COUNT(minion_id) AS count FROM minions_villains WHERE villain_id = ?";

    static final String DROP_STORED_PROCEDURE = "DROP PROCEDURE IF EXISTS usp_get_older;";

    static final String INCREASE_MINION_AGE_PROCEDURE = "CREATE PROCEDURE usp_get_older(minion_id INT)\n" +
            "    BEGIN\n" +
            "        UPDATE minions SET age = age + 1\n" +
            "        WHERE id = minion_id;\n" +
            "    END;";

    static final String GET_REMOVED_MINION_NAME_AND_AGE = "SELECT name, age\n" +
            "FROM minions\n" +
            "WHERE id = ?\n";

    static final String CALL_PROCEDURE = "CALL usp_get_older(?)";

    static final String GET_MINION_NAME_BY_ID = "SELECT name FROM minions WHERE id = ?";

    static final String GET_ALL_MINIONS_COUNT = "SELECT COUNT(id) AS c FROM minions";
}

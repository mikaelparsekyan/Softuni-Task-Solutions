package tasks;

import java.sql.*;
import java.util.Scanner;

public abstract class Task {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private CallableStatement callableStatement;
    private ResultSet resultSet;
    private Scanner scanner;

    private String query;

    public Task(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }

    public Connection getConnection() {
        return connection;
    }


    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public CallableStatement getCallableStatement() {
        return callableStatement;
    }

    public void setCallableStatement(CallableStatement callableStatement) {
        this.callableStatement = callableStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public abstract void run();

    public abstract void printResult();
}

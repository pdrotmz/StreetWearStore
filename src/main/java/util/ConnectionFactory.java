package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = EnvLoader.get("URL");
    private static final String USER = EnvLoader.get("USER");
    private static final String PASSWORD = EnvLoader.get("PASSWORD");

    public static Connection connection;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver Oracle não encontrado.", e);
        }
    }

    public static Connection getInstance() {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException exception) {
                throw new RuntimeException("Erro ao obter conexão com o banco", exception);
        }
        return connection;
    }
}

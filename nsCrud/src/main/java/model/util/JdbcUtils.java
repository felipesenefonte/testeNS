package model.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Auxiliar para Conexao com o banco
 */
public class JdbcUtils {

    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection != null)
            return connection;
        else {

            //Endereco do DB da amazon
            String url = "jdbc:postgresql://54.94.145.175:5432/dev";

            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, "postgres", "admin");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}

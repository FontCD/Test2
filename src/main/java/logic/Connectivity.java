package logic;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Connectivity {
    private static String USER = null;
    private static String PASS = null;
    private static String DBURL = null;

    private static Connection conn;

    public static void setConnection() {
        try {
            InputStream input = new FileInputStream("C:/Users/fonte/IdeaProjects/Moteeve/src/main/resources/properties.properties");
            Properties prop = new Properties();
            prop.load(input);

            USER = prop.getProperty("db.user");
            PASS = prop.getProperty("db.password");
            DBURL = prop.getProperty("db.url");

            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connectivity() {
        throw new IllegalStateException("Utility class");
    }

    public static Connection getConn() {													//metodo che serve ai DAO per prendere la connessione
        return conn;
    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
            se2.printStackTrace();
        }
    }

    public static void disconnect(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
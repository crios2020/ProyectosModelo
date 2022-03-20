package ar.com.eduit.curso.java.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    private static String driver="org.mariadb.jdbc.Driver";
    private static String url="jdbc:mariadb://localhost:3306/colegio";
    private static String user="root";
    private static String pass="";
//    private static String driver = "org.postgresql.Driver";
//    private static String url = "jdbc:postgresql://tuffi.db.elephantsql.com:5432/gdyhittm";
//    private static String user = "gdyhittm";
//    private static String pass = "3pJiSBDlGj5FbzcM-gTRP4y_NIu81RJg";

    private static Connection conn = null;

    private Connector() {
    }

    private Connector(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public static synchronized Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}

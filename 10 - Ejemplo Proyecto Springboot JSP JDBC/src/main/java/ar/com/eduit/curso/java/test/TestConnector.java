package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connectors.Connector;
import java.sql.ResultSet;
import java.time.LocalTime;

public class TestConnector {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.out.println("Hora: "+LocalTime.now());
        try (ResultSet rs= Connector.getConnection().createStatement().executeQuery("select version()")){         
            if(rs.next()) System.out.println(rs.getString(1));
            //System.out.println("Presione <ENTER> para continuar...");
            //new Scanner(System.in).next();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Hora: "+LocalTime.now());
    }
}

package com.hamitmizrak.mysql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements Serializable {
    private static final long serialVersionUID = -5994318420324614256L;
    // Denemeroot4411.
    private String user = "root";
    private String password = "rootroot";
    private String url = "jdbc:mysql://localhost:3306/ecommerse";
    private Connection connection;

    public Connection connectionMethod() {
        try {
            if (connection == null || connection.isClosed()) { // 100 bağlantıdan sonra hata olmaması için kullanıyoruz.
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // System.out.println("Driver başarılı biR şekilde yüklendi");
                    connection = DriverManager.getConnection(url, user, password);
                    // System.out.println("Bağlantı başarılı");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        db.connectionMethod();
    }

}
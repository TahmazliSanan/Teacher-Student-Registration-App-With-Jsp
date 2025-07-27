package org.pronet.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtil {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306" +
                    "/onlinedu_db?user=root&password=23042002&characterEncoding=UTF-8");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/mbti??serverTimezone=UTC";
    private String username = "root";
    private String password = "123456";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }

    public static ConnectionFactory getInstance(){
        if(connectionFactory == null)
            connectionFactory = new ConnectionFactory();
        return connectionFactory;
    }
}

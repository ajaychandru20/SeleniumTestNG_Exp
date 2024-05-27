package jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectXAMPforMySql {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/jdbc_test");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from users_info");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)+" " + resultSet.getString(2)+" " + resultSet.getString(3)+" " +
                    resultSet.getString(4)+" " + resultSet.getString(5));
        }

        connection.close();
    }
}

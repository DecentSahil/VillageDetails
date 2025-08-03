package Village.Details;

import java.sql.*;
public class Conn {
    Connection conn;
    Statement s;
    public Conn(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Village","root","1234");
            s = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return conn;
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

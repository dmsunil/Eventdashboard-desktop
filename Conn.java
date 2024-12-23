package eventmanagementsystem;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///eventdashboard1", "root", "Sunil@22");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

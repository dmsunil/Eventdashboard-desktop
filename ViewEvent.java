package eventmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewEvent extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    ViewEvent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Event Details");
        heading.setBounds(300, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        table = new JTable();
        table.setBounds(30, 80, 800, 400);
        add(table);

        try {
            Conn conn = new Conn();
            String query = "select * from event";
            ResultSet rs = conn.s.executeQuery(query);

            table.setModel(new net.proteanit.sql.DbUtils().resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 600);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEvent();
    }
}

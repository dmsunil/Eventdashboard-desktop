package eventmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEvent extends JFrame implements ActionListener {

    Choice cEventId;
    JButton delete, back;

    RemoveEvent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblheading = new JLabel("Remove Event");
        lblheading.setBounds(100, 20, 400, 50);
        lblheading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblheading);

        JLabel lblEventId = new JLabel("Event ID");
        lblEventId.setBounds(50, 100, 100, 30);
        lblEventId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblEventId);

        cEventId = new Choice();
        cEventId.setBounds(150, 100, 200, 30);
        try {
            Conn conn = new Conn();
            String query = "select EventID from event";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                cEventId.add(rs.getString("EventID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(cEventId);

        delete = new JButton("Delete");
        delete.setBounds(50, 200, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(200, 200, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(500, 400);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn conn = new Conn();
                String query = "delete from event where EventID = '" + cEventId.getSelectedItem() + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Event Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEvent();
    }
}

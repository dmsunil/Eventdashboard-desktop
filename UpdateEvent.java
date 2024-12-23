package eventmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEvent extends JFrame implements ActionListener {

    Choice cEventId;
    JTextField tfName, tfDate, tfVenue, tfOrganizer;
    JButton update, back;

    UpdateEvent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblheading = new JLabel("Update Event Details");
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
            ResultSet rs = conn.s.executeQuery("select EventID from event");
            while (rs.next()) {
                cEventId.add(rs.getString("EventID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(cEventId);

        JLabel lblName = new JLabel("Event Name");
        lblName.setBounds(50, 150, 100, 30);
        lblName.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(150, 150, 200, 30);
        add(tfName);

        JLabel lblDate = new JLabel("Event Date");
        lblDate.setBounds(50, 200, 100, 30);
        lblDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblDate);

        tfDate = new JTextField();
        tfDate.setBounds(150, 200, 200, 30);
        add(tfDate);

        JLabel lblVenue = new JLabel("Venue");
        lblVenue.setBounds(50, 250, 100, 30);
        lblVenue.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblVenue);

        tfVenue = new JTextField();
        tfVenue.setBounds(150, 250, 200, 30);
        add(tfVenue);

        JLabel lblOrganizer = new JLabel("Organizer");
        lblOrganizer.setBounds(50, 300, 100, 30);
        lblOrganizer.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblOrganizer);

        tfOrganizer = new JTextField();
        tfOrganizer.setBounds(150, 300, 200, 30);
        add(tfOrganizer);

        update = new JButton("Update");
        update.setBounds(50, 400, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(200, 400, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(500, 500);
        setLocation(450, 100);
        setVisible(true);

        cEventId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn conn = new Conn();
                    String query = "select * from event where EventID = '" + cEventId.getSelectedItem() + "'";
                    ResultSet rs = conn.s.executeQuery(query);
                    while (rs.next()) {
                        tfName.setText(rs.getString("Name"));
                        tfDate.setText(rs.getString("Date"));
                        tfVenue.setText(rs.getString("Venue"));
                        tfOrganizer.setText(rs.getString("Organizer"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
    	if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEvent();
    }
}
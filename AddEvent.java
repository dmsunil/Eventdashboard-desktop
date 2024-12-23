package eventmanagementsystem;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.Random;
import java.text.SimpleDateFormat;

public class AddEvent extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(9999); // Event ID
    
    JTextField tfname, tfvenue, tfcapacity, tfbudget, tforganizer;
    JDateChooser dcdate;
    JComboBox<String> cbtype;
    JLabel lbleventId;
    JButton add, back;

    AddEvent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Event Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Event Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel labelvenue = new JLabel("Venue");
        labelvenue.setBounds(400, 150, 150, 30);
        labelvenue.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelvenue);
        
        tfvenue = new JTextField();
        tfvenue.setBounds(600, 150, 150, 30);
        add(tfvenue);

        JLabel labeldate = new JLabel("Date");
        labeldate.setBounds(50, 200, 150, 30);
        labeldate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(200, 200, 150, 30);
        add(dcdate);

        JLabel labelcapacity = new JLabel("Capacity");
        labelcapacity.setBounds(400, 200, 150, 30);
        labelcapacity.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcapacity);
        
        tfcapacity = new JTextField();
        tfcapacity.setBounds(600, 200, 150, 30);
        add(tfcapacity);

        JLabel labelbudget = new JLabel("Budget");
        labelbudget.setBounds(50, 250, 150, 30);
        labelbudget.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelbudget);
        
        tfbudget = new JTextField();
        tfbudget.setBounds(200, 250, 150, 30);
        add(tfbudget);

        JLabel labeltype = new JLabel("Event Type");
        labeltype.setBounds(400, 250, 150, 30);
        labeltype.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeltype);

        String[] types = {"Conference", "Workshop", "Seminar", "Concert", "Festival"};
        cbtype = new JComboBox<>(types);
        cbtype.setBackground(Color.WHITE);
        cbtype.setBounds(600, 250, 150, 30);
        add(cbtype);

        JLabel labelorganizer = new JLabel("Organizer");
        labelorganizer.setBounds(50, 300, 150, 30);
        labelorganizer.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelorganizer);

        tforganizer = new JTextField();
        tforganizer.setBounds(200, 300, 150, 30);
        add(tforganizer);

        JLabel labeleventId = new JLabel("Event ID");
        labeleventId.setBounds(50, 350, 150, 30);
        labeleventId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleventId);

        lbleventId = new JLabel("" + number);
        lbleventId.setBounds(200, 350, 150, 30);
        lbleventId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbleventId);

        add = new JButton("Add Event");
        add.setBounds(250, 450, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 450, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 600);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String venue = tfvenue.getText();
            String date = null;
            if (dcdate.getDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.format(dcdate.getDate());
            }
            String capacity = tfcapacity.getText();
            String budget = tfbudget.getText();
            String type = (String) cbtype.getSelectedItem();
            String organizer = tforganizer.getText();
            String eventId = lbleventId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "INSERT INTO event (name, venue, date, capacity, budget, type, organizer, eventId) " +
                               "VALUES ('" + name + "', '" + venue + "', '" + date + "', '" + capacity + "', '" + budget + "', '" + type + "', '" + organizer + "', '" + eventId + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Event added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
}
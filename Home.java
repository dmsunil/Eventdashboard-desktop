package eventmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton addEvent, viewEvent, removeEvent;

    Home() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Event Management System");
        heading.setBounds(100, 30, 600, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        add(heading);

        addEvent = new JButton("Add Event");
        addEvent.setBounds(150, 150, 200, 50);
        addEvent.setBackground(Color.BLACK);
        addEvent.setForeground(Color.WHITE);
        addEvent.addActionListener(this);
        add(addEvent);

        viewEvent = new JButton("View Event");
        viewEvent.setBounds(150, 250, 200, 50);
        viewEvent.setBackground(Color.BLACK);
        viewEvent.setForeground(Color.WHITE);
        viewEvent.addActionListener(this);
        add(viewEvent);

        removeEvent = new JButton("Remove Event");
        removeEvent.setBounds(150, 350, 200, 50);
        removeEvent.setBackground(Color.BLACK);
        removeEvent.setForeground(Color.WHITE);
        removeEvent.addActionListener(this);
        add(removeEvent);

        setSize(600, 600);
        setLocation(450, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addEvent) {
            setVisible(false);
            new AddEvent();
        } else if (ae.getSource() == viewEvent) {
            setVisible(false);
            new ViewEvent();
        } else if (ae.getSource() == removeEvent) {
            setVisible(false);
            new RemoveEvent();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}

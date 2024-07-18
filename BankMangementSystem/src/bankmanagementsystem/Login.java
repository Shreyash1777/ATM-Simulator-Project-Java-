package bankmanagementsystem;

import java.awt.*; //  font class is present in awt package
import java.awt.event.*;
import javax.swing.*; // to use JFrame we have to use swing becaisw JFrame is present in swing package
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JLabel text, cardno, pin;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton login, clear, signup;

    Login() {
        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 450, 40);
        add(text);

        cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(125, 150, 375, 30);
        add(cardno);

        cardTextField = new JTextField(15);
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(125, 220, 375, 30);
        add(pin);

        pinTextField = new JPasswordField(15);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300, 220, 230, 30);
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);

        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setBounds(300, 300, 100, 30);
        add(login);

        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(430, 300, 100, 30);
        add(clear);

        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBounds(300, 350, 230, 30);
        add(signup);

        login.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        setSize(800, 480); //to create frame we use this 
        setLocation(550, 200);
        setVisible(true); //this will display the frame
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            // Logic for login can be added here
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            
            String query = "select * from login where cardnumber = '" +cardnumber+ "'and pin = '"+pinnumber+"'";
            try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
            }catch(Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

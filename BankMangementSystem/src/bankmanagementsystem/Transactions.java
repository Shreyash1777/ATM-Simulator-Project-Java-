
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Transactions extends JFrame implements ActionListener{
    JLabel l1;
    JButton deposit,cashwithdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);
        
         l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
       
        deposit = new JButton("DEPOSIT");
        cashwithdrawl = new JButton("CASH WITHDRAWL");
        fastcash = new JButton("FAST CASH");
        ministatement = new JButton("MINI STATEMENT");
        pinchange = new JButton("PIN CHANGE");
        balanceenquiry = new JButton("BALANCE ENQUIRY");
        exit = new JButton("EXIT");
        
       
        
        l1.setBounds(240,350,700,35);
        image.add(l1);
        
        deposit.setBounds(170,499,150,35);
        image.add(deposit);
        
        cashwithdrawl.setBounds(390,499,150,35);
        image.add(cashwithdrawl);
        
        fastcash.setBounds(170,543,150,35);
        image.add(fastcash);
        
        ministatement.setBounds(390,543,150,35);
        image.add(ministatement);
        
        pinchange.setBounds(170,588,150,35);
        image.add(pinchange);
        
        balanceenquiry.setBounds(390,588,150,35);
        image.add(balanceenquiry);
        
        exit.setBounds(390,633,150,35);
        image.add(exit);
        
        
        deposit.addActionListener(this);
        cashwithdrawl.addActionListener(this);
        fastcash.addActionListener(this);
        ministatement.addActionListener(this);
        pinchange.addActionListener(this);
        balanceenquiry.addActionListener(this);
        exit.addActionListener(this);
        
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
               if(ae.getSource()==deposit){ 
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==cashwithdrawl){ 
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){ 
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){ 
            new MiniStatement(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){ 
            this.setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==exit){ 
            System.exit(0);
        }
    
        
    }


public static void main(String[] args){
      new Transactions("").setVisible(true);
}
}
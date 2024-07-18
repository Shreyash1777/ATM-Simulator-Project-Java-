
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
     
    JTextField t1;
    JButton deposit,back;
    JLabel l1;
    String pinnumber;
      Deposit(String pinnumber){
          
    this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        deposit = new JButton("DEPOSIT");
        back = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(190,350,400,35);
        l3.add(l1);
        
        t1.setBounds(190,420,320,25);
        l3.add(t1);
        
        deposit.setBounds(390,588,150,35);
        l3.add(deposit);
        
        back.setBounds(390,633,150,35);
        l3.add(back);
        
        deposit.addActionListener(this);
        back.addActionListener(this);
        
        setSize(960,1080);
        
        setLocation(500,0);
        setVisible(true);
          
          
          
          
          
          
          
      }
      
       public void actionPerformed(ActionEvent ae){
   try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn conn = new Conn();
                    String q1 = ("insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+amount+"')");
                    conn.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
      
      public static void main(String[] args){
        new Deposit("").setVisible(true);
    }

}

package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class SignupTwo extends JFrame implements ActionListener {
    
    
    JLabel additionaldetails, religion, category, income, edu, occupation, senior, pan, aadhar, existLabel;
    JTextField panTextField, aadharTextField;
    JComboBox<String> religionComboBox, categoryComboBox, incomeComboBox, eduComboBox, occupationComboBox;
    JRadioButton eyes, eno, syes, sno;
    ButtonGroup existGroup, seniorStatusGroup;
    String formno;
    JButton next;

    SignupTwo(String formno) {
        
        this.formno = formno;
        
        setLayout(null);
        
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 80, 600, 30);
        add(additionaldetails);

        // Religion
        String[] valReligion = {"Hindu", "Sikh", "Jain", "Christian", "Muslim", "Other"};
        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        religionComboBox = new JComboBox<>(valReligion);
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setBounds(300, 140, 400, 30);
        add(religionComboBox);

        // Category
        String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        categoryComboBox = new JComboBox<>(valCategory);
        categoryComboBox.setBackground(Color.WHITE);
        categoryComboBox.setBounds(300, 190, 400, 30);
        add(categoryComboBox);

        // Income
        String[] valIncome = {"Less than 1 Lakh", "1-2 Lakhs", "2-4 Lakhs", "4-8 Lakhs", "More than 8 Lakhs"};
        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        incomeComboBox = new JComboBox<>(valIncome);
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setBounds(300, 240, 400, 30);
        add(incomeComboBox);

        // Education
        String[] valEdu = {"Non-graduate", "Graduate", "Post-Graduate", "Doctorate"};
        edu = new JLabel("Education:");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);

        eduComboBox = new JComboBox<>(valEdu);
        eduComboBox.setBackground(Color.WHITE);
        eduComboBox.setBounds(300, 290, 400, 30);
        add(eduComboBox);

        // Occupation
        String[] valOccupation = {"Student", "Business", "Self-Employed", "Retired", "Other"};
        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);

        occupationComboBox = new JComboBox<>(valOccupation);
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setBounds(300, 340, 400, 30);
        add(occupationComboBox);

        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 390, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 440, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        existLabel = new JLabel("Existing Account:");
        existLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existLabel.setBounds(100, 490, 200, 30);
        add(existLabel);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 490, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 490, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        existGroup = new ButtonGroup();
        existGroup.add(eyes);
        existGroup.add(eno);

        senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        seniorStatusGroup = new ButtonGroup();
        seniorStatusGroup.add(syes);
        seniorStatusGroup.add(sno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(500, 120);
        setVisible(true);
        setUndecorated(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String) religionComboBox.getSelectedItem();
        String scategory = (String) categoryComboBox.getSelectedItem();
        String sincome = (String) incomeComboBox.getSelectedItem();
        String sedu = (String) eduComboBox.getSelectedItem();
        String soccupation = (String) occupationComboBox.getSelectedItem();
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        String sexist = null;
        if (eyes.isSelected()) {
            sexist = "Yes";
        } else if (eno.isSelected()) {
            sexist = "No";
        }

        String ssenior = null;
        if (syes.isSelected()) {
            ssenior = "Yes";
        } else if (sno.isSelected()) {
            ssenior = "No";
        }

        try {
            if (sreligion == null || sreligion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Religion is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "','" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + sedu + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + ssenior + "', '" + sexist + "')";
                c.s.executeUpdate(query);
                
                //signup3
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("").setVisible(true);
    }
}

package BloodBankManagementSystem;



import ProjBack.ConnectionProvider;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.UIManager.*;
import java.sql.*;
import java.sql.ResultSet;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cherry
 */
@SuppressWarnings("serial")
public class SellBlood extends JFrame {
    public static String bg;
    /**
     * Creates new form donateBlood
     */
    public SellBlood() {
    	if (Login.isAdminUser) {
    		initComponents();
    	}    }

 private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        pName = new JTextField();
        jLabel3 = new JLabel();
        pDob = new com.toedter.calendar.JDateChooser();
        jLabel4 = new JLabel();
        pMobile = new JTextField();
        jLabel5 = new JLabel();
        pGender = new JComboBox<>();
        jLabel6 = new JLabel();
        pEmail = new JTextField();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jScrollPane1 = new JScrollPane();
        pAddress = new JTextArea();
        jLabel9 = new JLabel();
        pCity = new JTextField();
        jSeparator2 = new JSeparator();
        submitBtn = new JButton();
        closeBtn = new JButton();
        resetBtn = new JButton();
        jLabel10 = new JLabel();
        pBloodGrp = new JComboBox<>();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(270, 90));
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Candara", 1, 30)); 
        jLabel1.setText("Blood Donated To");
        getContentPane().add(jLabel1, new AbsoluteConstraints(292, 18, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 66, 801, 10));

        jLabel2.setFont(new Font("Candara", 1, 14)); 
        jLabel2.setText("Full Name");
        getContentPane().add(jLabel2, new AbsoluteConstraints(53, 119, -1, -1));

        pName.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(pName, new AbsoluteConstraints(178, 116, 170, -1));

        jLabel3.setFont(new Font("Candara", 1, 14)); 
        jLabel3.setText("Date of Purchase");
        getContentPane().add(jLabel3, new AbsoluteConstraints(53, 160, -1, -1));

        pDob.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(pDob, new AbsoluteConstraints(178, 158, 170, -1));

        jLabel4.setFont(new Font("Candara", 1, 14)); 
        jLabel4.setText("Mobile No.");
        getContentPane().add(jLabel4, new AbsoluteConstraints(53, 199, -1, -1));

        pMobile.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(pMobile, new AbsoluteConstraints(178, 196, 170, -1));

        jLabel5.setFont(new Font("Candara", 1, 14)); 
        jLabel5.setText("Gender");
        getContentPane().add(jLabel5, new AbsoluteConstraints(53, 241, -1, -1));

        pGender.setFont(new Font("Candara", 0, 14)); 
        pGender.setModel(new DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        pGender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pGenderActionPerformed(evt);
            }
        });
        getContentPane().add(pGender, new AbsoluteConstraints(178, 238, 170, -1));

        jLabel6.setFont(new Font("Candara", 1, 14)); 
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new AbsoluteConstraints(53, 283, -1, -1));

        pEmail.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(pEmail, new AbsoluteConstraints(178, 280, 170, -1));

        jLabel7.setFont(new Font("Candara", 1, 14)); 
        jLabel7.setText("Blood Group");
        getContentPane().add(jLabel7, new AbsoluteConstraints(472, 119, -1, -1));

        jLabel8.setFont(new Font("Candara", 1, 14)); 
        jLabel8.setText("Address");
        getContentPane().add(jLabel8, new AbsoluteConstraints(472, 158, -1, -1));

        pAddress.setColumns(20);
        pAddress.setFont(new Font("Candara", 0, 14)); 
        pAddress.setRows(5);
        jScrollPane1.setViewportView(pAddress);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(572, 158, 170, -1));

        jLabel9.setFont(new Font("Candara", 1, 14)); 
        jLabel9.setText("City");
        getContentPane().add(jLabel9, new AbsoluteConstraints(472, 283, -1, -1));

        pCity.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(pCity, new AbsoluteConstraints(572, 280, 170, -1));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 365, 801, 10));

        submitBtn.setBackground(new Color(0, 204, 0));
        submitBtn.setFont(new Font("Candara", 1, 18)); 
        submitBtn.setForeground(new Color(255, 255, 255));
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn, new AbsoluteConstraints(150, 410, 103, 45));

        closeBtn.setBackground(new Color(255, 51, 51));
        closeBtn.setFont(new Font("Candara", 1, 18)); 
        closeBtn.setForeground(new Color(255, 255, 255));
        closeBtn.setText("Cancel");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(600, 410, 103, 45));

        resetBtn.setBackground(new Color(51, 153, 255));
        resetBtn.setFont(new Font("Candara", 1, 18)); 
        resetBtn.setForeground(new Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        getContentPane().add(resetBtn, new AbsoluteConstraints(390, 410, 103, 45));
        getContentPane().add(jLabel10, new AbsoluteConstraints(10, 40, -1, -1));

        pBloodGrp.setFont(new Font("Candara", 0, 14)); 
        pBloodGrp.setModel(new DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        getContentPane().add(pBloodGrp, new AbsoluteConstraints(572, 119, 170, -1));
        getContentPane().add(jLabel11, new AbsoluteConstraints(0, 0, -1, -1));

        jLabel12.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        getContentPane().add(jLabel12, new AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void pGenderActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void closeBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
    }

    private void resetBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
        new SellBlood().setVisible(true);
    }

    private void submitBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        String name = pName.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dob = dFormat.format(pDob.getDate());
//        String dob = pDob.getDate().toString();
        String mobileNo = pMobile.getText();
        String gender = (String)pGender.getSelectedItem();
        String email = pEmail.getText();
        String bloodGrp = (String)pBloodGrp.getSelectedItem();
        String address = pAddress.getText();
        String city = pCity.getText();
        
        
        try{
            Connection conn = ConnectionProvider.getCon();
//            Statement stat = conn.createStatement();
//            stat.executeUpdate("insert into donatedblood(name, dateOfPurchase, mobileNo, gender, email, bloodGrp, address, city ) values ('" +name+ "', '" +dob+ "', '" +mobileNo+ "', '" +gender+ "', '" +email+ "', '" +bloodGrp+ "', '" +address+ "', '" +city+ "')");
//            
            PreparedStatement stat = conn.prepareStatement("insert into patientdetails (name, dateOfPurchase, mobileNo, gender, email, bloodGrp, address, city ) values(?, ?, ?, ?, ?, ?, ?, ?)");
            stat.setString(1, name);
            stat.setString(2, dob);
            stat.setString(3, mobileNo);
            stat.setString(4, gender);
            stat.setString(5, email);
            stat.setString(6, bloodGrp);
            stat.setString(7, address);
            stat.setString(8, city);
            
            stat.executeUpdate();
            
            bg = pBloodGrp.getSelectedItem().toString();
            if (bg.equals("A+")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("A-")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("B+")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("B-")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("O+")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("O-")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("AB+")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }
            if (bg.equals("AB-")) {
                stat = conn.prepareStatement("select packetsofBlood from bloodquantity where bloodGrp='"+bg+"'");
            }

            ResultSet rs = stat.executeQuery();
            rs.next();
            int pkno = rs.getInt(1);
            if (pkno == 0) {
                JOptionPane.showMessageDialog(this, "Not Available", "Empty", JOptionPane.PLAIN_MESSAGE);
            }
            
            else {
                pkno -= 1;
                stat = conn.prepareStatement("update bloodquantity set packetsofBlood=? where bloodGrp=?");
                stat.setInt(1, pkno);
                stat.setString(2, bg);
                this.dispose();
                stat.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Patient's Details Added Successfully, Blood Packet ready to dispatch");
            }
            setVisible(false);
            new SellBlood().setVisible(true);
        }
            
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void createLookAndFeel() {
    	try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (InstantiationException ex) {
			System.err.println(ex);
		} catch (IllegalAccessException ex) {
			System.err.println(ex);
		} catch (UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}
	}

    public static void main(String args[]) {
    	/* Create and display the form */
    	if (Login.isAdminUser == true) {
        	createLookAndFeel();

    		EventQueue.invokeLater(new Runnable() {
                public void run() {
                	
                    new SellBlood().setVisible(true);
                }
            });
		} else {
			System.out.println("You are not an Admin User");
		}
    	
    }

    // Variables declaration - do not modify
    private JButton closeBtn;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextArea pAddress;
    private JComboBox<String> pBloodGrp;
    private JTextField pCity;
    private com.toedter.calendar.JDateChooser pDob;
    private JTextField pEmail;
    private JComboBox<String> pGender;
    private JTextField pMobile;
    private JTextField pName;
    private JButton resetBtn;
    private JButton submitBtn;
    // End of variables declaration
}

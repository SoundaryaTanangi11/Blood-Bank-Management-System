package BloodBankManagementSystem;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ProjBack.ConnectionProvider;
import javax.swing.*;
import javax.swing.UIManager.*;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@SuppressWarnings("serial")
public class DeleteDonor extends JFrame {

    /**
     * Creates new form deleteDonor
     */
    public DeleteDonor() {
    	if (Login.isAdminUser) {
    		initComponents();
    	}
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        donorId = new JTextField();
        searchBtn = new JButton();
        jSeparator2 = new JSeparator();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        dName = new JTextField();
        dFname = new JTextField();
        dMname = new JTextField();
        dDob = new JTextField();
        dMobile = new JTextField();
        dGender = new JTextField();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        dEmail = new JTextField();
        dBloodGrp = new JTextField();
        dCity = new JTextField();
        jScrollPane1 = new JScrollPane();
        dAddress = new JTextArea();
        jSeparator3 = new JSeparator();
        deleteBtn = new JButton();
        resetBtn = new JButton();
        closeBtn = new JButton();
        jLabel13 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(270, 90));
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Candara", 1, 30)); 
        jLabel1.setText("Delete Donor");
        getContentPane().add(jLabel1, new AbsoluteConstraints(335, 16, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 59, 801, 10));

        jLabel2.setFont(new Font("Candara", 1, 14)); 
        jLabel2.setText("Donor Id");
        getContentPane().add(jLabel2, new AbsoluteConstraints(236, 92, -1, -1));

        donorId.setFont(new Font("Candara", 1, 14)); 
        donorId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                donorIdActionPerformed(evt);
            }
        });
        getContentPane().add(donorId, new AbsoluteConstraints(355, 89, 111, -1));

        searchBtn.setBackground(new Color(255, 255, 153));
        searchBtn.setFont(new Font("Candara", 1, 16)); 
        searchBtn.setText("Search");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        getContentPane().add(searchBtn, new AbsoluteConstraints(550, 87, 80, 30));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 134, 801, 10));

        jLabel3.setFont(new Font("Candara", 1, 14)); 
        jLabel3.setText("Full Name");
        getContentPane().add(jLabel3, new AbsoluteConstraints(60, 165, -1, -1));

        jLabel4.setFont(new Font("Candara", 1, 14)); 
        jLabel4.setText("Father's Name");
        getContentPane().add(jLabel4, new AbsoluteConstraints(60, 204, -1, -1));

        jLabel5.setFont(new Font("Candara", 1, 14)); 
        jLabel5.setText("Mother's Name");
        getContentPane().add(jLabel5, new AbsoluteConstraints(60, 243, -1, -1));

        jLabel6.setFont(new Font("Candara", 1, 14)); 
        jLabel6.setText("Date of Birth");
        getContentPane().add(jLabel6, new AbsoluteConstraints(60, 282, -1, -1));

        jLabel7.setFont(new Font("Candara", 1, 14)); 
        jLabel7.setText("Mobile No.");
        getContentPane().add(jLabel7, new AbsoluteConstraints(60, 321, -1, -1));

        jLabel8.setFont(new Font("Candara", 1, 14)); 
        jLabel8.setText("Gender");
        getContentPane().add(jLabel8, new AbsoluteConstraints(60, 360, -1, -1));

        dName.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dName, new AbsoluteConstraints(193, 162, 170, -1));

        dFname.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dFname, new AbsoluteConstraints(193, 201, 170, -1));

        dMname.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dMname, new AbsoluteConstraints(193, 240, 170, -1));

        dDob.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dDob, new AbsoluteConstraints(193, 279, 170, -1));

        dMobile.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dMobile, new AbsoluteConstraints(193, 318, 170, -1));

        dGender.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dGender, new AbsoluteConstraints(193, 357, 170, -1));

        jLabel9.setFont(new Font("Candara", 1, 14)); 
        jLabel9.setText("Email");
        getContentPane().add(jLabel9, new AbsoluteConstraints(479, 165, -1, -1));

        jLabel10.setFont(new Font("Candara", 1, 14)); 
        jLabel10.setText("Blood Group");
        getContentPane().add(jLabel10, new AbsoluteConstraints(479, 204, -1, -1));

        jLabel11.setFont(new Font("Candara", 1, 14)); 
        jLabel11.setText("Address");
        getContentPane().add(jLabel11, new AbsoluteConstraints(479, 240, -1, -1));

        jLabel12.setFont(new Font("Candara", 1, 14)); 
        jLabel12.setText("City");
        getContentPane().add(jLabel12, new AbsoluteConstraints(479, 354, 34, -1));

        dEmail.setFont(new Font("Candara", 0, 14)); 
        dEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dEmailActionPerformed(evt);
            }
        });
        getContentPane().add(dEmail, new AbsoluteConstraints(590, 162, 170, -1));

        dBloodGrp.setFont(new Font("Candara", 0, 14)); 
        dBloodGrp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dBloodGrpActionPerformed(evt);
            }
        });
        getContentPane().add(dBloodGrp, new AbsoluteConstraints(590, 201, 170, -1));

        dCity.setFont(new Font("Candara", 0, 14)); 
        dCity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dCityActionPerformed(evt);
            }
        });
        getContentPane().add(dCity, new AbsoluteConstraints(590, 351, 170, -1));

        dAddress.setColumns(20);
        dAddress.setFont(new Font("Candara", 0, 14)); 
        dAddress.setRows(5);
        jScrollPane1.setViewportView(dAddress);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(590, 240, 170, -1));
        getContentPane().add(jSeparator3, new AbsoluteConstraints(10, 410, 801, 10));

        deleteBtn.setBackground(new Color(0, 153, 0));
        deleteBtn.setFont(new Font("Candara", 1, 18)); 
        deleteBtn.setForeground(new Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBtn, new AbsoluteConstraints(180, 440, 90, 40));

        resetBtn.setBackground(new Color(0, 153, 255));
        resetBtn.setFont(new Font("Candara", 1, 18)); 
        resetBtn.setForeground(new Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        getContentPane().add(resetBtn, new AbsoluteConstraints(400, 440, 90, 40));

        closeBtn.setBackground(new Color(255, 0, 0));
        closeBtn.setFont(new Font("Candara", 1, 18)); 
        closeBtn.setForeground(new Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(610, 440, 90, 40));

        jLabel13.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        getContentPane().add(jLabel13, new AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void dEmailActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dBloodGrpActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dCityActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void closeBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
    }

    private void resetBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
        new DeleteDonor().setVisible(true);
    }

    private void searchBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        String dId = donorId.getText();
        
        try {
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("Select * from donor where donorId='" +dId+"'");
            if (rs.next()) {
                dName.setText(rs.getString(2)); 
                dFname.setText(rs.getString(3));
                dMname.setText(rs.getString(4));
                dDob.setText(rs.getString(5));
                dMobile.setText(rs.getString(6));
                dGender.setText(rs.getString(7));
                dEmail.setText(rs.getString(8));
                dBloodGrp.setText(rs.getString(9));
                dAddress.setText(rs.getString(10));
                dCity.setText(rs.getString(11));
                donorId.setEditable(false);
                // all field not editable
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Donor Id does not exist");
            }
        }
        catch(Exception e) {
            
        }
    }

    private void deleteBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        String dId = donorId.getText();
        try {
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            stat.executeUpdate("delete from donor where donorId='" +dId+"'");
            JOptionPane.showMessageDialog(null, "Sad to know !\nDonor details deleted Successfully");
            setVisible(false);
            new DeleteDonor().setVisible(true);
            
        }
        catch(Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }

    private void donorIdActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
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
                	 new DeleteDonor().setVisible(true);	 
                }
            });
		} else {
			System.out.println("You are not an Admin User");
		}
        
    }

    // Variables declaration - do not modify
    private JButton closeBtn;
    private JTextArea dAddress;
    private JTextField dBloodGrp;
    private JTextField dCity;
    private JTextField dDob;
    private JTextField dEmail;
    private JTextField dFname;
    private JTextField dGender;
    private JTextField dMname;
    private JTextField dMobile;
    private JTextField dName;
    private JButton deleteBtn;
    private JTextField donorId;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
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
    private JSeparator jSeparator3;
    private JButton resetBtn;
    private JButton searchBtn;
    // End of variables declaration
}

package BloodBankManagementSystem;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ProjBack.ConnectionProvider;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager.*;
import javax.swing.UnsupportedLookAndFeelException;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SuppressWarnings("serial")
public class UpdateDonorDetails extends JFrame {


    /**
     * Creates new form updateDonorDetails
     */
    public UpdateDonorDetails() {
    	if (Login.isAdminUser) {
    		initComponents();
    	}    }

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
        dMobile = new JTextField();
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
        updateBtn = new JButton();
        resetBtn = new JButton();
        closeBtn = new JButton();
        dDob = new com.toedter.calendar.JDateChooser();
        dGender = new JTextField();
        jLabel15 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(270, 90));
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Candara", 1, 30));
        jLabel1.setText("Update Donor Details");
        getContentPane().add(jLabel1, new AbsoluteConstraints(274, 11, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 59, 800, 10));

        jLabel2.setFont(new Font("Candara", 1, 14));
        jLabel2.setText("Donor Id");
        getContentPane().add(jLabel2, new AbsoluteConstraints(217, 92, -1, -1));

        donorId.setFont(new Font("Candara", 1, 14));
        donorId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                donorIdActionPerformed(evt);
            }
        });
        getContentPane().add(donorId, new AbsoluteConstraints(335, 89, 100, -1));

        searchBtn.setBackground(new Color(255, 255, 204));
        searchBtn.setFont(new Font("Candara", 1, 14));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        getContentPane().add(searchBtn, new AbsoluteConstraints(510, 90, -1, -1));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 134, 800, 10));

        jLabel3.setFont(new Font("Candara", 1, 14));
        jLabel3.setText("Full Name");
        getContentPane().add(jLabel3, new AbsoluteConstraints(56, 165, -1, -1));

        jLabel4.setFont(new Font("Candara", 1, 14));
        jLabel4.setText("Father's Name");
        getContentPane().add(jLabel4, new AbsoluteConstraints(56, 207, -1, -1));

        jLabel5.setFont(new Font("Candara", 1, 14));
        jLabel5.setText("Mother's Name");
        getContentPane().add(jLabel5, new AbsoluteConstraints(56, 249, -1, -1));

        jLabel6.setFont(new Font("Candara", 1, 14));
        jLabel6.setText("Date of Birth ");
        getContentPane().add(jLabel6, new AbsoluteConstraints(56, 288, -1, -1));

        jLabel7.setFont(new Font("Candara", 1, 14));
        jLabel7.setText("Mobile No.");
        getContentPane().add(jLabel7, new AbsoluteConstraints(56, 329, -1, -1));

        jLabel8.setFont(new Font("Candara", 1, 14));
        jLabel8.setText("Gender");
        getContentPane().add(jLabel8, new AbsoluteConstraints(56, 371, -1, -1));

        dName.setFont(new Font("Candara", 0, 14));
        getContentPane().add(dName, new AbsoluteConstraints(194, 162, 170, -1));

        dFname.setFont(new Font("Candara", 0, 14));
        getContentPane().add(dFname, new AbsoluteConstraints(194, 204, 170, -1));

        dMname.setFont(new Font("Candara", 0, 14));
        getContentPane().add(dMname, new AbsoluteConstraints(194, 246, 170, -1));

        dMobile.setFont(new Font("Candara", 0, 14));
        dMobile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dMobileActionPerformed(evt);
            }
        });
        getContentPane().add(dMobile, new AbsoluteConstraints(194, 326, 170, -1));

        jLabel9.setFont(new Font("Candara", 1, 14));
        jLabel9.setText("Email");
        getContentPane().add(jLabel9, new AbsoluteConstraints(466, 165, -1, -1));

        jLabel10.setFont(new Font("Candara", 1, 14));
        jLabel10.setText("Blood Group");
        getContentPane().add(jLabel10, new AbsoluteConstraints(466, 207, -1, -1));

        jLabel11.setFont(new Font("Candara", 1, 14));
        jLabel11.setText("Address");
        getContentPane().add(jLabel11, new AbsoluteConstraints(466, 249, -1, -1));

        jLabel12.setFont(new Font("Candara", 1, 14));
        jLabel12.setText("City");
        getContentPane().add(jLabel12, new AbsoluteConstraints(466, 371, -1, -1));

        dEmail.setFont(new Font("Candara", 0, 14));
        dEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dEmailActionPerformed(evt);
            }
        });
        getContentPane().add(dEmail, new AbsoluteConstraints(596, 162, 170, -1));

        dBloodGrp.setFont(new Font("Candara", 0, 14));
        getContentPane().add(dBloodGrp, new AbsoluteConstraints(596, 204, 170, -1));

        dCity.setFont(new Font("Candara", 0, 14));
        getContentPane().add(dCity, new AbsoluteConstraints(596, 368, 170, -1));

        dAddress.setColumns(20);
        dAddress.setFont(new Font("Candara", 0, 14));
        dAddress.setRows(5);
        jScrollPane1.setViewportView(dAddress);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(596, 246, 170, -1));
        getContentPane().add(jSeparator3, new AbsoluteConstraints(10, 422, 812, 10));

        updateBtn.setBackground(new Color(51, 153, 0));
        updateBtn.setFont(new Font("Candara", 1, 18));
        updateBtn.setForeground(new Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new AbsoluteConstraints(160, 440, 100, 40));

        resetBtn.setBackground(new Color(0, 153, 204));
        resetBtn.setFont(new Font("Candara", 1, 18));
        resetBtn.setForeground(new Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        getContentPane().add(resetBtn, new AbsoluteConstraints(390, 440, 100, 40));

        closeBtn.setBackground(new Color(255, 0, 0));
        closeBtn.setFont(new Font("Candara", 1, 18));
        closeBtn.setForeground(new Color(255, 255, 255));
        closeBtn.setText("Cancel");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(620, 440, 100, 40));

        dDob.setFont(new Font("Candara", 0, 14));
        getContentPane().add(dDob, new AbsoluteConstraints(194, 285, 170, -1));

        dGender.setFont(new Font("Candara", 0, 14));
        dGender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dGenderActionPerformed(evt);
            }
        });
        getContentPane().add(dGender, new AbsoluteConstraints(194, 368, 170, -1));

        jLabel15.setIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\allformsbg.png"));
        getContentPane().add(jLabel15, new AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void donorIdActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dMobileActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dEmailActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void closeBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
    }

    private void resetBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
        new UpdateDonorDetails().setVisible(true);
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
                dDob.setDate(rs.getDate(5));
                dMobile.setText(rs.getString(6));
                dGender.setText(rs.getString(7));
                dEmail.setText(rs.getString(8));
                dBloodGrp.setText(rs.getString(9));
                dAddress.setText(rs.getString(10));
                dCity.setText(rs.getString(11));
                donorId.setEditable(false);
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Donor Id does not exist");
            }
        }
        catch(Exception e) {
            
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void dGenderActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void updateBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    	long dId = Long.parseLong(donorId.getText());
        String name = dName.getText();
        String fatherName = dFname.getText();
        String motherName = dMname.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dob = dFormat.format(dDob.getDate());
       // String dob = dDob.getText();
        long mobileNo = Long.parseLong(dMobile.getText());
        String gender = dGender.getText();
        String email = dEmail.getText();
        String bloodGrp = dBloodGrp.getText();
        String address = dAddress.getText();
        String city = dCity.getText();
        
        
        try{
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            System.out.println("update Donor set name='" +name+ 
            		"',fatherName='" +fatherName+
            		"',motherName='" +motherName+ 
            		"',DOB='" +dob+
            		"',mobileNo=" +mobileNo+ 
            		",gender='" +gender+ 
            		"',email='" +email+ 
            		"',bloodGrp='" +bloodGrp+ 
            		"',address='" +address+
            		"',city='" +city+ 
            		"' where donorId="+dId+"");
            stat.executeUpdate("update Donor set name='" +name+ 
            		"',fatherName='" +fatherName+
            		"',motherName='" +motherName+ 
            		"',DOB='" +dob+
            		"',mobileNo='" +mobileNo+ 
            		"',gender='" +gender+ 
            		"',email='" +email+ 
            		"',bloodGrp='" +bloodGrp+ 
            		"',address='" +address+
            		"',city='" +city+ 
            		"' where donorId='"+dId+"'");
            JOptionPane.showMessageDialog(null, "Donor details updated Successfully");
            setVisible(false);
            new UpdateDonorDetails().setVisible(true);
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
                	
                    new UpdateDonorDetails().setVisible(true);
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
    private com.toedter.calendar.JDateChooser dDob;
    private JTextField dEmail;
    private JTextField dFname;
    private JTextField dGender;
    private JTextField dMname;
    private JTextField dMobile;
    private JTextField dName;
    private JTextField donorId;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel15;
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
    private JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

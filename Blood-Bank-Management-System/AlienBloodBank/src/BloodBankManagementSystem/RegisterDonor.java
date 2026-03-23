package BloodBankManagementSystem;

import ProjBack.ConnectionProvider;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.UIManager.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import com.toedter.calendar.*;


@SuppressWarnings("serial")
public class RegisterDonor extends JFrame {

    /**
     * Creates new form registerDonor
     */
    public RegisterDonor() {
    	if (Login.isAdminUser) {
    		initComponents();
    	}    }

   private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        dName = new JTextField();
        jLabel3 = new JLabel();
        dDob = new com.toedter.calendar.JDateChooser();
        jLabel4 = new JLabel();
        dBloodGrp = new JComboBox<>();
        jLabel5 = new JLabel();
        dMobile = new JTextField();
        jLabel6 = new JLabel();
        dEmail = new JTextField();
        jSeparator2 = new JSeparator();
        jLabel7 = new JLabel();
        dCity = new JTextField();
        registerBtn = new JButton();
        resetBtn = new JButton();
        closeBtn = new JButton();
        jLabel9 = new JLabel();
        jLabel8 = new JLabel();
        jLabel12 = new JLabel();
        jLabel11 = new JLabel();
        jLabel13 = new JLabel();
        jLabel10 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(270, 90));
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Candara", 1, 30)); 
        jLabel1.setText("Register for Blood Donation Campaign");
        getContentPane().add(jLabel1, new AbsoluteConstraints(173, 18, -1, -1));
        getContentPane().add(jSeparator1, new AbsoluteConstraints(10, 66, 801, 12));

        jLabel2.setFont(new Font("Candara", 1, 14)); 
        jLabel2.setText("Full Name");
        getContentPane().add(jLabel2, new AbsoluteConstraints(71, 106, -1, -1));

        dName.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dName, new AbsoluteConstraints(188, 103, 170, -1));

        jLabel3.setFont(new Font("Candara", 1, 14)); 
        jLabel3.setText("Date of Birth");
        getContentPane().add(jLabel3, new AbsoluteConstraints(71, 147, -1, -1));

        dDob.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dDob, new AbsoluteConstraints(188, 145, 170, -1));

        jLabel4.setFont(new Font("Candara", 1, 14)); 
        jLabel4.setText("Blood Group");
        getContentPane().add(jLabel4, new AbsoluteConstraints(71, 186, -1, -1));

        dBloodGrp.setFont(new Font("Candara", 1, 14)); 
        dBloodGrp.setModel(new DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        getContentPane().add(dBloodGrp, new AbsoluteConstraints(188, 183, 170, -1));

        jLabel5.setFont(new Font("Candara", 1, 14)); 
        jLabel5.setText("Mobile No.");
        getContentPane().add(jLabel5, new AbsoluteConstraints(71, 228, -1, -1));

        dMobile.setFont(new Font("Candara", 0, 14)); 
        getContentPane().add(dMobile, new AbsoluteConstraints(188, 225, 170, -1));

        jLabel6.setFont(new Font("Candara", 1, 14)); 
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new AbsoluteConstraints(71, 270, 34, -1));

        dEmail.setFont(new Font("Candara", 0, 14)); 
        dEmail.setToolTipText("");
        dEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dEmailActionPerformed(evt);
            }
        });
        getContentPane().add(dEmail, new AbsoluteConstraints(188, 267, 170, -1));
        getContentPane().add(jSeparator2, new AbsoluteConstraints(10, 410, 801, 10));

        jLabel7.setFont(new Font("Candara", 1, 14)); 
        jLabel7.setText("City");
        getContentPane().add(jLabel7, new AbsoluteConstraints(71, 312, 34, -1));

        dCity.setFont(new Font("Candara", 0, 14)); 
        dCity.setToolTipText("");
        dCity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dCityActionPerformed(evt);
            }
        });
        getContentPane().add(dCity, new AbsoluteConstraints(188, 309, 170, -1));

        registerBtn.setBackground(new Color(51, 153, 0));
        registerBtn.setFont(new Font("Candara", 1, 18)); 
        registerBtn.setForeground(new Color(255, 255, 255));
        registerBtn.setText("Register");
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(registerBtn, new AbsoluteConstraints(120, 440, 110, 40));

        resetBtn.setBackground(new Color(0, 153, 255));
        resetBtn.setFont(new Font("Candara", 1, 18)); 
        resetBtn.setForeground(new Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        getContentPane().add(resetBtn, new AbsoluteConstraints(390, 440, 100, 40));

        closeBtn.setBackground(new Color(255, 0, 51));
        closeBtn.setFont(new Font("Candara", 1, 18)); 
        closeBtn.setForeground(new Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new AbsoluteConstraints(630, 440, 90, 40));
        getContentPane().add(jLabel9, new AbsoluteConstraints(606, 103, 34, -1));

        jLabel8.setFont(new Font("Candara", 1, 18)); 
        jLabel8.setText("Date - 12 Dec 2023     Venue - Sipna College,Amravati     Time - 7am to 7pm");
        getContentPane().add(jLabel8, new AbsoluteConstraints(110, 370, -1, -1));
        getContentPane().add(jLabel12, new AbsoluteConstraints(482, 103, -1, -1));
        getContentPane().add(jLabel11, new AbsoluteConstraints(0, 0, -1, -1));

        jLabel13.setIcon(new ImageIcon(getClass().getResource("/Images/bfl1.gif"))); 
        getContentPane().add(jLabel13, new AbsoluteConstraints(530, 100, -1, -1));

        jLabel10.setIcon(new ImageIcon(getClass().getResource("/Images/allformsbg.png"))); 
        jLabel10.setText("\\");
            getContentPane().add(jLabel10, new AbsoluteConstraints(0, 0, 820, -1));

            pack();
        }

    private void dEmailActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_dEmailActionPerformed

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
        new RegisterDonor().setVisible(true);
    }

    private void registerBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        String name = dName.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dob = dFormat.format(dDob.getDate());
        String bloodGrp = (String)dBloodGrp.getSelectedItem();
        String mobileNo = dMobile.getText();
        String email = dEmail.getText();
        String city = dCity.getText();

      
        		
        try{
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            System.out.println("insert into donationCampDonors (name, DOB, BloodGrp, mobileNo, "
            		+ "email, city ) values "
            		+ "('" +name+ "', DATE_FORMAT("+dob+ ",'%m-%d-%Y') ,'"
            	//	+dob+ "', '" 
            		+bloodGrp+ "', "
            		+ "'" +mobileNo+ "', '" 
            		+email+ "', '" 
            		+city+ "')");
       
            
            stat.executeUpdate("insert into donationCampDonors (name, DOB, BloodGrp, mobileNo, "
            		+ "email, city ) values "
            		+ "('" +name+ "', to_date( '"+dob+ "','DD-MM-YY') ,'"
            	//	+dob+ "', '" 
            		+bloodGrp+ "', "
            		+ "'" +mobileNo+ "', '" 
            		+email+ "', '" 
            		+city+ "')");    
            JOptionPane.showMessageDialog(null, "Registration Successful! Thank You");
            setVisible(false);
            new Home().setVisible(true);
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
                	
                    new RegisterDonor().setVisible(true);
                }
            });
		} else {
			System.out.println("You are not an Admin User");
		}
        
    }

    // Variables declaration - do not modify
    private JButton closeBtn;
    private JComboBox<String> dBloodGrp;
    private JTextField dCity;
    private JDateChooser dDob;
    private JTextField dEmail;
    private JTextField dMobile;
    private JTextField dName;
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
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JButton registerBtn;
    private JButton resetBtn;
    // End of variables declaration
}
